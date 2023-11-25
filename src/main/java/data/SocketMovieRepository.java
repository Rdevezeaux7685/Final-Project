package data;

import domain.Movie;
import util.MovieException;
import messages.ErrorMessage;
import messages.Message;
import messages.MovieResultMessage;
import messages.MovieSearchMessage;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SocketMovieRepository implements MovieRepository {

    private static final Logger LOGGER = Logger.getLogger(SocketMovieRepository.class.getName());

    @Override
    public List<Movie> getMovies(String query) {
        try (Socket socket = new Socket("172.21.24.8", 32768) ){
            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
            LOGGER.log(Level.INFO, "Initiate Co");

            out.writeObject(new MovieSearchMessage(query));
            LOGGER.log(Level.INFO, "Message");

            Message response = (Message) in.readObject();

            if (response instanceof MovieResultMessage) {
                return ((MovieResultMessage) response).getResults();
            } else {
                if (LOGGER.isLoggable(Level.INFO)) {
                    LOGGER.log(Level.INFO, "Server failed: {}", ((ErrorMessage) response).getMessage());
                }
                throw new MovieException( ((ErrorMessage)response).getMessage());
            }

        } catch (IOException | ClassNotFoundException ex) {
            LOGGER.log(Level.INFO, "Failed to get movies", ex);
            throw new MovieException("Failed to get movies\n", ex);
        }
    }
}
