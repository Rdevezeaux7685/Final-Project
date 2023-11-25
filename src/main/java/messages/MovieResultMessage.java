package messages;

import domain.Movie;
import java.util.List;

public class MovieResultMessage extends Message {

    private final List<Movie> results;

    public MovieResultMessage(List<Movie> results) {
        this.results = results;
    }

    public List<Movie> getResults() {
        return results;
    }

    @Override
    public String toString() {
        return "MovieResultMessage{" +
                "results=" + results +
                '}';
    }
}
