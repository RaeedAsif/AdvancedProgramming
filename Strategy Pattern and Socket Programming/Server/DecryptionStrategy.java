
public interface DecryptionStrategy {
    String decryptData(String plainText, String key) throws Exception;
}
