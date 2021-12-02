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

    /**
     * Create a new user.
     *
     */
    public static User create(String username, String password){
        return new User(username, password);
    }


    /**
     * Return True and create a new user if the username does not exist previously. Otherwise, return False.
     *
     * @param username The username entered
     * @param password The password entered
     * @return whether we can create a new user
     */
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


    /**
     * Modify the password for an existing user.
     *
     * @param user The user who wish to modify password
     * @param NewPassword The new password the user wishes to set
     */
    public static void changePassword(User user, String NewPassword){
        if (!UserStorage.getUserList().containsKey(user.getName())){
            //TODO: need to throw exception here. Can not modify password for non-existing user.
        }
        User u = create(user.getName(), NewPassword);
        UserStorage.deleteElement(user);
        UserStorage.addElement(u);
    }


    /**
     * Return the corresponding information(the user, the user's cart and user's money in wallet) of the user by
     * username.
     *
     * @param username The name of the user
     * @return information(the user, the user's cart and user's money in wallet) of the user
     */
    public static Object[] getUserInfo(String username){
        User u = UserStorage.getUserList().get(username);
        return new Object[]{u, u.getCart(), u.getWallet().getMoney()};
    }


    /**
     * Logging the user in iff the username matches with the password.
     *
     * @param username The username entered
     * @param password The password entered
     * @return whether the login is successful
     */
    public static boolean login(String username, String password){
        try{
            return UserStorage.getUserList().get(username).getPassword().equals(password);
        }catch(NullPointerException e){
            return false;
        }
    }

    /**
     * Get all existing users.
     *
     * @return a map that contains all existing users.
     */
    public static Map<String, User> getUserList(){
        return UserStorage.getUserList();
    }


    /**
     * Search whether a user exists.
     *
     * @param username the username we search on
     * @return the corresponding user or null if not found
     */
    public static User search(String username) throws NullPointerException {
        return UserStorage.getUserList().get(username);
    }


    /**
     * Get the amount of money that a user has.
     *
     * @param u a user
     * @return a double representing the amount of money
     */
    public static double getMoney(User u){
        return u.getWallet().getMoney();
    }


    /**
     * Subtract a user's money.
     *
     * @param u a user
     * @param money the amount of money we want to deduct from this user
     */
    public static void subtractMoney(User u, double money){
        u.getWallet().subtractMoney(money);
    }


    /**
     * Load money for a user.
     *
     * @param u a user
     * @param money the amount of money we want to add to this user
     */
    public static void loadMoney(User u, double money){
        u.getWallet().loadMoney(money);}


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
