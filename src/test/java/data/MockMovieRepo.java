package data;

import domain.Movie;

import java.util.List;

public class MockMovieRepo implements MovieRepository{

    @Override
    public List<Movie> getMovies(String query) {
        return List.of(
                new Movie(1, "film 1", ""),
                new Movie(2, "film 2", ""),
                new Movie(3, "film 3", ""),
                new Movie(4, "film 4", "")
                );
    }
}
