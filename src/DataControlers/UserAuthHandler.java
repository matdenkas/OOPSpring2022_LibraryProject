package DataControlers;

import java.util.HashMap;
import DataClasses.*;

/**
 * Class handles the autherization and lists of every user for this system
 */
public class UserAuthHandler {

    private HashMap<String, LibraryActor> users;

    public UserAuthHandler() {
        users = new HashMap<>();
    }

    public void addUser(LibraryActor user) {
        String toHash = user.getUsername() + user.getPassword();
        users.put(toHash, user);
    }

    /**
     * tests if a username and pasward makes is one of our users if so
     * @param username
     * @param password
     * @return returns the actor or null if no actor is found
     */
    public LibraryActor testUser(String username, String password) {
        return users.get(username + password); //return null if not found
    }
}



