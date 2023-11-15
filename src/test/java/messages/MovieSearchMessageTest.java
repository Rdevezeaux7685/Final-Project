package messages;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MovieSearchMessageTest {

    @Test
    void testMovieSearchMessageConstructorAndGetters() {
        String query = "Action";
        MovieSearchMessage message = new MovieSearchMessage(query);
        assertEquals(query, message.getQuery());
    }
}