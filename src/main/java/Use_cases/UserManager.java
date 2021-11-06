package src.main.java.Use_cases;

import src.main.java.Entities.User;
import src.main.java.Entities.UserStorage;
import java.io.*;
import java.util.Map;

public class UserManager implements Manager, Serializable {
    public static Map<String,User> userlist;

    public UserManager(Map<String,User> userList){
        userlist = userList;
    }


    public static boolean createUser(String username, String password){
//        User now has 100$ to begin with. Needs to be changed.
        if (UserStorage.getUserList().containsKey(username)){
            return false;
        }
        User u = create(username, password);
        addElement(u);
//        Return the information of this user, this user's username, and this user's id.
        return true;
    }

    public static User create(String username, String password){
        return new User(username, password);
    }

    public static Object[] getUserInfo(String username){
        User u = UserStorage.getUserList().get(username);
        return new Object[]{u, u.getCart(), u.getWallet().getMoney()};
    }

    public static boolean login(String username, String password){
        try{
            return UserStorage.getUserList().get(username).getPassword().equals(password);
        }catch(NullPointerException e){
            return false;
        }

    }
    public static Map<String, User> getUserList(){return UserStorage.getUserList();}

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


    public void addElement(Object[] users){
        for (Object user: users){
            addElement(user);
        }
    }

    public static void addElement(Object user){
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
