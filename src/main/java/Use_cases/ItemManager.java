package src.main.java.Use_cases;

import src.main.java.Entities.Item;
import src.main.java.Entities.ItemStorage;
import src.main.java.Entities.User;

import java.util.*;

public class ItemManager implements Manager {

    /**
     * Search for items using item name.
     * @param name - the name using which the search of items will be performed.
     * @return an ArrayList of items matching the name given, they don't need to be an exact match, just need to contain
     * the string name somewhere in their item names.
     */
    public static ArrayList<Item> search(String name) {
        ArrayList<Item> results = new ArrayList<>();
        String target = name.toLowerCase();
        for (Map.Entry<String, ArrayList<Item>> entry : ItemStorage.getItems().entrySet()){
            String current = entry.getKey().toLowerCase();
            if (current.contains(target) || target.contains(current)){
                results.addAll(entry.getValue());
            }
        }
        return results;
    }

    /**
     * Search for items using their owner's name.
     * @param name - the owner's name using which the search of items will be performed.
     * @return an ArrayList of items having the owner whose name is the exact match of the name given.
     */
    public static ArrayList<Item> search_by_owner(String name){
        ArrayList<Item> results = new ArrayList<>();
        for (ArrayList<Item> i : ItemStorage.getItems().values()){
            for (Item j : i){
                if (j.getOwner().getName().equals(name)) {
                    results.add(j);
                }
            }
        }
        return results;
    }

    /**
     * Search for items using category name.
     * @param name - the item's category name using which the search of items will be performed.
     * @return an ArrayList of items in the categories whose names contain the string <name> somewhere.
     */
    public static ArrayList<Item> search_by_category(String name){
        ArrayList<Item> results = new ArrayList<>();
        String target = name.toLowerCase();
        for (Map.Entry<String, ArrayList<Item>> entry : ItemStorage.getItems().entrySet()){
            List<Item> current = entry.getValue();
            for (Item i: current) {
                if (i.getCategory().toLowerCase().contains(target) || target.contains(i.getCategory())){
                    results.add(i);
                }
            }
        }
        return results;
    }

    /**
     * Get the total price for a list of items.
     * @param items - the list of items whose total price is calculated.
     * @return a double value representing the total price for the list of items.
     */
    public static double get_all_price(ArrayList<Item> items){
        double i = 0;
        for (Item item: items){
            i += item.getItemPrice();
        }
        return i;
    }
    public static double get_price(Item item){
        return item.getItemPrice();}

    /**
     * Add a list of items into Item Storage.
     * @param newItems  - the list of items to be added into Item Storage.
     */
    public static void addElement(ArrayList<Item> newItems) {
        for (Item item : newItems){
            addElement(item);
        }
    }
    /**
     * Add a single item into Item Storage.
     * @param item  - the single item to be added into Item Storage.
     */
    public static void addElement(Object item){
        ItemStorage.addElement(item);
    }


    /**
     * Remove a list of items from Item Storage.
     * @param items  - the list of items to be removed from Item Storage.
     */
    public static void removeElements(ArrayList<Item> items) {
        for (Object item : items){
            ItemStorage.deleteElement(item);
        }
    }

    /**
     * Remove a single item from Item Storage.
     * @param element  - the item to be removed from Item Storage.
     */
    public static void removeElement(Object element){
        ItemStorage.deleteElement(element);
    }

    /**
     * Load a preset list of items into Item Storage at the beginning of the program if there are no item currently
     * stored in the system.
     * @param u - the user who will be the owner of all preset items to be loaded into the system.
     */
    public static void loadItems(User u){
        Item item1 = new Item("U of T Notebook", u, 10, "Study");
        Item item2 = new Item("Newborn British Shorthair", u, 1500, "Pets");
        Item item3 = new Item("Strawberries", u, 15, "Food");
        Item item4 = new Item("Happiness", u, 5000, "NotFromUofT");
        Item item5 = new Item("iPhone13", u, 20, "Electronics");
        Item[] itemList = new Item[]{item1, item2, item3, item4, item5};
        ArrayList<Item> items = new ArrayList<>(List.of(itemList));
        ItemStorage.addElement(items);
    }

    /**
     * Get the current item storage data in its original format.
     *
     * @return The hashmap of item storage.
     */
    public static Map<String, ArrayList<Item>> getItems(){
        return ItemStorage.getItems();
    }

    /**
     * Get the current item storage data in a list format.
     *
     * @return The Arraylist of all items in item storage.
     */
    public static ArrayList<Item> getItemsList(){
        ArrayList<Item> items = new ArrayList<>();
        for (Item i : new ItemStorage()){
            items.add(i);
        }
        return items;
    }

    /**
     * Return a string representation for a list of items.
     * @param items - the list of items whose string representation will be returned.
     * @return a string representation for a list of items.
     */
    public static String printItems(ArrayList<Item> items){
        StringBuilder sb = new StringBuilder();
        for (Item i: items){
            sb.append(i).append("\n");
        }
        return sb.toString();
    }

    /**
     * Return a string representation for a single item.
     * @param i - the item whose string representation will be returned.
     * @return a string representation for a single item.
     */
    public static String printItem(Item i){
        return i.toString();
    }

    /**
     * Return the seller of an item.
     * @param i - the item whose seller will be returned.
     * @return a User object representing the seller of this item.
     */
    public static User getSeller(Item i){
        return i.getOwner();
    }

    /**
     * Return the quantity of item
     *
     * @param item the item to check for quantity
     */
    public static int getQuantity(Item item){
        return item.getQuantity();
    }
}