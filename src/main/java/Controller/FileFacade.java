package src.main.java.Controller;

import src.main.java.Entities.*;
import src.main.java.Use_cases.*;

import java.io.EOFException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class FileFacade {
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

    public static void readUser() throws IOException, ClassNotFoundException {
        try{
            UserReadWriter.readFromFile();
        }catch (IOException | ClassNotFoundException e){
            User u = createUser("default", "000000");
            addUser(u);
            UserReadWriter.SaveIntoFile(UserManager.getUserList());
            UserReadWriter.readFromFile();
        }
    }

    public static void readItem() throws IOException, ClassNotFoundException {
        try{
            ItemReadWriter.readFromFile();
        }catch (IOException | ClassNotFoundException e){
            User u = createUser("default", "000000");
            ItemManager.loadItems(u);
            addUser(u);
            ItemReadWriter.saveIntoFile(ItemManager.getItems());
            ItemReadWriter.readFromFile();
        }
    }

    public static void readOrder() throws IOException, ClassNotFoundException {
        try{
            OrderReadWriter.readFromFile();
        }catch (IOException | ClassNotFoundException e){
            User u = createUser("default", "000000");
            User u1 = createUser("default1", "000000");
            ArrayList<Item> items = new ArrayList<>(Arrays.asList(ItemManager.loadItems(u)));
            addUser(u);
            addUser(u1);
            Order o = OrderManager.create_order(items, u, u1);
            OrderManager.addElement(o);
            OrderReadWriter.saveIntoFile(OrderManager.getItems());
            OrderReadWriter.readFromFile();
        }
    }
}
