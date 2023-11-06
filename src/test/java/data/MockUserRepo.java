package data;

import domain.User;

import java.util.HashMap;
import java.util.Map;

public class MockUserRepo implements UserRepository {

    private final Map<String, String> users = new HashMap<>();

    @Override
    public User getUser(String username) {
        return new User(username, users.get(username));
    }

    @Override
    public void registerNewUser(User user) {
        users.put(user.getUsername(), user.getPassword());
    }
}
