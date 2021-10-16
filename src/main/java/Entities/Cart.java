package src.main.java.Entities;

import java.util.ArrayList;
import java.util.Arrays;

public class Cart {
    private final ArrayList<Item> items;

    public Cart(ArrayList<Item> items){

        this.items = items;
    }

    public Cart(){

        this.items = new ArrayList<Item>();
    }

    public ArrayList<Item> getItems(){

        return this.items;
    }

    public void addItems(Item[] item) {

        items.addAll(Arrays.asList(item));
    }

    public void addItem(Item item){

        items.add(item);
    }

    public void removeItem(Item[] item){
        for (Item i : item){
            items.remove(i);
        }
    }
}
