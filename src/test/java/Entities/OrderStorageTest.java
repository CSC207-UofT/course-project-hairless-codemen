package src.test.java.Entities;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import src.main.java.Entities.*;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class OrderStorageTest {
    Item item1, item2, item3, item4;
    User u1, u2;
    ArrayList<Item> lst1 = new ArrayList<>();
    ArrayList<Item> lst2 = new ArrayList<>();
    ArrayList<Order> lst3 = new ArrayList<>();
    Order o1, o2;

    @BeforeEach
    void setup() {
        u1 = new User("A", "1234");
        u2 = new User("B", "2345");
        item1 = new Item("Cat", u1, 999999.99, "Pets");
        item2 = new Item("Airpods3", u2, 199.99, "Technology");
        item3 = new Item("iPhone14", u2, 2000.00, "Technology");
        item4 = new Item("Airpods3", u1, 179.99, "Technology");
        lst1.add(item1);
        lst1.add(item2);
        lst2.add(item3);
        lst2.add(item4);
        o1 = new Order(1, lst1, u1, u2, 100);
        o2 = new Order(2, lst2, u1, u2, 200);
        lst3.add(o1);
        lst3.add(o2);
    }

    @Test
    public void TestAddElement(){
        OrderStorage.addElement(lst3);
        assertEquals(o1, OrderStorage.getOrders().get(1));
        assertEquals(o2, OrderStorage.getOrders().get(2));
    }

    @Test
    public void TestAddElementSingle(){
        OrderStorage.addElement(o1);
        assertEquals(o1, OrderStorage.getOrders().get(1));
    }

    @Test
    public void TestDeleteElement(){
        OrderStorage.addElement(lst3);
        OrderStorage.deleteElement(o2);
        assertEquals(o1, OrderStorage.getOrders().get(1));
        assertNull(OrderStorage.getOrders().get(2));
    }
}
