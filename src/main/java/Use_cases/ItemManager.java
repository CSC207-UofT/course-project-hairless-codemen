package src.main.java.Use_cases;

import src.main.java.Entities.Item;
import src.main.java.Entities.ItemStorage;
import src.main.java.Entities.User;
import src.main.java.Use_cases.Manager;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Map;

public class ItemManager implements Manager {

    public ArrayList<Item> search(String name) {
        return getItems().get(name);
    }

    public static void addElement(ArrayList<Object> newItems) throws IOException {
        for (Object item : newItems){
            addElement(item);
        }
    }

    public static void addElement(Object item) throws IOException {
        ItemStorage.addElement(item);
        addItem((Item) item);
    }

    public static void addItem(Item i) throws IOException {
        //  Add a user to User.txt file.
        File f = new File("src/main/java/Files/Items.txt");
        FileOutputStream fos = new FileOutputStream(f);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(i);
    }

    public static void addItems(ArrayList<Item> items) throws IOException {
        for (Item item : items){
            addItem(item);
        }
    }

    public static void rewrite(Map<String, ArrayList<Item>> items) throws IOException {
        boolean deleted = new File("src/main/java/Files/Items.txt").delete();
        if (deleted){
            for (String itemName: items.keySet()){
                addItems(items.get(itemName));
            }
        }
    }

    public static void removeElement(Object[] Items) throws IOException {
        for (Object item : Items){
            removeElement(item);
        }
    }

    public static void removeElement(Object element) throws IOException {
        ItemStorage.deleteElement(element);
        Map<String, ArrayList<Item>> m = ItemStorage.getItems();
        rewrite(m);
    }

    public static Item[] loadItems(User u){
        Item item1 = new Item("U of T Notebook", u, 10, "Study");
        Item item2 = new Item("Newborn British Shorthair", u, 1500, "Pets");
        Item item3 = new Item("Strawberries", u, 15, "Food");
        Item item4 = new Item("Happiness", u, 5000, "NotFromUofT");
        Item item5 = new Item("iPhone13", u, 20, "Electronics");
        Item[] itemList = new Item[]{item1, item2, item3, item4, item5};
        ItemStorage.addElement(itemList);
        return itemList;
    }

    public static Map<String, ArrayList<Item>> getItems(){
        return ItemStorage.getItems();
    }
}
