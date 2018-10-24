package lab.pkg4;

import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import sun.misc.BASE64Encoder;

public class AesEncryptionStrategy implements EncryptionStrategy{

    @Override
    public void encryptData(String plainText, String key1) {
       System.out.println("*******Encrypting data using AES algorithm*******");
       try {
    	   
            byte[] key = key1.getBytes();
            SecretKeySpec skey = new SecretKeySpec(key, "AES");
           
            //byte[] plaintTextByteArray = plainText.getBytes("UTF8");

            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, skey);
            byte[] cipherText = cipher.doFinal(plainText.getBytes("UTF-8"));
            
             
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
