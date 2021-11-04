package src.main.java.Entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

public class Cart implements Serializable {
    private final ArrayList<Item> items;

    /**
     * Constructor of Cart that has list of items
     * @param items An Arraylist of items in the cart
     */
    public Cart(ArrayList<Item> items){

        this.items = items;
    }

    /**
     * Constructor of a complete new cart
     */
    public Cart(){

        this.items = new ArrayList<Item>();
    }

    /**
     * get the items in the cart
     * @return a list of items in the cart
     */

    public ArrayList<Item> getItems(){

        return this.items;
    }

    /**
     * add a list of items into cart
     * @param item list of Item will be added into cart
     */
    public void addItem(Item[] item) {

        items.addAll(Arrays.asList(item));
    }


    /**
     * add single item to the cart
     * @param item single item will be added into cart
     */
    public void addItem(Item item){

        items.add(item);
    }

    /**
     *Remove item from
     * @param item
     */
    public void removeItem(ArrayList<Item> item){
        for (Item i : item){
            items.remove(i);
        }
    }
}
