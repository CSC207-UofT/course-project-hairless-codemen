package src.main.java.Entities;

import java.util.ArrayList;
import java.util.Arrays;

public class ItemStorage implements Storable{
    private static final ArrayList<Item> userList = new ArrayList<Item>();

    public static void addElement(Item[] items){
        userList.addAll(Arrays.asList(items));
    }

    public static ArrayList<Item> getItems() {return ItemStorage.userList;}

    int getTotalNumber() {
        return 0;
    }

    public static void addElement(Object object) {
        userList.add((Item) object);
    }

    public static void deleteElement(Object object) {
        userList.remove((Item) object);
    }
}
