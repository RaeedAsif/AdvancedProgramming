
public class DecryptorTest {
    
	public static void main(String args[]) throws Exception {
    	
        DecryptionStrategy aesStrategy=new AesEncryptionStrategy();
        Decryptor aesEncryptor=new Decryptor(aesStrategy);
        aesEncryptor.setPlainText("My name is Raeed, I am president of UnitedStates");
        aesEncryptor.encrypt();
        
        System.out.println("\n______________________________________________________");
        
        DecryptionStrategy blowfishStrategy=new BlowfishEncryptionStrategy();
        Decryptor blowfishEncryptor=new Decryptor(blowfishStrategy);
        blowfishEncryptor.setPlainText("This is plain text, Blowfish");
        blowfishEncryptor.encrypt();
        
         System.out.println("\n______________________________________________________");
        
        DecryptionStrategy tripleDESStrategy=new TripleDESEncryptionStrategy();
        Decryptor tripleDESEncryptor=new Decryptor(tripleDESStrategy);
        tripleDESEncryptor.setPlainText("This is plain text, TripleDES");
        tripleDESEncryptor.encrypt();
        
        System.out.println("");
    }
}
