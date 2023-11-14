package util;
import org.jasypt.util.text.StrongTextEncryptor;
import org.mindrot.jbcrypt.BCrypt;

public final class Crypto {
    private static final String KEY = "TEST";
    private static final Crypto INSTANCE = new Crypto();
    private StrongTextEncryptor encryptor = new StrongTextEncryptor();

    private Crypto() {
        encryptor.setPassword(KEY);
    }

    public static Crypto getInstance() {
        return INSTANCE;
    }

    public String encrypt(String in) {
        return encryptor.encrypt(in);
    }

    public String decrypt(String in) {
        return encryptor.decrypt(in);
    }

    public String hash(String in) {
        return BCrypt.hashpw(in, BCrypt.gensalt());
    }

    public boolean comparePasswords(String in, String hashed) {
        return BCrypt.checkpw(in, hashed);
    }

}