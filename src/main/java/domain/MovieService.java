package domain;

import data.MovieRepository;
import data.ReviewRepository;
import data.UserRepository;
import data.util.Repositories;
import util.MovieException;

import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MovieService {
    private final UserRepository userRepository;
    private final ReviewRepository reviewRepository;
    private final MovieRepository movieRepository;
    private static final String USERNAME_PATTERN = "^[a-zA-Z][a-zA-Z0-9]{2,15}$";
    private static final Pattern usernamePattern = Pattern.compile(USERNAME_PATTERN);

    private static final String PASSWORD_PATTERN = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).{8,}$";
    private static final Pattern passwordPattern = Pattern.compile(PASSWORD_PATTERN);
    private User loggedInUser = null;



    public boolean usernameValidation(String username){
        Matcher matcher = usernamePattern.matcher(username);
        return matcher.matches();
    }

    public boolean passwordValidation(String password){
        Matcher matcher = passwordPattern.matcher(password);
        return matcher.matches();
    }

    public MovieService(){
        userRepository = Repositories.getUserRepository();
        reviewRepository = Repositories.getReviewRepository();
        movieRepository = Repositories.getMovieRepository();
    }

    public MovieService(UserRepository user, ReviewRepository review, MovieRepository movie){
        this.userRepository = user;
        this.reviewRepository = review;
        this.movieRepository = movie;
    }


    private void ensureLoggedIn() {
        if(loggedInUser == null){
            throw new MovieException("This feature is only available for logged in users.");
        }
    }

    public boolean login(String login, String plainTextPwd){
        User user = userRepository.getUser(login);
        if(user != null){
            if(plainTextPwd.compareTo(user.getPassword()) == 0){
                loggedInUser = user;
                return true;
            }
        }
        return false;
    }


    public void register(String username, String password) {
        userRepository.registerNewUser(new User(username, password));
    }

    public Set<Review> getReviews() {
        ensureLoggedIn();
        return reviewRepository.getReviews(loggedInUser.getUsername());
    }

    public List<Movie> getMovies(String query) {
        ensureLoggedIn();
        return movieRepository.getMovies(query);
    }

    public void addReview(Movie movie, String review, Integer score) {
        reviewRepository.addReview(movie.getId(), review, score, loggedInUser.getUsername());
    }
}
