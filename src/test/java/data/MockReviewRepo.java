package data;

import domain.Review;
import domain.User;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class MockReviewRepo implements ReviewRepository{
    public static int ID = 0;

    private Set<Review> reviews =  new HashSet<>();
    User loggedIn = new User("romane", "test");


    @Override
    public Set<Review> getReviews(String username) {
        if(username.equals(loggedIn.getUsername())) {
            return reviews;
        }
        return Collections.emptySet();
    }

    @Override
    public void addReview(int movieId, String review, Integer score, String username) {
        ID += 1;
        Review review1 = new Review(ID, movieId, review, score);
        reviews.add(review1);
    }
}
