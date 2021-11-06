package src.test.java.Use_cases;

import org.junit.After;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import src.main.java.Entities.Item;
import src.main.java.Entities.ItemStorage;
import src.main.java.Entities.User;
import src.main.java.Use_cases.ItemManager;

import java.util.ArrayList;

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
}