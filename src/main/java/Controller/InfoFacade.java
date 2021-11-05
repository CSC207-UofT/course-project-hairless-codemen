package src.main.java.Controller;

import src.main.java.Entities.Cart;
import src.main.java.Entities.Item;
import src.main.java.Entities.Order;
import src.main.java.Use_cases.CartManager;
import src.main.java.Use_cases.ItemManager;
import src.main.java.Use_cases.OrderManager;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class InfoFacade {
    public static String printItems(){
        return ItemManager.printItems();
    }

    public static String printOrders(ArrayList<Order> orders){
        return OrderManager.printOrders(orders);
    }

    public static ArrayList<Item> getCartItems(Cart c){
        return CartManager.getItems(c);
    }

    public static String printCartItems(Cart c){
        return CartManager.print_items(c);
    }

    public static ArrayList<Item> getItems(){
        return ItemManager.getItemsList();
    }
}
