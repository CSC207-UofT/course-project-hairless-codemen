package src.main.java.Use_cases;

import src.main.java.Entities.Cart;
import src.main.java.Entities.Item;
import src.main.java.Entities.User;

import java.util.ArrayList;

public class CartManager {
    /**
     * Remove a list of items from a user's cart.
     * @param u - the user whose cart will be where the items are going to be removed from.
     * @param items - the items to be removed from the cart.
     */
    public static void remove_items(User u, ArrayList<Item> items){
        u.getCart().removeItem(items);
    }

    /**
     * Return a string representation of all items in a cart.
     * @param c - the cart of which the string representation will be returned.
     * @return a string representation of all items in the cart.
     */
    public static String print_items(Cart c){
        StringBuilder sb = new StringBuilder();
        for (Item i: c.getItems()){
            sb.append(i);
        }
        return sb.toString();
    }

    /**
     * Add an item to a cart.
     * @param c - the cart where the item will be added.
     * @param i - the item to be added into the cart.
     */
    public static void AddElement(Cart c, Item i){
        c.addItem(i);
    }

    /**
     * Add an item to a cart.
     * @param c - the cart where the item will be added.
     * @param i - the item to be added into the cart.
     * @param q - the quantity to be added
     */
    public static void AddElement(Cart c, Item i, int q){
        c.addItem(i, q);
    }

    /**
     * Remove an item from a cart.
     * @param c - the cart where the item will be removed.
     * @param i - the item to be removed from the cart.
     */
    public static void removeElement(Cart c, Item i){
        c.removeItem(i);
    }

    /**
     * Return all items in a cart.
     * @param c - the cart where all items where be returned in an ArrayList format.
     * @return the ArrayList of items stored in the cart.
     */
    public static ArrayList<Item> getItems(Cart c){
        return c.getItems();
    }

    /**
     * Return the total price of all items in a cart
     * @param c - the cart we are interested in
     *
     * @return the total price of all items
     */
    public static double getTotalPrice(Cart c) {
        return c.getTotalPrice();
    }
}
