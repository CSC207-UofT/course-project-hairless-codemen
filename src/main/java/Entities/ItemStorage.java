package src.main.java.Entities;

import java.util.ArrayList;
import java.util.Arrays;

public class ItemStorage extends Storage{
    private static final ArrayList<Item> userList = new ArrayList<Item>();

    @Override
    public int getTotalNumber() {
        return 0;
    }

    @Override
    public void addElement(Object object) {
        userList.add((Item) object);
    }

    @Override
    public void deleteElement(Object object) {
    }

    public static void addElement(Item[] items){
        userList.addAll(Arrays.asList(items));
    }

    public static ArrayList<Item> getItems() {return ItemStorage.userList;}
}
