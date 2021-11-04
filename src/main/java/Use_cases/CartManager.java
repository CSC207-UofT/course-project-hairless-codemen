package src.main.java.Use_cases;

import src.main.java.Entities.Cart;
import src.main.java.Entities.Item;
import src.main.java.Entities.User;

import java.util.ArrayList;

public class CartManager {
    public static double getPrice(Item item){
        return item.getItemPrice();
    }

    public static void remove_items(User u, ArrayList<Item> items){
        u.getCart().removeItem(items);

    }
}
