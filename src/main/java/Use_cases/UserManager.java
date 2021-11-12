package src.main.java.Use_cases;

import src.main.java.Entities.User;
import src.main.java.Entities.UserStorage;
import java.io.*;
import java.util.Map;

public class UserManager implements Manager, Serializable {
    public static Map<String,User> userlist;

    /**
     * The constructor UserManager
     * @param userList - a Map containing user information with keys being usernames and values User objects. Each
     *                 user's username is unique hence each key can only correspond to one User.
     */
    public UserManager(Map<String,User> userList){
        userlist = userList;
    }

    /**
     * Create a user given a username and a password. Return whether the user is successfully created.
     * @param username - the username of the new user to be created.
     * @param password - the password of the new user to be created.
     * @return true if there is not a user with provided username already existed in the system, return false otherwise.
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
     * Create a user given a username and a password.
     * @param username - the username of the new user to be created.
     * @param password - the password of the new user to be created.
     * @return the User created.
     */
    public static User create(String username, String password){
        return new User(username, password);
    }

    /**
     * Return a list of different information (the User object, the Cart of the user, how much money does this user has
     * in the wallet) about a user given its username.
     * Precondition: the user with given username must exist in the system.
     * @param username - the username of the user whose information will be returned.
     * @return a list of different information (the User object, the Cart of the user, how much money does this user has
     * in the wallet) about a user given its username.
     */
    public static Object[] getUserInfo(String username){
        User u = UserStorage.getUserList().get(username);
        return new Object[]{u, u.getCart(), u.getWallet().getMoney()};
    }

    /**
     * Returns whether a login process of given username and password succeeds.
     * @param username - the username of the login user.
     * @param password - the password of the login user.
     * @return true if there exists a user with the given username and the password matches the one stored in the
     * system. Return false otherwise.
     */
    public static boolean login(String username, String password){
        try{
            return UserStorage.getUserList().get(username).getPassword().equals(password);
        }catch(NullPointerException e){
            return false;
        }

    }

    /**
     * Returns a map containing all users stored on the userstorage.
     * @return a Map with keys being usernames and values being User objects that contains all information stored in the
     * user storage.
     */
    public static Map<String, User> getUserList(){return UserStorage.getUserList();}

    /**
     * Search for the user given its username.
     * @param username - the username using which the search will be performed.
     * @return the User with the provided username.
     * @throws NullPointerException if there does not exist any user with the provided username.
     */
    public static User search(String username) throws NullPointerException {
        return UserStorage.getUserList().get(username);
    }

    /**
     * Return the amount of money a given User has.
     * @param u - the User whose amount of money stored in the wallet will be returned.
     * @return a double value representing the amount of money a given User has.
     */
    public static double getMoney(User u){
        return u.getWallet().getMoney();
    }

    /**
     * Subtract a specific amount of money from a given User
     * @param u - the User whose money will be subtracted.
     * @param money - how much money will be subtracted from the user.
     * Precondition: the money subtracted must be less than the total amount of money this user has.
     */
    public static void subtractMoney(User u, double money){
        u.getWallet().subtractMoney(money);
    }

    /**
     * Load a specific amount of money into a given User's wallet.
     * @param u - the User whose wallet will be loaded with a specific amount of money.
     * @param money - how much money will be loaded into the user's wallet.
     */
    public static void loadMoney(User u, double money){u.getWallet().loadMoney(money);}

    /**
     * Add a list of users to UserStorage.
     * @param users - the list of users to be added.
     */
    public void addElement(Object[] users){
        for (Object user: users){
            addElement(user);
        }
    }

    /**
     * Add a single User to UserStorage.
     * @param user - the user to be added.
     */
    public static void addElement(Object user){
        UserStorage.addElement(user);
    }

    /**
     * Remove a list of users from UserStorage.
     * @param elements - the list of users to be removed.
     */
    public void removeElement(Object[] elements) {
        for (Object element: elements){
            removeElement(element);
        }
    }

    /**
     * Remove a single user from UserStorage.
     * @param element - the user to be removed.
     */
    public void removeElement(Object element) {
        UserStorage.deleteElement(element);
    }
}
