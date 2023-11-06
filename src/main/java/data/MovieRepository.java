package data;

import domain.Movie;

import java.util.List;

public interface MovieRepository {
    List<Movie> getMovies(String query);
}
