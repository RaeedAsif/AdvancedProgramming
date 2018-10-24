
public class Decryptor {

    private DecryptionStrategy strategy;
    private String plainText;
    private String key;

    
    public Decryptor(DecryptionStrategy strategy){
        this.strategy=strategy;
    }
    
    public String encrypt() throws Exception{
        return strategy.decryptData(plainText,key);
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

