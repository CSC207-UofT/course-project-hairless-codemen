package src.test.java.Use_cases;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import src.main.java.Entities.*;
import src.main.java.Use_cases.CartManager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CartManagerTest {
    Item item1, item2, item3, item4;
    User u1, u2;
    ArrayList<Item> lst1 = new ArrayList<>();
    ArrayList<Item> lst2 = new ArrayList<>();

    @BeforeEach
    void setup() {
        u1 = new User("A", "1234");
        u2 = new User("B", "2345");
        item1 = new Item("Cat", u1, 999999.99, "Pets");
        item2 = new Item("Airpods3", u2, 199.99, "Technology");
        item3 = new Item("iPhone14", u2, 2000.00, "Technology");
        item4 = new Item("Airpods3", u1, 179.99, "Technology");
        lst1.add(item2);
        lst1.add(item3);
        lst2.add(item1);
        lst2.add(item4);
        u1.getCart().addItem(item1);
        u1.getCart().addItem(item2);
        u1.getCart().addItem(item3);
        u1.getCart().addItem(item4);
        u2.getCart().addItem(item1);
    }

    @Test
    public void TestRemoveItems(){
        CartManager.removeItems(u1, lst2);
        assertTrue(u1.getCart().getItems().contains(item2));
        assertTrue(u1.getCart().getItems().contains(item3));
        assertFalse(u1.getCart().getItems().contains(item1));
        assertFalse(u1.getCart().getItems().contains(item4));
    }

    @Test
    public void TestPrintItems(){
        Cart c = u1.getCart();
        String s = c.toString();
        assertEquals(item1.toString2() +", Quantity: "+item1.getQuantity(),
                CartManager.printItems(u2.getCart()));
    }

    @Test
    public void TestPrintItem(){
        assertEquals(item1.toString2() +", Quantity: "+item1.getQuantity(),
                CartManager.printItem(u1.getCart(),item1));
    }

    @Test
    public void TestGetItems(){
        ArrayList<Item> item = CartManager.getItems(u1.getCart());
        assertTrue(item.contains(item1));
        assertTrue(item.contains(item2));
        assertTrue(item.contains(item3));
        assertTrue(item.contains(item4));
    }

    @Test
    public void TestAddElement(){
        CartManager.AddElement(u2.getCart(), item1);
        ArrayList<Item> item = u2.getCart().getItems();
        assertEquals(item.size(), 1);
        assertTrue(item.contains(item1));
    }

    @Test
    public void TestRemoveElement(){
        CartManager.removeElement(u1.getCart(), item4);
        ArrayList<Item> item = u1.getCart().getItems();
        assertTrue(item.contains(item1));
        assertTrue(item.contains(item2));
        assertTrue(item.contains(item3));
        assertFalse(item.contains(item4));
    }

    @Test
    public void TestGetTotalPrice(){
        assertEquals(item1.getItemPrice()+item2.getItemPrice()+item3.getItemPrice()+item4.getItemPrice(),
                CartManager.getTotalPrice(u1.getCart()));
    }

    @Test
    public void TestGetCartItems(){
        Map<Item,Integer> map = new HashMap<>();
        map.put(item1, item1.getQuantity());
        map.put(item2, item2.getQuantity());
        map.put(item3, item3.getQuantity());
        map.put(item4, item4.getQuantity());
        assertEquals(map, CartManager.getCartItems(u1.getCart()));
    }
}

