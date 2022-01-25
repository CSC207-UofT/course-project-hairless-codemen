package src.main.java.Controller;

import src.main.java.Use_cases.*;

import java.io.IOException;

public class Login {

    /**
     * Signup a user with given username and password. Return whether the signup is successful.
     * @param username - the username to be signed up.
     * @param password - the password to be signed up.
     * @return true if there doesn't exist a user with the given username. Return false otherwise.
     */
    public static boolean signup(String username, String password){
        return UserManager.createUser(username, password);
    }

    /**
     * Login a user with given username and password. Return whether the login is successful.
     * @param username - the username to be logged in.
     * @param password - the password to be logged in.
     * @return true if the login is successful. Return false otherwise.
     * @throws IOException - if output operations are interrupted by some error.
     */
    public static boolean login(String username, String password) throws IOException{
        UserReadWriter.SaveIntoFile(UserManager.getUserList());
        return UserManager.login(username, password);
    }

    /**
     * Logout the user. Saves all users, items and orders into different files.
     * @throws IOException - if output operations are interrupted by some error.
     */
    public static void logout() throws IOException {
        UserReadWriter.SaveIntoFile(UserManager.getUserList());
        ItemReadWriter.saveIntoFile(ItemManager.getItems());
        OrderReadWriter.saveIntoFile(OrderManager.getItems());
    }
}

