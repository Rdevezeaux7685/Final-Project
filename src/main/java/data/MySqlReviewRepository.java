package data;

import data.util.MySqlConnection;
import domain.Review;
import util.MovieException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MySqlReviewRepository implements ReviewRepository {

    private static final Logger LOGGER = Logger.getLogger(MySqlReviewRepository.class.getName());

    private static final String SQL_SELECT_REVIEWS = "select * from reviews where username = ?";

    private static final String SQL_INSERT_REVIEW = "insert into reviews (username, movie_id, review, score) values (?, ?, ?, ?)";


    @Override
    public Set<Review> getReviews(String username) {
        try (Connection con = MySqlConnection.getConnection();
             PreparedStatement stmt = con.prepareStatement(SQL_SELECT_REVIEWS)) {
            stmt.setString(1, username);

            LOGGER.log(Level.INFO, "Initiate connection");

            try (ResultSet rs = stmt.executeQuery()) {
                Set<Review> review = new HashSet<>();

                while (rs.next()) {
                    review.add(new Review(
                            rs.getInt("id"),
                            rs.getInt("movie_id"),
                            rs.getString("review"),
                            rs.getInt("score")
                    ));
                }
                return review;
            }
        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Enable to retrieve reviews", ex);
            throw new MovieException("Enable to retrieve reviews: ", ex);
        }
    }

    @Override
    public void addReview(int movieId, String review, Integer score, String username) {
        try(Connection con = MySqlConnection.getConnection();
            PreparedStatement stmt = con.prepareStatement(SQL_INSERT_REVIEW)) {
            LOGGER.log(Level.INFO, "Initiate connection");
            stmt.setString(1, username);
            stmt.setInt(2, movieId);
            stmt.setString(3, review);
            stmt.setInt(4, score);
            stmt.executeUpdate();

        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Enable to add review", ex);
            throw new MovieException("Enable to add review:", ex);
        }
    }
}
