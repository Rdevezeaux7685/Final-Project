package util;

public class MovieException extends RuntimeException {

    public MovieException(String message, Throwable cause) {
        super(message, cause);
    }

    public MovieException(String message) {
        super(message);
    }

    @Override
    public synchronized Throwable fillInStackTrace() {
        // Overriding this method to prevent filling in the stack trace
        return this;
    }
}
