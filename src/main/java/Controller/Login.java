package src.main.java.Controller;

import src.main.java.Use_cases.UserManager;

public class Login {

    public static Object[] signup(String username, String password){
        return new Object[]{UserManager.createUser(username, password)[1],
                UserManager.createUser(username, password)[2]};
    }

    public static void login(String username, String password){}
}
