package src.main.java.Use_cases;

import src.main.java.Entities.Item;
import src.main.java.Entities.ItemStorage;
import src.main.java.Entities.User;

import java.util.*;

public class ItemManager implements Manager {

    public static ArrayList<Item> search(String name) {
        ArrayList<Item> results = new ArrayList<>();
        String target = name.toLowerCase();
        for (Map.Entry<String, ArrayList<Item>> entry : ItemStorage.getItems().entrySet()){
            String current = entry.getKey().toLowerCase();
            if (current.contains(target)){
                results.addAll(entry.getValue());
            }
        }
        return results;
    }

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
            System.out.println(item);
        }
    }

    public static void addElement(Object item){
        ItemStorage.addElement(item);
    }


    public static void removeElement(Object[] items) {
        for (Object item : items){
            ItemStorage.deleteElement(item);
        }
    }

    public static void removeElement(Object element){
        ItemStorage.deleteElement(element);
        Map<String, ArrayList<Item>> m = ItemStorage.getItems();

    }

    public static ArrayList<Item> loadItems(User u){
        Item item1 = new Item("U of T Notebook", u, 10, "Study");
        Item item2 = new Item("Newborn British Shorthair", u, 1500, "Pets");
        Item item3 = new Item("Strawberries", u, 15, "Food");
        Item item4 = new Item("Happiness", u, 5000, "NotFromUofT");
        Item item5 = new Item("iPhone13", u, 20, "Electronics");
        Item[] itemList = new Item[]{item1, item2, item3, item4, item5};
        ArrayList<Item> items = new ArrayList<>(List.of(itemList));
        ItemStorage.addElement(items);
        System.out.println("Added");
        return items;
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

    public static String printItems(ArrayList<Item> items){
        StringBuilder sb = new StringBuilder();
        for (Item i: items){
            sb.append(i).append("\n");
        }
        return sb.toString();
    }

    public static String printItem(Item i){
        return i.toString();
    }
}

