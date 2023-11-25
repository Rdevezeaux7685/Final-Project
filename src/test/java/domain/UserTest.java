package domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class UserTest {

    @Test
    void testUserConstructorAndGetters() {
        User user = new User("testUser", "password");

        assertEquals("testUser", user.getUsername());
        assertEquals("password", user.getPassword());
    }

    @Test
    void testEqualsAndHashCode() {
        User user1 = new User("user1", "password");
        User user2 = new User("user1", "password");
        User user3 = new User("user2", "password");

        assertTrue(user1.equals(user2));
        assertFalse(user1.equals(user3));
        assertEquals(user1.hashCode(), user2.hashCode());
        assertNotEquals(user1.hashCode(), user3.hashCode());
    }

}