
package lab.pkg4;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.security.MessageDigest;
import java.util.Scanner;


public class Client {

        public static int hash;
	public static String enc;
        public static void main(String args[]) throws UnknownHostException, IOException, Exception
	{
            try {
                int h;
                String algo, message,key,e;
                
		Scanner sc = new Scanner(System.in);
                
		Socket s = new Socket("10.7.16.24",5500);// server ip address
                PrintStream p = new PrintStream(s.getOutputStream()); //output stream
                
		System.out.println("Enter algorithim(aes/blowfish/tdes)");
                algo = sc.nextLine();
		p.println(algo);//outstream to server
                
                System.out.println("Enter cryp key(aes/bf -> 16 bytes & tdes ->128 bytes)");
                key = sc.nextLine();
		p.println(key);
               
                System.out.println("Enter Message");
                message = sc.nextLine();
                
                h = message.hashCode();
                p.println(h);
                System.out.println(h);
                
                testEncrypt(algo,message,key);
                System.out.println("1");
               
                PrintStream p1 = new PrintStream(s.getOutputStream());
                p1.println(enc);
            }
            catch(Exception ex){
                ex.printStackTrace();
            }
                
	}

        static void testEncrypt(String algo, String message, String key) throws Exception {

                if(algo.equals("aes")){
                     EncryptionStrategy aesStrategy=new AesEncryptionStrategy();
                     Encryptor aesEncryptor=new Encryptor(aesStrategy);
                     aesEncryptor.setPlainText(message);
                     aesEncryptor.setKey(key);
                     aesEncryptor.encrypt();
                }
                else if (algo.equals("blowfish")){
                    EncryptionStrategy blowfishStrategy=new BlowfishEncryptionStrategy();
                    Encryptor blowfishEncryptor=new Encryptor(blowfishStrategy);
                    blowfishEncryptor.setPlainText(message);
                    blowfishEncryptor.setKey(key);
                    blowfishEncryptor.encrypt();
                    System.out.println();
                }
                else if(algo.equals("tdes")){
                    EncryptionStrategy tripleDESStrategy=new TripleDESEncryptionStrategy();
                    Encryptor tripleDESEncryptor=new Encryptor(tripleDESStrategy);
                    tripleDESEncryptor.setPlainText(message);
                    tripleDESEncryptor.setKey(key);
                    tripleDESEncryptor.encrypt();
            }
        }
}