package src.test.java.Use_cases;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import src.main.java.Entities.*;
import src.main.java.Use_cases.OrderManager;

import java.util.ArrayList;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class OrderManagerTest {
    Item item1, item2, item3, item4;
    User u1, u2;
    ArrayList<Item> lst1 = new ArrayList<>();
    ArrayList<Item> lst2 = new ArrayList<>();
    ArrayList<Order> lst3 = new ArrayList<>();
    Order o1, o2, o3;
    Order[] orders;

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
        o1 = new Order(1, lst1, u1, u2, 100);
        o2 = new Order(2, lst1, u1, u2, 200);
        o3 = new Order(3, lst2, u2, u1, 300);
        lst3.add(o1);
        lst3.add(o2);
        orders = new Order[]{o1, o3};
    }

    @Test
    public void TestSearch(){
        OrderManager.addElement(lst3);
        assertEquals(o1, OrderManager.search(1));
        assertEquals(o2, OrderManager.search(2));
    }

    @Test
    public void TestAddElement(){
        OrderManager.addElement(o3);
        assertEquals(1, OrderStorage.get_size());
        OrderManager.addElement(lst3);
        assertTrue(OrderStorage.getOrders().containsValue(o1));
        assertTrue(OrderStorage.getOrders().containsValue(o2));
        assertTrue(OrderStorage.getOrders().containsValue(o3));
        assertEquals(3, OrderStorage.get_size());
    }

    @Test
    public void TestGetOrders(){
        OrderManager.addElement(lst3);
        OrderManager.addElement(o3);
        assertTrue(OrderManager.getOrders(u1).contains(o1));
        assertTrue(OrderManager.getOrders(u1).contains(o2));
        assertFalse(OrderManager.getOrders(u1).contains(o3));
        assertTrue(OrderManager.getOrders(u2).contains(o3));
    }

    @Test
    public void TestCreateOrder(){
        Order o = OrderManager.createOrder(lst1, u1, u2);
        assertTrue(OrderStorage.getOrders().containsValue(o));
    }

    @Test
    public void TestPrintOrders(){
        String s = OrderManager.printOrders(lst3);
        assertEquals(o1.toString()+ "\n" + o2.toString() + "\n", s);
    }

    @Test
    public void TestGetItems(){
        OrderManager.addElement(lst3);
        Map<Integer,Order> m = OrderManager.getItems();
        assertEquals(m.get(1), o1);
        assertEquals(m.get(2), o2);
        assertNull(m.get(3));
    }

    @Test
    public void TestPrintOrder(){
        assertEquals(OrderManager.printOrder(o1), o1.toString());
    }

    @Test
    public void TestPrintOrder2(){
        OrderManager.addElement(lst3);
        assertEquals(OrderManager.printOrders(u1), o1.toString() + "\n" + o2.toString() + "\n");
    }
}

