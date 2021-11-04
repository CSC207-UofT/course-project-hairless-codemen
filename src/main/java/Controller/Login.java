package src.main.java.Controller;

import src.main.java.Entities.UserStorage;
import src.main.java.Use_cases.UserManager;
import src.main.java.Use_cases.UserReadWriter;

import java.io.IOException;

public class Login {


    public static boolean signup(String username, String password) throws IOException {
        return UserManager.createUser(username, password);
    }

    public static boolean login(String username, String password)throws IOException, ClassNotFoundException {
        UserReadWriter.SaveIntoFile(UserStorage.getUserList());
        return UserManager.login(username, password);
    }

    public static void logout() throws IOException {
        UserReadWriter.SaveIntoFile(UserStorage.getUserList());
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Login.signup("6", "6666");
        System.out.println(Login.login("6", "6666"));
        Login.logout();
        System.out.println(Login.login("6", "6666"));
    }
}

