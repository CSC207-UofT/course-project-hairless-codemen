package src.main.java.Entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ItemStorage implements Storable, Serializable {
    private static final Map<String, ArrayList<Item>> userList = new HashMap<>();

    /**
     * Get the current item storage.
     *
     * @return The hashmap of item storage.
     */
    public static Map<String, ArrayList<Item>> getItemsList() {return ItemStorage.userList;}

    /**
     * Add an item to the item storage. If the item's name already exist in the hashmap, we can simply add the item;
     * If not, we create a new array list that contains the Item and add to hashmap with name of the Item as the key.
     *
     * @param item The Item we want to add.
     */
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

    /**
     * Add an item to the item storage.
     *
     * @param object The Item we want to add.
     */
    public static void addElement(Object object) {
        Item item = (Item) object;
        addItem(item);
    }

    /**
     * Delete an item from the item storage.
     *
     * @param object The Item we want to add.
     */
    public static void deleteElement(Object object) {
        ArrayList<Item> itemList = userList.get(((Item) object).getItemName());
        if (itemList.size() == 1){
            userList.remove(((Item) object).getItemName());
        }
        else
            itemList.remove((Item) object);
    }

    /**
     * Add mutiple items to the item storage.
     *
     * @param items The Item we want to add.
     */
    public static void addElements(ArrayList<Item> items){
        for (Item item : items){
            addItem(item);
        }
    }

    int getTotalNumber() {
        return 0;
    }

}
