package src.main.java.Use_cases;

import src.main.java.Entities.Item;
import src.main.java.Entities.ItemStorage;
import src.main.java.Entities.User;

import java.util.ArrayList;
import java.util.Map;

public class ItemManager implements Manager {

    public ArrayList<Item> search(String name) {
        return getItems().get(name);
    }

    public static double get_all_price(ArrayList<Item> items){
        double i = 0;
        for (Item item: items){
            i += item.getItemPrice();
        }
        return i;
    }

    public void addElement(Object[] newItems) {
        for (Object item : newItems){
            addElement(item);
        }
    }

    public static void addElement(Object item){
        ItemStorage.addElement(item);
    }


    public static void removeElement(Object[] Items) {
        for (Object item : Items){
            ItemStorage.deleteElement(item);
        }
    }

    public static void removeElement(Object element){
        ItemStorage.deleteElement(element);
        Map<String, ArrayList<Item>> m = ItemStorage.getItems();

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

    public static ArrayList<Item> getItemsList(){
        ArrayList<Item> items = new ArrayList<>();
        for (Item i : new ItemStorage()){
            items.add(i);
        }
        return items;
    }

    public static String printItems(){
        StringBuilder sb = new StringBuilder();
        for (Item i: new ItemStorage()){
            sb.append(i);
        }
        return sb.toString();
    }

    public static String printItem(Item i){
        return i.toString();
    }
}

