package src.main.java.Controller;

import src.main.java.Entities.User;
import src.main.java.Entities.UserStorage;
import src.main.java.Use_cases.OrderManager;
import src.main.java.Use_cases.UserManager;
import src.main.java.Use_cases.UserReadWriter;

import java.io.EOFException;
import java.io.IOException;

public class UserFacade {
    public static void addUser(User u){
        UserManager.addElement(u);
    }

    public static User createUser(String username, String password){
        return UserManager.create(username, password);
    }

    public static Object[] getUserInfo(String username){
        Object[] lst = UserManager.getUserInfo(username);
        User u = (User) lst[0];
        return new Object[]{lst[1], lst[2], OrderManager.getOrders(u)};
    }

    public static void readFile() throws IOException, ClassNotFoundException {
        try{
            UserReadWriter.readFromFile();
        }catch (IOException | ClassNotFoundException e){
            User u = createUser("default", "000000");
            addUser(u);
            UserReadWriter.SaveIntoFile(UserStorage.getUserList());
            UserReadWriter.readFromFile();
        }
    }
}
