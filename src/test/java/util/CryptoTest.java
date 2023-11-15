package util;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CryptoTest {

    String username;
    Crypto crypto;

    @BeforeEach
    void setUp() {
        username = "test";
        crypto = Crypto.getInstance();
    }

    @Test
    void testEncrypt() {
        assertNotEquals(username, crypto.encrypt(username));
        assertNotEquals(crypto.encrypt("test"), crypto.encrypt(username));
    }

    @Test
    void testDecrypt() {
        String encryptedUsername = crypto.encrypt(username);
        assertEquals(username, crypto.decrypt(encryptedUsername));
        assertEquals("test", crypto.decrypt(crypto.encrypt("test")));
    }
}