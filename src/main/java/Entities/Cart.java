package src.main.java.Entities;

import java.io.Serializable;
import java.util.*;

public class Cart implements Serializable{
    private Map<Item, Integer> items;

    /**
     * Constructor of Cart that has list of items
     * @param cart A Hashmap of items in the cart along with each of their quantity
     */
    public Cart(HashMap<Item, Integer> cart){

        this.items = cart;
    }

    /**
     * Constructor of a complete new cart
     */
    public Cart(){

        this.items = new HashMap<>();
    }

    public Map<Item, Integer> getCart(){
        return items;
    }

    /**
     * get the items in the cart
     * @return a list of items in the cart
     */

    public ArrayList<Item> getItems(){
        return new ArrayList<>(items.keySet());
    }

    /**
     * add single item to the cart
     * @param item single item will be added into cart
     */
    public void addItem(Item item){
        items.put(item, 1);
    }

    /**
     * add single item to the cart
     * @param item single item will be added into cart
     */
    public void addItem(Item item, int q){
        Integer res = q;
        if (items.containsKey(item)){
            res += items.get(item);
        }
        items.put(item, res);
    }

    /**
     *Remove a list of items from cart
     * @param item - list of items to be removed from cart
     */
    public void removeItem(ArrayList<Item> item){
        for (Item i : item){

            removeItem(i);
        }
    }

    /**
     *Remove a single item from cart
     * @param item - single item to be removed from cart
     */
    public void removeItem(Item item){
        items.remove(item);
    }

    public double getTotalPrice(){
        double price = 0;
        for (Map.Entry<Item, Integer> entry : items.entrySet()){
            price += entry.getKey().getItemPrice();
        }
        return price;
    }
}
