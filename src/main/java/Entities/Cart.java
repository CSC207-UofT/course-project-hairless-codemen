package src.main.java.Entities;

import java.util.ArrayList;
import java.util.Arrays;

public class Cart {
    private final ArrayList<Item> items;

    /*constructor of Cart class*/
    public Cart(ArrayList<Item> items){
        this.items = items;
    }

   /* another constructor of Cart Class*/
    public Cart(){
        this.items = new ArrayList<Item>();
    }

    /*return a list of items in Cart*/
    public ArrayList<Item> getItems(){
        return this.items;
    }

    /*add a list of items to Cart*/
    public void addItem(Item[] item)
    {items.addAll(Arrays.asList(item));
    }

    /*add one item to the Cart*/
    public void addItem(Item item){
        items.add(item);
    }

    /*remove a list of item in the Cart*/
    public void removeItem(Item[] item){
        for (Item i : item){
            items.remove(i);
        }
    }
}
