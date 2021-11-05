package src.main.java.Controller;

import src.main.java.Entities.Cart;
import src.main.java.Entities.Order;
import src.main.java.Use_cases.CartManager;
import src.main.java.Use_cases.ItemManager;
import src.main.java.Use_cases.OrderManager;

import java.util.ArrayList;

public class InfoFacade {
    public static void printItems(){
        ItemManager.printItems();
    }

    public static void printOrders(ArrayList<Order> orders){
        OrderManager.printOrders(orders);
    }

    public static void getCartItems(Cart c){
        CartManager.getItems(c);
    }

    public static void printCartItems(Cart c){
        CartManager.print_items(c);
    }
}
