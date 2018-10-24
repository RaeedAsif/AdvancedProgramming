
import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;


public class ser {
    
	public static String dec;
	public static void main(String args[]) throws IOException, Exception
	{
        try{

    		ServerSocket s1 = new ServerSocket(5500);
    		Socket ss = s1.accept();
                    
    		Scanner sc = new Scanner(ss.getInputStream());
    		
    		String algo = sc.nextLine();
    		System.out.println(algo);        
    		
    		String key = sc.nextLine();
    		System.out.println(key);
                    
    		int hash = sc.nextInt();
    		System.out.println(hash);
            
    		Scanner sc1 = new Scanner(ss.getInputStream());
    		
            String enc = sc1.nextLine();
            System.out.println(enc);
           
            
            String out = testDecrypt(algo,enc,key);
            int hash2 = out.hashCode();
            if(hash2 == hash)
            	System.out.println("Sucess!");
            else
            	System.out.println("You are worthless, Try again!");
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
	}
        
        static String testDecrypt(String algo, String enc, String key) throws Exception {
    
            if(algo.equals("aes")){
                DecryptionStrategy aesStrategy=new AesEncryptionStrategy();
                Decryptor aesEncryptor=new Decryptor(aesStrategy);
                aesEncryptor.setPlainText(enc);
                aesEncryptor.setKey(key);
                return aesEncryptor.encrypt();
            }
            else if(algo.equals("blowfish")){
                DecryptionStrategy blowfishStrategy=new BlowfishEncryptionStrategy();
                Decryptor blowfishEncryptor=new Decryptor(blowfishStrategy);
                blowfishEncryptor.setPlainText(enc);
                blowfishEncryptor.setKey(key);
                return blowfishEncryptor.encrypt();
            }
            else if(algo.equals("tdes")){
            	DecryptionStrategy tripleDESStrategy=new TripleDESEncryptionStrategy();
                Decryptor tripleDESEncryptor=new Decryptor(tripleDESStrategy);
                tripleDESEncryptor.setPlainText(enc);
                tripleDESEncryptor.setKey(key);
                return tripleDESEncryptor.encrypt();
            }
			return "Error";
    }
	
}