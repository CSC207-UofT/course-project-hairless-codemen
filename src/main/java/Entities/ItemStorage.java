package src.main.java.Entities;

import java.util.ArrayList;
import java.util.Arrays;

public class ItemStorage {
    private static final ArrayList<Item> userList = new ArrayList<Item>();

    /* Assume all the item has different names for now*/
    public static void addElement(Item[] items){
        userList.addAll(Arrays.asList(items));
    }

    public static void addElement(Item item){
        userList.add(item);
    }

    public static void removeElement(Item item){
        userList.remove(item);
    }
    /*later in the project we will add an overloaded method to remove a list of items from ItemStorage*/

    public static ArrayList<Item> getItems() {return ItemStorage.userList;}
}
