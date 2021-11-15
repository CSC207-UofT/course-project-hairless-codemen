package src.test.java.Controller;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import src.main.java.Controller.InfoFacade;
import src.main.java.Entities.*;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class InfoFacadeTest {
    Item item1, item2, item3, item4;
    User u1, u2;
    Order o1, o2, o3;
    ArrayList<Item> lst1 = new ArrayList<>();
    ArrayList<Item> lst2 = new ArrayList<>();
    ArrayList<Order> lst3 = new ArrayList<>();

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
        u2.getCart().addItem(item1);
        u1.getCart().addItem(item2);
        u1.getCart().addItem(item3);
        u2.getCart().addItem(item4);
        o1 = new Order(1, lst1, u1, u2, 100);
        o2 = new Order(2, lst1, u1, u2, 200);
        o3 = new Order(3, lst2, u2, u1, 300);
        lst3.add(o1);
        lst3.add(o2);
    }

    @Test
    public void TestPrintItem(){
        assertEquals(InfoFacade.printItem(item1), item1.toString());
        assertEquals(InfoFacade.printItem(item2), item2.toString());
    }

    @Test
    public void TestPrintOrders(){
        assertEquals(InfoFacade.printOrders(lst3), o1.toString() + "\n" +o2.toString() + "\n");
    }

    @Test
    public void TestPrintOrder(){
        assertEquals(InfoFacade.printOrder(o3), o3.toString());
        assertEquals(InfoFacade.printOrder(o2), o2.toString());
    }

    @Test
    public void TestPrintOrders2(){
        OrderStorage.addElement(o1);
        OrderStorage.addElement(o2);
        assertEquals(InfoFacade.printOrders(u1), o1.toString() + "\n" + o2.toString() + "\n");
    }

    @Test
    public void TestPrintItems(){
        String sb = item2.toString() +
                "\n" + item3.toString() + "\n";
        assertEquals(InfoFacade.printItems(lst1), sb);
    }

    @Test
    public void TestGetCartItems(){
        assertEquals(InfoFacade.getCartItems(u1.getCart()), lst1);
        assertEquals(InfoFacade.getCartItems(u2.getCart()), lst2);
    }

    @Test
    public void TestPrintCartItems(){
        assertEquals(InfoFacade.printCartItems(u1.getCart()), item2.toString() + item3.toString());
    }

    @Test
    public void TestAddCartElement(){
        InfoFacade.addCartElement(u1.getCart(), item1);
        assertEquals(InfoFacade.printCartItems(u1.getCart()), item2.toString() + item3.toString() +
                item1.toString());
    }

    @Test
    public void TestRemoveCartElement(){
        InfoFacade.removeCartElement(u1.getCart(), item2);
        assertEquals(InfoFacade.printCartItems(u1.getCart()), item3.toString());
    }

    @Test
    public void getItems(){
        ItemStorage.addElement(lst1);
        assertEquals(InfoFacade.getItems(), lst1);
    }
}
