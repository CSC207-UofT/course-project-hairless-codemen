package src.main.java.Controller;

import src.main.java.Entities.Cart;
import src.main.java.Entities.Item;
import src.main.java.Entities.Order;
import src.main.java.Entities.User;
import src.main.java.Use_cases.CartManager;
import src.main.java.Use_cases.ItemManager;
import src.main.java.Use_cases.OrderManager;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class InfoFacade {
    public static String printItem(Item i){
        return ItemManager.printItem(i);
    }

    public static String printOrders(ArrayList<Order> orders){
        return OrderManager.printOrders(orders);
    }

    public static String printOrder(Order o){
        return OrderManager.printOrder(o);
    }

    public static String printOrders(User u){return OrderManager.printOrders(u);}

    public static String printItems(ArrayList<Item> items){return ItemManager.printItems(items);}

    public static ArrayList<Item> getCartItems(Cart c){
        return CartManager.getItems(c);
    }

    public static String printCartItems(Cart c){
        return CartManager.print_items(c);
    }

    public static void addCartElement(Cart c, Item i) {CartManager.AddElement(c, i);}

    public static ArrayList<Item> getItems(){
        return ItemManager.getItemsList();
    }
}
