package src.test.java.Use_cases;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import src.main.java.Entities.Item;
import src.main.java.Entities.ItemStorage;
import src.main.java.Entities.User;
import src.main.java.Use_cases.ItemManager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class ItemManagerTest {
    Item item1, item2, item3, item4;
    User u1, u2, u3;
    @BeforeEach
    void setup(){
        u1 = new User("A", "1234");
        u2 = new User("B", "2345");
        u3 = new User("C", "3456");
        item1 = new Item("Cat", u1, 999999.99, "Pets");
        item2 = new Item("Airpods3", u2, 199.99, "Technology");
        item3 = new Item("iPhone14", u3, 2000.00, "Technology");
        item4 = new Item("Airpods3", u1, 179.99, "Technology");
        ArrayList<Item> items = ItemStorage.getItem();
        ItemStorage.deleteElement(items);
        ItemStorage.addElement(item1);
        ItemStorage.addElement(item2);
        ItemStorage.addElement(item3);
        ItemStorage.addElement(item4);
    }

    @Test
    public void TestSearch(){
        ArrayList<Item> expected = new ArrayList<>();
        expected.add(item2);
        expected.add(item4);
        assertEquals(expected, ItemManager.search("airpods"));
        ArrayList<Item> expected_2 = new ArrayList<>();
        expected_2.add(item1);
        assertEquals(expected_2, ItemManager.search("Cat"));
    }

    @Test
    public void TestSearch_by_owner(){
        ArrayList<Item> expected = new ArrayList<>();
        expected.add(item1);
        expected.add(item4);
        assertEquals(expected, ItemManager.search_by_owner("A"));
        ArrayList<Item> expected_2 = new ArrayList<>();
        expected_2.add(item3);
        assertEquals(expected_2, ItemManager.search_by_owner("C"));
    }

    @Test
    public void TestSearchByCategory(){
        ArrayList<Item> items = ItemManager.search_by_category("Technology");
        assertEquals(3, items.size());
        assertTrue(items.contains(item2));
        assertTrue(items.contains(item3));
        assertTrue(items.contains(item4));
    }

    @Test
    public void TestGetPrice(){
        assertEquals(2000.00, ItemManager.get_price(item3));
        assertEquals(179.99, ItemManager.get_price(item4));
    }


    @Test
    public void TestGetSeller(){
        assertEquals(u1, ItemManager.getSeller(item1));
        assertEquals(item2.getQuantity(), ItemManager.getQuantity(item2));
    }

    @Test
    public void TestRemoveELement2(){
        ItemManager.removeElement(item2);
        assertEquals(3, ItemManager.getItemsList().size());
        assertFalse(ItemManager.getItemsList().contains(item2));
    }

    @Test
    public void TestLoadItems(){
        ItemStorage.deleteElement(ItemStorage.getItem());
        ItemManager.loadItems(u1);
        Item item1 = new Item("U of T Notebook", u1, 10, "Study");
        Item item2 = new Item("Newborn British Shorthair", u1, 1500, "Pets");
        Item item3 = new Item("Strawberries", u1, 15, "Food");
        Item item4 = new Item("Happiness", u1, 5000, "NotFromUofT");
        Item item5 = new Item("iPhone13", u1, 20, "Electronics");
        Item[] itemList = new Item[]{item1, item2, item3, item4, item5};
        ArrayList<Item> items = new ArrayList<>(List.of(itemList));
        ItemStorage.deleteElement(items);
        assertEquals(0, ItemManager.getItemsList().size());
    }

    @Test
    public void TestGetItems(){
        ItemStorage.deleteElement(item3);
        assertEquals(ItemManager.getItems(), ItemStorage.getItems());
    }

    @Test
    public void TestPrintItems(){
        ArrayList<Item> items = new ArrayList<>();
        items.add(item1);
        items.add(item2);
        assertEquals(ItemManager.printItems(items), item1.toString() + "\n" + item2.toString() + "\n");
    }

    @Test
    public void TestPrintItem(){
        assertEquals(ItemManager.printItem(item1), item1.toString());
    }
}