package src.main.java.Use_cases;

import src.main.java.Entities.User;
import src.main.java.Entities.UserStorage;
import java.io.*;
import src.main.java.Use_cases.UserReadWriter;
import java.io.*;
import java.util.ArrayList;
import java.util.Map;

public class UserManager implements Manager, Serializable {
    public static Map<String,User> userlist;

    public UserManager(Map<String,User> userList){
        userlist = userList;
    }


    public static boolean createUser(String username, String password) throws IOException {
//        User now has 100$ to begin with. Needs to be changed.
        if (UserStorage.getUserList().containsKey(username)){
            return false;
        }
        User u = new User(username, password, 100);
        addElement(u);
//        Return the information of this user, this user's username, and this user's id.
        return true;
    }



    /*public static void addUser(User u) throws IOException {
        //  Add a user to User.txt file.
        File f = new File("src/main/java/Files/Users.txt");
        FileOutputStream fos = new FileOutputStream(f);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        output.writeObject(users);
        output.close();
        oos.close();
        fos.close();
    }
    /*
     */



    public static boolean login(String username, String password){
       return UserStorage.getUserList().get(username).getPassword().equals(password);
    }

    public static User search(String username) {
        return UserStorage.getUserList().get(username);
    }


    public static double getMoney(User u){
        return u.getWallet().getMoney();
    }

    public static void subtractMoney(User u, double money){
        u.getWallet().subtractMoney(money);
    }

    public static void loadmoney(User u, double money){u.getWallet().loadMoney(money);}


    public void addElement(Object[] users) throws IOException {
        for (Object user: users){
            addElement(user);
        }
    }

    public static void addElement(Object user) throws IOException {
        UserStorage.addElement(user);
    }

    public void removeElement(Object[] elements) {
        for (Object element: elements){
            removeElement(element);
        }
    }

    public void removeElement(Object element) {
        UserStorage.deleteElement(element);
    }



}
