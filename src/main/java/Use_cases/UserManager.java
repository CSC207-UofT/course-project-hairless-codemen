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


    public static Object[] createUser(String username, String password) throws IOException {
        int userid = UserStorage.getTotalNumber();
//        User now has 100$ to begin with. Needs to be changed.
        User u = new User(username, userid, password, 100);
        addElement(u);
//        Return the information of this user, this user's username, and this user's id.
        return new Object[]{u, u.getName(), u.getId()};
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

    public Object search(String username) {
        return UserStorage.getUserList().get(username);
    }

    public static User search(int userId){
        for (String username: UserStorage.getUserList().keySet()){
            if (UserStorage.getUserList().get(username).getId() == userId){
                return UserStorage.getUserList().get(username);
            }
        }
        return null;
    }

    public static double getMoney(User u){
        return u.getWallet().getMoney();
    }

    public static void subtractMoney(User u, double money){
        u.getWallet().subtractMoney(money);
    }

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
