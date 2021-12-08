package src.main.java.Entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class UserStorage implements Storable, Serializable {

    private static final Map<String, User> userMap = new HashMap<>();

    /**
     * A get method that get all users stored in user storage in its original hashmap form.
     * @return a hashmap containing all users stored in user storage.
     */
    public static Map<String, User> getUserList(){ return userMap;}

    /**
     * Add a user to user storage.
     * @param object - an object to be added into user storage.
     */
    public static void addElement(Object object) {
        userMap.put(((User) object).getName(), (User) object);
    }

    /**
     * Add a hashmap of users to user storage.
     * @param m - a hashmap of users to be added into the user storage. The keys in m represent usernames for the user
     * object they correspond to. Each key can only have one value since each user's username is unique.
     */
    public static void addElement(Map<String, User> m){
        for (User u : m.values()){
            addElement(u);
        }
    }
}
