package lab.pkg4;


import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
/**
 *
 * @author mkazmi.bscs16seecs
 */
public class BlowfishEncryptionStrategy implements EncryptionStrategy{

 @Override
    public void encryptData(String plaintext,String key1) {
        System.out.println("\n-------Encrypting data using Blowfish algorithm-------");
        try {
          
             byte[] key = key1.getBytes();
            SecretKeySpec skey = new SecretKeySpec(key, "Blowfish");
           
            //byte[] plaintTextByteArray = plainText.getBytes("UTF8");

            Cipher cipher = Cipher.getInstance("Blowfish");
            cipher.init(Cipher.ENCRYPT_MODE, skey);
            byte[] cipherText = cipher.doFinal(plaintext.getBytes("UTF-8"));
            
             
           String encryptedValue = Base64.getEncoder().encodeToString(cipherText);

            System.out.println("Encrypted data:");
            
            
            //String encryptedValue = cipherText.toString();
            Client.enc = encryptedValue;
            System.out.println(Client.enc);
          
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }
    
}
