package src.test.java.Controller;

import org.junit.jupiter.api.Test;
import src.main.java.Controller.Finder;

import org.junit.jupiter.api.BeforeEach;
import src.main.java.Controller.Login;
import src.main.java.Entities.*;

import java.util.*;

import src.main.java.Use_cases.OrderManager;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class LoginTest {
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
        o1 = new Order(1, lst1, u1, u2, 100);
        o2 = new Order(2, lst1, u1, u2, 200);
        o3 = new Order(3, lst2, u2, u1, 300);
        lst3.add(o1);
        lst3.add(o2);
    }

    @Test
    public void TestSignup(){
        assertTrue(Login.signup("A", "1111"));
        assertFalse(Login.signup("A", "1234"));
        assertTrue(Login.signup("B", "1111"));
    }

    @Test
    public void TestLogin() throws IOException {
        UserStorage.addElement(u1);
        assertTrue(Login.login("A", "1234"));
        assertFalse(Login.login("B", "2333"));
    }
}
