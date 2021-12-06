package src.test.java.Use_cases;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import src.main.java.Entities.*;
import src.main.java.Use_cases.CartManager;
import src.main.java.Use_cases.OrderManager;

import java.io.IOException;
import java.util.ArrayList;

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
    }

//    @Test
//    public void TestGetPrice(){
//        assertEquals(999999.99, CartManager.getPrice(item1));
//        assertEquals(2000.00, CartManager.getPrice(item3));
//    }

    @Test
    public void TestRemoveItems(){
        CartManager.remove_items(u1, lst2);
        assertTrue(u1.getCart().getItems().contains(item2));
        assertTrue(u1.getCart().getItems().contains(item3));
        assertFalse(u1.getCart().getItems().contains(item1));
        assertFalse(u1.getCart().getItems().contains(item4));
    }

    @Test
    public void TestPrintItems(){
        assertEquals(item1.toString() + item2.toString() + item3.toString() + item4.toString(),
                CartManager.print_items(u1.getCart()));
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
}

