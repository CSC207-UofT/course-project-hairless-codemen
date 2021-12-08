package src.test.java.Entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import src.main.java.Entities.Item;
import src.main.java.Entities.User;

public class ItemTest {
    Item a, c;
    User b;
    @BeforeEach
    void setup() {
        b = new User("Jenny", "1234", 100);
        a = new Item("Apple", b, 20.0, "Fruit");
        c = new Item("Snow", b, 20.0, 100,"Beautiful");}

    @Test
    public void TestItemPrice(){assertEquals(20, a.getItemPrice());}

    @Test
    public void TestGetOwner(){assertEquals(b, a.getOwner());}

    @Test
    public void TestCategory(){
        String ca = a.getCategory();
        assertEquals("Fruit", ca);}

    @Test
    public void TestName(){assertEquals("Apple", a.getItemName());}

    @Test
    public void TestUser(){assertEquals(b, a.getOwner());}

    @Test
    public void TestQuantity(){assertEquals(1, a.getQuantity());}

    @Test
    public void TestAddQuantity(){
        a.addQuantity(1);
        assertEquals(2, a.getQuantity());
    }

    @Test
    public void TestSubtractQuantity(){
        a.subtractQuantity(1);
        assertEquals(0, a.getQuantity());
    }

    @Test
    public void TestString(){
        String s = "Snow: Category: Beautiful, Quantity: 100, Price: $20.0";
        assertEquals(s, c.toString());
    }

    @Test
    public void TestString2(){
        String s = "Apple: Category: Fruit, Price: $20.0";
        assertEquals(s, a.toString2());
    }
}
