package domain;

import data.MockMovieRepo;
import data.MockReviewRepo;
import data.MockUserRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MovieServiceTest {

    MovieService service = new MovieService(
            new MockUserRepo(), new MockReviewRepo(), new MockMovieRepo()
    );
    User user = new User("romane", "test");

    @BeforeEach
    void logUser(){
        service.register("romane", "test");
        service.login(user.getUsername(), user.getPassword());
    }

    @Test
    void register() {
        assertTrue(service.login("romane", "test"));
    }


    @Test
    void getMovies() {
        List<Movie> movies = service.getMovies(user.getUsername());
        assertTrue(movies.contains(  new Movie(1, "film 1", "")));
    }

    @Test
    void addReview() {
        service.addReview(new Movie(1, "some movie", ""), "Amazing", 7);
        service.addReview(new Movie(3, "Heyyy", ""), "qewqewe", 4);
        assertEquals(2, service.getReviews().size());

    }
}