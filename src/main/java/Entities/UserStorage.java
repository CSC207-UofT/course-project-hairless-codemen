package src.main.java.Entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class UserStorage implements Storable, Serializable {

    private static final Map<String, User> userMap = new HashMap<>();

    public UserStorage(Map<String, User> userMap) {
    }

    public static Map<String, User> getUserList(){ return userMap;}

    public static int getTotalNumber() {
        return userMap.size();
    }

    public static void addElement(Object object) {
        userMap.put(((User) object).getName(), (User) object);
    }

    public static void addElement(Map<String, User> m){
        for (User u : m.values()){
            addElement(u);
        }
    }

    public static void deleteElement(Object object) {
        userMap.remove(((User) object).getName());
    }
}
