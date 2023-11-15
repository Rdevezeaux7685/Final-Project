package util;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConfigTest {
        @Test
        void testReading() {
            String KEY_USER = "db.username";
            String KEY_PASSWORD = "db.password";
            String NOT_A_KEY = "db.notakey";

            String userSetting = Config.getInstance().readSetting(KEY_USER);
            assertNotNull(userSetting, "User setting should not be null");
            assertFalse(userSetting.isEmpty(), "User setting should not be empty");

            String passwordSetting = Config.getInstance().readSetting(KEY_PASSWORD);
            assertNotNull(passwordSetting, "Password setting should not be null");
            assertFalse(passwordSetting.isEmpty(), "Password setting should not be empty");

            String notAKeySetting = Config.getInstance().readSetting(NOT_A_KEY);
            assertNull(notAKeySetting, "Setting for a non-existing key should be null");
        }


}