package src.main.java.Entities;

import java.util.ArrayList;

public class UserStorage implements Storable {
    private static final ArrayList<User> userList = new ArrayList<>();

    public static ArrayList<User> getUserList(){ return userList;}

    public int getTotalNumber() {
        return userList.size();
    }

    public static void addElement(Object object) {
        userList.add((User) object);
    }

    public static void deleteElement(Object object) {
        userList.remove((User) object);
    }

}
