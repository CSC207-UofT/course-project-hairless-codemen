package src.main.java.Entities;

import java.util.ArrayList;
import java.util.Arrays;

public class ItemStorage {
    private static ArrayList<Item> userList = new ArrayList<Item>();

    public static void addElement(Item[] items){
        userList.addAll(Arrays.asList(items));
    }

    public static void addElement(Item item){
        userList.add(item);
    }

    public static void removeElement(Item item){
        userList.remove(item);
    }

    public static ArrayList<Item> getItems() {return ItemStorage.userList;}
}
