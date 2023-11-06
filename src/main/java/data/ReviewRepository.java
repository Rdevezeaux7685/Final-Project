package data;

import domain.Review;
import domain.User;

import java.util.Set;

public interface ReviewRepository {

    Set<Review> getReviews(String username);

    void addReview(int movieId, String review, Integer score, String username);
}
