package src.main.java.Entities;

import java.io.Serializable;
import java.util.*;

public class ItemStorage implements Storable, Serializable, Iterable<Item> {
    private static final Map<String, ArrayList<Item>> itemList = new HashMap<>();

    /**
     * Get the current item storage data in its original format.
     *
     * @return The hashmap of item storage.
     */
    public static Map<String, ArrayList<Item>> getItems() {
        return ItemStorage.itemList;
    }

    /**
     * Get the current item storage data in a list format.
     *
     * @return The Arraylist of all items in item storage.
     */
    public static ArrayList<Item> getItem(){
        ArrayList<Item> items = new ArrayList<>();
        for (String itemName: getItems().keySet()){
            items.addAll(getItems().get(itemName));
        }
        return items;
    }

    /**
     * Get the current size of item storage.
     *
     * @return how many item(s) are stored in the item storage.
     */
    public static int getTotalNumber() {
        int total = 0;
        for (String name: itemList.keySet()){
            total += itemList.get(name).size();
        }
        return total;
    }

    /**
     * Get the item representing the current index
     * @param index - the index of the item want to be retrieved.
     * @return The Item corresponding to the given index.
     * @throws IndexOutOfBoundsException if the given index is greater than or equal to the size of the item storage.
     */
    public static Item getItem(int index){
        int current = 0;
        for (String name: itemList.keySet()){
            for (Item i: itemList.get(name)){
                if (current == index){
                    return i;
                }
                current += 1;
            }
        }
        throw new IndexOutOfBoundsException();
    }

    /**
     * Add an item to the item storage. If an identical item already exist in the hashmap, we can simply add the item;
     * If not, we create a new array list that contains the Item and add to hashmap with name of the Item as the key.
     *
     * We define two items identical IFF their name, category and price are all identical.
     *
     * @param item The Item we want to add.
     */


    private static void addItem(Item item) {
        if (itemList.containsKey(item.getItemName()) &
                Objects.equals(itemList.get(item.getItemName()).get(0).toString2(), item.toString2())){
            itemList.get(item.getItemName()).add(item);
        }
        else{
            ArrayList<Item> itemList = new ArrayList<>();
            itemList.add(item);
            ItemStorage.itemList.put(item.getItemName(), itemList);
        }
    }

    /**
     * Delete an item from the item storage. If there is only one identical item left in stock, we can simply delete the
     * item; If not, we subtract one from the current number of items in stock.
     *
     * We define two items identical IFF their name, category and price are all identical.
     *
     * @param item The Item we want to delete.
     */
    private static void deleteItem(Item item)  {
        if (itemList.get(item.getItemName()).size() == 1 &
                Objects.equals(itemList.get(item.getItemName()).get(0).toString2(), item.toString2())){
            itemList.remove(item.getItemName());
        }
        else if (itemList.get(item.getItemName()).size() > 1 &
                Objects.equals(itemList.get(item.getItemName()).get(0).toString2(), item.toString2())){
            itemList.get(item.getItemName()).remove(item);
        }
        else{
            //TODO: Need to throw exception. We can not delete an not existing item.
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
     * Add a list of items to the item storage.
     *
     * @param items The list of items we want to add.
     */
    public static void addElement(ArrayList<Item> items){
        for (Item item : items) {
            addItem(item);
        }
    }

    /**
     * Add a hashmap of items to the item storage.
     * The keys in the hashmap represents the item name and the array list of items corresponding to each key contains
     * items that are under name which the key refers to.
     * @param items The hashmap of items we want to add.
     */
    public static void addElement(Map<String, ArrayList<Item>> items) {
        ArrayList<Item> item = new ArrayList<>();
        for (String key : items.keySet()) {
            item.addAll(items.get(key));
        }
        addElement(item);
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

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<Item> iterator() {
        return new ItemIterator();
    }

    private static class ItemIterator implements Iterator<Item>{
        private int current = 0;
        /**
         * Returns {@code true} if the iteration has more elements.
         * (In other words, returns {@code true} if {@link #next} would
         * return an element rather than throwing an exception.)
         *
         * @return {@code true} if the iteration has more elements
         */
        @Override
        public boolean hasNext() {
            return current < getTotalNumber();
        }

        /**
         * Returns the next element in the iteration.
         *
         * @return the next element in the iteration
         * @throws NoSuchElementException if the iteration has no more elements
         */
        @Override
        public Item next() {
            Item i;
            try{
                i = getItem(current);
            }catch(IndexOutOfBoundsException e){
                throw new NoSuchElementException();
            }
            current += 1;
            return i;
        }
    }
}
