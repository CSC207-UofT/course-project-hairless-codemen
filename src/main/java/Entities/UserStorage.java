package src.main.java.Entities;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class UserStorage implements Storable, Serializable {

    private static final Map<String, User> userMap = new HashMap<>();

    public static Map<String, User> getUserList(){ return userMap;}

    public static int getTotalNumber() {
        return userMap.size();
    }

    public static void addElement(Object object) {
        userMap.put(((User) object).getName(), (User) object);
    }

    public static void deleteElement(Object object) {
        userMap.remove(((User) object).getName());
    }
}
