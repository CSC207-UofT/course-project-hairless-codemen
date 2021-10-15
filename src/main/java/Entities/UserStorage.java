package src.main.java.Entities;

import java.util.ArrayList;

public class UserStorage extends Storage {
    private static final ArrayList<User> userList = new ArrayList<>();

    public static ArrayList<User> getUserList(){ return userList;}

    @Override
    public int getTotalNumber() {
        return userList.size();
    }

    @Override
    public void addElement(Object object) {
        userList.add((User) object);
    }

    @Override
    public void deleteElement(Object object) {
        userList.remove((User) object);
    }

}
