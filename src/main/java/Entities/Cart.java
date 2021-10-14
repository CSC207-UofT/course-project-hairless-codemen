package src.main.java.Entities;

import java.util.ArrayList;

public class Cart {
    private final ArrayList<Item> items;

    public Cart(ArrayList<Item> items){
        this.items = items;
    }

    public Cart(){
        this.items = new ArrayList<Item>();
    }

    public void add_item(Item item){
        items.add(item);}

    public void remove_item(Item[] item){
        for (Item i : item){
            items.remove(i);
        }
    }
}
