package src.main.java.Entities;

import java.util.ArrayList;
import java.util.Arrays;

public class ItemStorage {
    private static final ArrayList<Item> userList = new ArrayList<Item>();

    public static void addElement(Item[] items){
        userList.addAll(Arrays.asList(items));
    }
}
