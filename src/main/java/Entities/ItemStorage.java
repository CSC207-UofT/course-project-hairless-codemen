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
    public static Map<String, ArrayList<Item>> getItems() {
        return ItemStorage.userList;
    }

    /**
     * Get the current size of item storage.
     *
     * @return how many item(s) in the storage.
     */
    int getTotalNumber() {
        return userList.size();
    }

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
     * Delete an item from the item storage. If there is one left in stock, we can simply delete the item;
     * If not, we subtract one from the current number of items in stock.
     *
     * @param item The Item we want to delete.
     */
    private static void deleteItem(Item item)  {
        if (userList.get(item.getItemName()).size() == 1){
            userList.remove(item.getItemName());
        }
        else
            userList.get(item.getItemName()).remove(item);
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
     * Add multiple items to the item storage.
     *
     * @param items The Item we want to add.
     */
    public static void addElement(ArrayList<Item> items){
        for (Item item : items){
            addElement(item);
        }
    }


    /**
     * Delete an item from the item storage.
     *
     * @param object The Item we want to delete.
     */
    public static void deleteElement(Object object) {
        Item item = (Item) object;
        deleteItem(item);
    }

    /**
     * Delete multiple items from the item storage.
     *
     * @param items The Items we want to delete.
     */
    public static void deleteElement(ArrayList<Item> items){
        for (Item item : items){
            deleteItem(item);
        }
    }
}
