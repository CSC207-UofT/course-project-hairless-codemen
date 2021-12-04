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

    /**
     * Return a string representation of a single item.
     * @param i - the item whose string representation will be returned.
     * @return a string representation of a single item.
     */
    public static String printItem(Item i){
        return ItemManager.printItem(i);
    }

    /**
     * Return a string representation of a list of orders.
     * @param orders - the ArrayList of orders whose string representation will be returned.
     * @return a string representation of all orders in the ArrayList orders.
     */
    public static String printOrders(ArrayList<Order> orders){
        return OrderManager.printOrders(orders);
    }

    /**
     * Return a string representation of a single order.
     * @param o - the order whose string representation will  be returned.
     * @return a string representation of a single order o.
     */
    public static String printOrder(Order o){
        return OrderManager.printOrder(o);
    }

    /**
     * Return a string representation of all orders made by a specific user.
     * @param u - the User from which a string representation of all orders will be returned.
     * @return a string representation of all orders in the ArrayList orders.
     */
    public static String printOrders(User u){return OrderManager.printOrders(u);}

    /**
     * Return a string representation of a list of items.
     * @param items - the ArrayList of items whose string representation will be returned.
     * @return a string representation of all orders in the ArrayList orders.
     */
    public static String printItems(ArrayList<Item> items){return ItemManager.printItems(items);}

    /**
     * Return all items of a given Cart.
     * @param c - the Cart in which all items will be returned.
     * @return an ArrayList of all items in the cart.
     */
    public static ArrayList<Item> getCartItems(Cart c){
        return CartManager.getItems(c);
    }

    /**
     * Return a string representation of all items of a given Cart.
     * @param c - the Cart in which a string representation of all items will be returned.
     * @return a string representation of all items in the cart.
     */
    public static String printCartItems(Cart c){
        return CartManager.print_items(c);
    }

    /**
     * Add an item to a given cart.
     * @param c - the Cart to which the item will be added.
     * @param i - the Item to be added into the cart.
     */
    public static void addCartElement(Cart c, Item i) {CartManager.AddElement(c, i);}

    /**
     * Remove an item from a given cart.
     * @param c - the Cart from which the item will be removed.
     * @param i - the Item to be removed from the cart.
     */
    public static void removeCartElement(Cart c, Item i){CartManager.removeElement(c, i);}

    /**
     * Return the list of all items stored in the system.
     * @return an ArrayList of all items stored in the system.
     */
    public static ArrayList<Item> getItems(){
        return ItemManager.getItemsList();
    }
}
