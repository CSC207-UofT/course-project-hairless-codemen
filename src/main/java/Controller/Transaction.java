package src.main.java.Controller;

import src.main.java.Entities.Item;
import src.main.java.Entities.User;
import src.main.java.Use_cases.ItemManager;
import src.main.java.Use_cases.CartManager;
import src.main.java.Use_cases.UserManager;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.Objects;

public class Transaction {
    public static ArrayList<Item> loadItems() throws IOException {
        User u = (User) UserManager.createUser("User1", "1234")[0];
        Item[] itemLst = ItemManager.loadItems(u);
        return new ArrayList<>(Arrays.asList(itemLst));
    }

    public static boolean buy(Item item, int userId){
        User u = UserManager.search(userId);
        double money = UserManager.getMoney(u);
        double price = CartManager.getPrice(item);
        if (price < money) {
            UserManager.subtractMoney(u, price);
            ItemManager.removeElement(item);
            return true;
        }
        else return false;
    }

    public static double getMoney(int userId){
        return UserManager.getMoney(Objects.requireNonNull(UserManager.search(userId)));
    }

    public static Map<String, ArrayList<Item>> getItems(){
        return ItemManager.getItems();
    }
}
