package util;
import org.jasypt.util.text.StrongTextEncryptor;

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

}