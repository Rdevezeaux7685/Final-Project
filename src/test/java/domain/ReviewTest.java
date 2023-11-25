package domain;

import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
class ReviewTest {

    @Test
    void testReviewConstructorAndGetters() {
        Review review = new Review(1, "Great movie", 5);
        assertEquals(1, review.getMovie());
        assertEquals("Great movie", review.getReview());
        assertEquals(5, review.getScore());
    }

    @Test
    void testEqualsAndHashCode() {
        Review review1 = new Review(1, "Great movie", 5);
        Review review4 = new Review(1, "Great movie", 5);
        assertTrue(review1.equals(review4));
    }

    @Test
    void testSetId() {
        Review review = new Review(1, "Great movie", 5);
        review.setId(42);

    }

    @Test
    void testToString() {
        Review review = new Review(1, "Great movie", 5);
        assertEquals("Review{movie='1', review='Great movie', id=-1}", review.toString());
    }
}