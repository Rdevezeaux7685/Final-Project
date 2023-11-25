package domain;

import java.util.Objects;

public class Review {
    public static final int NO_ID_ASSIGNED = -1;

    private final int movieId;
    private final String review;
    private final int score;
    private int id;


    public Review(int id, int movieId, String review, int score) {
        this.movieId = movieId;
        this.review = review;
        this.score = score;
        this.id = id;
    }

    public Review(int movieId, String review, int score) {
        this(NO_ID_ASSIGNED, movieId, review, score);
    }

    public int getMovie() {
        return movieId;
    }

    public String getReview() {
        return review;
    }

    public int getScore() {
        return score;
    }

    public void setId(int id) {
        this.id = id;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Review review = (Review) o;
        return id == review.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Review{" +
                "movie='" + movieId + '\'' +
                ", review='" + review + '\'' +
                ", id=" + id +
                '}';
    }
}
