package DataControlers;

import java.util.HashMap;
import DataClasses.*;
public class UserAuthHandler {

    private HashMap<String, LibraryActor> users;

    public UserAuthHandler() {
        users = new HashMap<>();
    }

    public void addUser(LibraryActor user) {
        String toHash = user.getUsername() + user.getPassword();
        users.put(toHash, user);
    }

    public LibraryActor testUser(String username, String password) {
        return users.get(username + password); //return null if not found
    }
}



