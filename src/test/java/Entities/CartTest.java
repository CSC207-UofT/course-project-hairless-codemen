package src.test.java.Entities;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import src.main.java.Entities.Item;
import src.main.java.Entities.Cart;
import src.main.java.Entities.User;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CartTest {
    Cart c;
    Item item1, item2, item3, item4;
    User u;
    ArrayList<Item> lst = new ArrayList<>();
    ArrayList<Item> lst2 = new ArrayList<>();
    Item[] items;
//    @BeforeEach
//    void setup() {
//        c = new Cart(lst);
//        u = new User("JoJo", "1234", 9999.99);
//        item1 = new Item("Hina", u, 999999.99, "Pets");
//        item2 = new Item("X", u, 111, "Mysterious");
//        item3 = new Item("iPhone14", u, 2000.00, "Technology");
//        item4 = new Item("Airpods3", u, 179.99, "Technology");
//        items = new Item[]{item1, item2};
//        lst2.add(item3);
//        lst2.add(item4);
//    }

    @Test
    public void TestAddItem(){
        c.addItem(item1);
        ArrayList<Item> lst1 = new ArrayList<>();
        lst1.add(item1);
        assertEquals(lst1, c.getItems());
    }

//    @Test
//    public void TestAddItem2(){
//        c = new Cart(lst);
//        c.addItem(items);
//        assertTrue(c.getItems().contains(item1));
//        assertTrue(c.getItems().contains(item2));
//    }

//    @Test
//    public void TestRemoveItem(){
//        c = new Cart(lst);
//        c.addItem(item3);
//        c.addItem(item4);
//        c.removeItem(item3);
//        ArrayList<Item> lst3 = new ArrayList<>();
//        lst3.add(item4);
//        assertEquals(lst3, c.getItems());
//    }

//    @Test
//    public void TestRemoveItem2(){
//        c = new Cart(lst);
//        c.addItem(item3);
//        c.addItem(item4);
//        c.addItem(item2);
//        c.removeItem(lst2);
//        ArrayList<Item> lst3 = new ArrayList<>();
//        lst3.add(item2);
//        assertEquals(lst3, c.getItems());
//    }
//
//    @Test
//    public void TestCartIterator(){
//        c = new Cart(lst);
//        c.addItem(item3);
//        c.addItem(item4);
//        c.addItem(item2);
//        Item[] items = new Item[]{item3, item4, item2};
//        int i = 0;
//        for (Item item: c){
//            assertEquals(item, items[i]);
//            i++;
//        }
//        assertEquals(3, i);
//    }
}
