package src.main.java;

public class LoginC {

    public static Object[] signup(String username, String password){
        return new Object[]{UserManager.createUser(username, password)[1],
                UserManager.createUser(username, password)[2]};
    }

    public static void login(String username, String password){}
}
