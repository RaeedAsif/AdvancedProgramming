
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import sun.misc.BASE64Decoder;

public class BlowfishEncryptionStrategy implements DecryptionStrategy{
	

	public String decryptData(String plainText, String key1) throws Exception{
       System.out.println("\n*******Decrypting data using Blowfish algorithm*******");
        	byte[] key = key1.getBytes();
     	   SecretKeySpec skey = new SecretKeySpec(key, "Blowfish");

         Cipher cipher = Cipher.getInstance("Blowfish");
         cipher.init(Cipher.DECRYPT_MODE, skey);
        
         byte[] decordedValue = new BASE64Decoder().decodeBuffer(plainText);
         byte[] cipherText = cipher.doFinal(decordedValue);
         
     	
         System.out.println("Decrypted data:");
         String decVal = new String(cipherText);
     		
         System.out.println(decVal);
     	
     	return decVal;
    }
}

