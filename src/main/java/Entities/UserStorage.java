package src.main.java.Entities;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class UserStorage implements Storable, Serializable {
    private static final Map<String, User> userList = new HashMap<>();

    public static Map<String, User> getUserList(){ return userList;}

    public int getTotalNumber() {
        return userList.size();
    }

    public static void addElement(Object object) {
        userList.put(((User) object).getName(), (User) object);
    }

    public static void deleteElement(Object object) {
        userList.remove(((User) object).getName());
    }
}
