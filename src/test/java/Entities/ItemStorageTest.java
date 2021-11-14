package src.test.java.Entities;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import src.main.java.Entities.Item;
import src.main.java.Entities.ItemStorage;
import src.main.java.Entities.User;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class ItemStorageTest {
    Item item1, item2, item3, item4;
    User u1, u2;
    ArrayList<Item> lst = new ArrayList<>();

    @BeforeEach
    void setup() {
        u1 = new User("Howard",  "012345678");
        u2 = new User("H", "6666");
        item1 = new Item("Cat", u1, 999999.99, "Pets");
        item2 = new Item("Airpods3", u2, 199.99, "Technology");
        item3 = new Item("iPhone14", u2, 2000.00, "Technology");
        item4 = new Item("Airpods3", u1, 179.99, "Technology");
        lst.add(item2);
        lst.add(item3);
        lst.add(item4);
        ArrayList<Item> items = ItemStorage.getItem();
        ItemStorage.deleteElement(items);
    }

    @Test
    public void TestAddElement(){
        ItemStorage.addElement(item1);
        ArrayList<Item> lst2 = new ArrayList<>();
        lst2.add(item1);
        assertEquals(lst2, ItemStorage.getItems().get("Cat"));
    }

    @Test
    public void TestAddElementMultiple(){
        ItemStorage.addElement(lst);
        ArrayList<Item> test2 = ItemStorage.getItems().get("Airpods3");
        assertTrue(test2.contains(item2));
        assertTrue(test2.contains(item4));
        ArrayList<Item> test3 = ItemStorage.getItems().get("iPhone14");
        assertTrue(test3.contains(item3));
        assertFalse(test3.contains(item1));
    }

    @Test
    public void TestDeleteElement(){
        ItemStorage.addElement(lst);
        ItemStorage.deleteElement(item3);
        assertNull(ItemStorage.getItems().get("iPhone14"));
        ItemStorage.deleteElement(item2);
        assertEquals(1, ItemStorage.getItems().get("Airpods3").size());
        assertTrue(ItemStorage.getItems().get("Airpods3").contains(item4));
    }


    @Test
    public void TestGetItem(){
        ItemStorage.addElement(lst);
        assertEquals(ItemStorage.getItem(0), item2);
        assertEquals(ItemStorage.getItem(1), item4);
        assertEquals(ItemStorage.getItem(2), item3);
    }

    @Test
    public void TestGetTotalNumber(){
        ItemStorage.addElement(lst);
        assertEquals(ItemStorage.getTotalNumber(), 3);
    }

    @Test
    public void TestAddELement2(){
        ArrayList<Item> lst2 = new ArrayList<>();
        lst2.add(item2);
        lst2.add(item4);
        Map<String, ArrayList<Item>> m = new HashMap<>();
        m.put("Airpods3", lst2);
        ItemStorage.addElement(m);
        assertEquals(ItemStorage.getTotalNumber(), 2);
        assertEquals(ItemStorage.getItem(), lst2);
    }

    @Test
    public void ItemStorageIterator(){
        ArrayList<Item> lst2 = new ArrayList<>();
        lst2.add(item2);
        lst2.add(item4);
        Map<String, ArrayList<Item>> m = new HashMap<>();
        m.put("Airpods3", lst2);
        ItemStorage.addElement(m);
        int i = 0;
        for (Item item : new ItemStorage()){
            assertEquals(item, lst2.get(i));
            i++;
        }
    }
}
