package src.main.java.Controller;

import src.main.java.Entities.Item;
import src.main.java.Entities.User;
import src.main.java.Use_cases.ItemManager;
import src.main.java.Use_cases.CartManager;
import src.main.java.Use_cases.UserManager;

import java.util.ArrayList;
import java.util.Arrays;

public class Transaction {
    public static ArrayList<Item> loadItems() {
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
            ItemManager im = new ItemManager();
            im.removeElement(item);
            return true;
        }
        else return false;
    }

    public static ArrayList<Item> getItems(){
        return ItemManager.getItems();
    }
}
