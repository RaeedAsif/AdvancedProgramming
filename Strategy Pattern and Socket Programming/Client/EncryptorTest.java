package lab.pkg4;

public class EncryptorTest {
    
    public static void main(String[] args) throws Exception {
        EncryptionStrategy aesStrategy=new AesEncryptionStrategy();
        Encryptor aesEncryptor=new Encryptor(aesStrategy);
        aesEncryptor.setPlainText("My name is Raeed, I am president of UnitedStates");
        aesEncryptor.encrypt();
        
        System.out.println("\n______________________________________________________");
        
        EncryptionStrategy blowfishStrategy=new BlowfishEncryptionStrategy();
        Encryptor blowfishEncryptor=new Encryptor(blowfishStrategy);
        blowfishEncryptor.setPlainText("This is plain text, Blowfish");
        blowfishEncryptor.encrypt();
        
         System.out.println("\n______________________________________________________");
        
        EncryptionStrategy tripleDESStrategy=new TripleDESEncryptionStrategy();
        Encryptor tripleDESEncryptor=new Encryptor(tripleDESStrategy);
        tripleDESEncryptor.setPlainText("This is plain text, TripleDES");
        tripleDESEncryptor.encrypt();
        
        System.out.println("");
    }
}
