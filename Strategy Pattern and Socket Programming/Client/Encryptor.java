package lab.pkg4;

public class Encryptor {

    private EncryptionStrategy strategy;
    private String plainText;
    private String key;

    
    public Encryptor(EncryptionStrategy strategy){
        this.strategy=strategy;
    }
    
    public void encrypt(){
        strategy.encryptData(plainText,key);
    }
    
    public String getPlainText() {
        return plainText;
    }

    public void setPlainText(String plainText) {
        this.plainText = plainText;
    }
    
    public String getKey() {
        return plainText;
    }

    public void setKey(String key) {
        this.key = key;
    }

}

