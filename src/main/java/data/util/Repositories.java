package data.util;

import data.*;


public class Repositories {
    private static final UserRepository USER_REPOSITORY = new MySqlUserRepository();
    private static final ReviewRepository REVIEW_REPOSITORY = new MySqlReviewRepository();
    private static final MovieRepository MOVIE_REPOSITORY = new SocketMovieRepository();

    private Repositories(){

    }

    public static UserRepository getUserRepository(){
        return USER_REPOSITORY;
    }

    public static ReviewRepository getReviewRepository() {
        return REVIEW_REPOSITORY;
    }

    public static MovieRepository getMovieRepository() {
        return MOVIE_REPOSITORY;
    }
}
