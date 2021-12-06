package src.main.java.Controller;

import src.main.java.Entities.Cart;
import src.main.java.Entities.Item;
import src.main.java.Entities.Order;
import src.main.java.Entities.User;
import src.main.java.Use_cases.CartManager;
import src.main.java.Use_cases.ItemManager;
import src.main.java.Use_cases.OrderManager;

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
     * Return a string representation of an item's name.
     * @param i - the item whose name will be returned.
     * @return a string representation of an item's name.
     */
    public static String printItemName(Item i){
        return i.getItemName();
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
    public static String printOrders(User u){
        return OrderManager.printOrders(u);
    }

    /**
     * Return a string representation of a list of items.
     * @param items - the ArrayList of items whose string representation will be returned.
     * @return a string representation of all orders in the ArrayList orders.
     */
    public static String printItems(ArrayList<Item> items){
        return ItemManager.printItems(items);
    }

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
    public static void addCartElement(Cart c, Item i) {
        CartManager.AddElement(c, i);
    }


    /**
     * Add a certain quantity of an item to cart.
     * @param c - the Cart to which the item will be added.
     * @param i - the Item to be added into the cart.
     * @param q - the number of the same item to be added into the cart
     *
     * @return true if the item is successfully added, given enough quantity is in stock
     */
    public static boolean addCartElement(Cart c, Item i, int q){
        if (ItemManager.getQuantity(i) < q){
            return false;
        }
        CartManager.AddElement(c, i, q);
        return true;
    }

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


    /**
     * Add a list of items into Item Storage.
     * @param o  - the list of items to be added into Item Storage.
     */
    public static void addElement(Object o){
        ItemManager.addElement(o);
    }


    /**
     * Add a list of items into Item Storage.
     * @param items  - the list of items to be added into Item Storage.
     */
    public static void addElement(Object[] items){
        ItemManager.addElement(items);
    }


    /**
     * Remove a single item from Item Storage.
     * @param o  - the item to be removed from Item Storage.
     */
    public static void removeElement(Object o){
        ItemManager.removeElement(o);
    }


    /**
     * Remove a list of items from Item Storage.
     * @param items  - the list of items to be removed from Item Storage.
     */
    public static void removeElement(Object[] items){
        ItemManager.removeElement(items);
    }
}
