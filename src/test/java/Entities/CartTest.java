package src.test.java.Entities;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import src.main.java.Entities.Item;
import src.main.java.Entities.Cart;
import src.main.java.Entities.User;
import src.main.java.Use_cases.CartManager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CartTest {
    Cart c;
    Item item1, item2, item3, item4, item5;
    User u;
    HashMap<Item, Integer> map1 = new HashMap<>();
    HashMap<Item, Integer> map2 = new HashMap<>();

    @BeforeEach
    void setup() {
        c = new Cart(map1);
        u = new User("JoJo", "1234", 9999.99);
        item1 = new Item("Hina", u, 999999.99, "Pets");
        item2 = new Item("X", u, 111, "Mysterious");
        item3 = new Item("iPhone14", u, 2000.00, "Technology");
        item4 = new Item("Airpods3", u, 179.99, "Technology");
        item5 = new Item("EDG Hoodie", u, 77.00, 7, "Technology");
        map2.put(item3, 1);
        map2.put(item4, 1);
    }

    @Test
    public void TestAddItem() {
        HashMap<Item, Integer> map3 = new HashMap<>();
        c.addItem(item1);
        map3.put(item1, 1);
        assertEquals(new ArrayList<>(map3.keySet()), c.getItems());
    }

    @Test
    public void TestAddItem2() {
        c = new Cart(map1);
        c.addItem(item1);
        c.addItem(item2);
        c.addItem(item3);
        assertTrue(c.getItems().contains(item1));
        assertTrue(c.getItems().contains(item2));
        assertTrue(c.getItems().contains(item3));
    }

    @Test
    public void TestRemoveItem() {
        c = new Cart(map1);
        HashMap<Item, Integer> map4 = new HashMap<>();
        c.addItem(item1);
        c.addItem(item2);
        c.addItem(item3);
        c.addItem(item4);
        c.removeItem(item3);
        map4.put(item1, 1);
        map4.put(item2, 1);
        map4.put(item4, 1);
        assertEquals(new ArrayList<>(map4.keySet()), c.getItems());
    }

    @Test
    public void TestRemoveItem2() {
        c = new Cart(map1);
        c.addItem(item3);
        c.addItem(item4);
        c.addItem(item2);
        c.removeItem(new ArrayList<>(map2.keySet()));
        ArrayList<Item> lst3 = new ArrayList<>();
        lst3.add(item2);
        assertEquals(lst3, c.getItems());
    }

    @Test
    public void TestGetTotalPrice1(){
        c = new Cart(map1);
        c.addItem(item1);
        assertEquals(999999.99, c.getTotalPrice());
    }

    @Test
    public void TestGetTotalPrice2(){
        c = new Cart(map1);
        c.addItem(item5, 3);
        assertEquals(231, c.getTotalPrice());
    }
}