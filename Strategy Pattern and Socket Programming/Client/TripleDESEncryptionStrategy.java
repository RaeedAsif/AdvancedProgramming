package lab.pkg4;


import java.security.Security;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class TripleDESEncryptionStrategy implements EncryptionStrategy{

    public void encryptData(String plainText, String key1) {
      
    	System.out.println("\n*******Decrypting data using TripleDES algorithm*******");
        
    	try {/*
     	   	byte[] key = key1.getBytes();
        	SecretKeySpec skey = new SecretKeySpec(key, "TripleDES");

        	
            byte[] plaintTextByteArray = plainText.getBytes("UTF-8");

            Cipher cipher = Cipher.getInstance("TripleDES");
            cipher.init(Cipher.ENCRYPT_MODE, skey);
            byte[] cipherText = cipher.doFinal(plaintTextByteArray);

            System.out.println("Decrypted data:");
            String encryptedValue = cipherText.toString();
            Client.enc = encryptedValue;
            System.out.println(Client.enc);*/
             byte[] key = key1.getBytes();
            SecretKeySpec skey = new SecretKeySpec(key, "TripleDES");
           
            //byte[] plaintTextByteArray = plainText.getBytes("UTF8");

            Cipher cipher = Cipher.getInstance("TripleDES");
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
