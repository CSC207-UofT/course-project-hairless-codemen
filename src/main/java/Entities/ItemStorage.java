package src.main.java.Entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ItemStorage implements Storable, Serializable {
    private static final Map<String, ArrayList<Item>> userList = new HashMap<>();

    public static void addElement(Item[] items){
        for (Item item : items){
            addItem(item);
        }
    }

    public static Map<String, ArrayList<Item>> getItems() {return ItemStorage.userList;}

    int getTotalNumber() {
        return 0;
    }

    public static void addElement(Object object) {
        Item item = (Item) object;
        addItem(item);
    }

    private static void addItem(Item item) {
        if (userList.get(item.getItemName()) != null){
            userList.get(item.getItemName()).add(item);
        }
        else{
            ArrayList<Item> itemList = new ArrayList<>();
            itemList.add(item);
            userList.put(item.getItemName(), itemList);
        }
    }

    public static void deleteElement(Object object) {
        ArrayList<Item> itemList = userList.get(((Item) object).getItemName());
        if (itemList.size() == 1){
            userList.remove(((Item) object).getItemName());
        }
        else{
            itemList.remove((Item) object);
        }
    }
}
