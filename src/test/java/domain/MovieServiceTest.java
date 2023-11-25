package domain;

import data.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import util.MovieException;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MovieServiceTest {

    MovieService service;

    @BeforeEach
    void setUp() {
        service = new MovieService(
                new MockUserRepo(), new MockReviewRepo(), new MockMovieRepo()
        );
        assertThrows(MovieException.class, () -> service.getReviews());
        service.register("romane", "test");
        service.login("romane", "test");
        assertFalse(service.login("romane", "nopeNotThis"));
    }

    @Test
    void addReview() {
        service.addReview(new Movie(1, "some movie", ""), "Amazing", 7);
        service.addReview(new Movie(3, "Heyyy", ""), "qewqewe", 4);
        assertEquals(2, service.getReviews().size());
    }

    @Test
    void login() {
        assertTrue(service.login("romane", "test"));
        assertFalse(service.login("romane", "wrongPassword"));
    }

    @Test
    void testRegister() {
        assertTrue(service.login("romane", "test"));
    }

    @Test
    void getReviews() {
        Set<Review> reviewList = service.getReviews();
        assertTrue(reviewList.isEmpty());
    }

    @Test
    void testGetMovies() {
        List<Movie> movies = service.getMovies("romane");
        assertTrue(movies.contains(new Movie(1, "film 1", "")));
    }

    @Test
    void testAddReview() {
        service.addReview(new Movie(1, "some movie", ""), "Amazing", 7);
        service.addReview(new Movie(3, "Heyyy", ""), "qewqewe", 4);
        assertEquals(2, service.getReviews().size());
    }
}
