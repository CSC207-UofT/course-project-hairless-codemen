package src.test.java.Controller;

import org.junit.jupiter.api.Test;
import src.main.java.Controller.Finder;

import org.junit.jupiter.api.BeforeEach;
import src.main.java.Entities.*;

import java.util.*;

import src.main.java.Use_cases.OrderManager;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class FinderTest {

    Item item1, item2;
    Order order;
    User buyer;
    User seller;
    ArrayList<Item> lst = new ArrayList<>();
    ArrayList<Item> empty = new ArrayList<>();
    Map<Integer, Order> storages = new HashMap<>();


    @BeforeEach
    void setup() {
        buyer = new User("happybuy", "1234", 9999.99);
        seller = new User("happysell", "2345");
        item1 = new Item("Banana", seller, 40, "Fruit");
        item2 = new Item("Apple", seller, 60, "Fruit");
        order = new Order(123, lst, buyer, seller, 100);
        lst.add(item2);
        lst.add(item1);
        storages.put(123, order);
        OrderStorage.addElement(storages);
        ItemStorage.addElement(lst);
    }

    @Test
    public void TestFinderOrder1() throws IOException, ClassNotFoundException{

        assertNull(Finder.find(601));
    }

    @Test
    public void TestFinderOrder2() throws IOException, ClassNotFoundException{

        assertTrue(OrderManager.has_order(123));
        assertEquals(Finder.find(123), order);

    }

    @Test
    public void TestFinderName1() throws IOException, ClassNotFoundException{


        assertEquals(Finder.find("Orange", Finder.Find_By.NAME), empty);
    }

    @Test
    public void TestFinderName2() throws IOException, ClassNotFoundException{

        ArrayList<Item> lst_1 = new ArrayList<>();
        lst_1.add(item2);
        assertEquals(Finder.find("Apple", Finder.Find_By.NAME), lst_1);
    }

    @Test
    public void TestFinderOwner1() throws IOException, ClassNotFoundException{

        assertEquals(Finder.find("owner", Finder.Find_By.OWNER), empty);

    }

    @Test
    public void TestFinderOwner2() throws IOException, ClassNotFoundException{

        assertEquals(Finder.find("happysell", Finder.Find_By.OWNER), lst);
    }

    @Test
    public void TestFinderCategory1() throws IOException, ClassNotFoundException{
        assertEquals(Finder.find("Dessert", Finder.Find_By.CATEGORY), empty);
    }

    @Test
    public void TestFinderCategory2() throws IOException, ClassNotFoundException{

        assertEquals(Finder.find("Fruit", Finder.Find_By.CATEGORY), lst);
    }


}
