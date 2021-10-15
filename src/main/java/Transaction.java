package src.main.java;

import src.main.java.Entities.Item;
import src.main.java.Entities.User;
import src.main.java.Entities.UserStorage;

public class Transaction {
    public static Item[] loadItems() {
        User u = (User) UserManager.createUser("User1", "1234")[0];
        return ItemManager.loadItems(u);
    }

    public static boolean buy(Item item, int userId){
        User u = UserManager.search(userId);
        double money = UserManager.getMoney(u);
        double price = CartManager.getPrice(item);
        if (price < money) {UserManager.subtractMoney(u, price);
        return true;}
        else return false;
    }
}
