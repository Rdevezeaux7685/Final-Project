package data;

import data.util.MySqlConnection;
import domain.User;
import util.MovieException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MySqlUserRepository implements UserRepository{

    private static final Logger LOGGER = Logger.getLogger(MySqlUserRepository.class.getName());

    private static final String SQL_SELECT_USERS = "select * from users where username = ?";

    private static final String SQL_INSERT_USERS = "insert into users (username, password) values (?,?)";


    @Override
    public User getUser(String login) {
        try(Connection con = MySqlConnection.getConnection();
            PreparedStatement stmt = con.prepareStatement(SQL_SELECT_USERS)) {

            stmt.setString(1, login);
            LOGGER.log(Level.INFO, "Initiate connection");
            try(ResultSet rs = stmt.executeQuery()){
                if(rs.next()){ //cause only 1 or 0 result possible
                    return new User(rs.getString("username"), rs.getString("password"));
                }
                else {
                    return null;
                }
            }

        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Enable to get user", ex);
            throw new MovieException("Enable to get user");
        }
    }

    @Override
    public void registerNewUser(User user) {
        try(Connection con = MySqlConnection.getConnection();
            PreparedStatement stmt = con.prepareStatement(SQL_INSERT_USERS)) {
            LOGGER.log(Level.INFO, "Initiate connection");
            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getPassword());

            stmt.executeUpdate();
        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Enable to add user", ex);
            throw new MovieException("Enable to add user");
        }
    }
}
