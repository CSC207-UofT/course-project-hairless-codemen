package src.main.java.Controller;

import src.main.java.Use_cases.UserManager;

import java.io.IOException;

public class Login {

    public static Object[] signup(String username, String password) throws IOException {
        return new Object[]{UserManager.createUser(username, password)[1],
                UserManager.createUser(username, password)[2]};
    }

    public static boolean login(String username, String password){
        return UserManager.login(username, password);
    }

    public static void logout(){};
}
