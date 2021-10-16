package src.main.java.Use_cases;

import src.main.java.Entities.Item;
import src.main.java.Entities.ItemStorage;
import src.main.java.Entities.User;
import src.main.java.Use_cases.Manager;

import java.util.ArrayList;

public class ItemManager implements Manager {

    @Override
    public Item search(String name) {
        return null;
    }

    @Override
    public void addElement(Object[] newItems) {
        for (Object item : newItems){
            ItemStorage is = new ItemStorage();
            is.addElement(item);
        }
    }

    public void addElement(Object item){
        ItemStorage is = new ItemStorage();
        is.addElement(item);
    }

    @Override
    public void removeElement(Object[] Items) {
        for (Object item : Items){
            ItemStorage is = new ItemStorage();
            is.deleteElement(item);
        }
    }

    @Override
    public void removeElement(Object element){
        ItemStorage is = new ItemStorage();
        is.deleteElement(element);
    }

    public static Item[] loadItems(User u){
        Item item1 = new Item("U of T Notebook", u, 10, "Study");
        Item item2 = new Item("Newborn British Shorthair", u, 1500, "Pets");
        Item item3 = new Item("Strawberries", u, 15, "Food");
        Item item4 = new Item("Happiness", u, 5000, "NotFromUofT");
        Item item5 = new Item("iPhone13", u, 20, "Electronics");
        Item[] itemList = new Item[]{item1, item2, item3, item4, item5};
        ItemStorage.addElement(itemList);
        return itemList;
    }

    public static ArrayList<Item> getItems(){
        return ItemStorage.getItems();
    }
}