package src.main.java;

import src.main.java.Entities.Item;

public class CartManager {
    public static double getPrice(Item item){
        return item.getItemPrice();
    }

}
