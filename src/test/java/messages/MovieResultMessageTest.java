package messages;

import domain.Movie;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MovieResultMessageTest {

    @Test
    void testMovieResultMessageConstructorAndGetters() {
        List<Movie> movies = List.of(
                new Movie(1, "Movie 1", "cover1.jpg"),
                new Movie(2, "Movie 2", "cover2.jpg")
        );

        MovieResultMessage message = new MovieResultMessage(new ArrayList<>(movies));
        assertEquals(movies, message.getResults());
    }

    @Test
    void testToString() {
        List<Movie> movies = List.of(
                new Movie(1, "Movie 1", "cover1.jpg"),
                new Movie(2, "Movie 2", "cover2.jpg")
        );

        MovieResultMessage message = new MovieResultMessage(new ArrayList<>(movies));
        assertEquals("MovieResultMessage{results=" + movies + '}', message.toString());
    }
}