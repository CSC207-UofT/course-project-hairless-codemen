package src.test.java.Entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import src.main.java.Entities.Item;
import src.main.java.Entities.User;

public class ItemTest {
    Item a;
    User b;
    @BeforeEach
    void setup() {
        b = new User("Jenny", 2, "1234", 100);
        a = new Item("Apple", b, 20.0, "Fruit", id);}

    @Test
    public void TestItemPrice(){assertEquals(20, a.getItemPrice());}

    @Test
    public void TestCategory(){assertEquals("Fruit", a.getCategory());}

    @Test
    public void TestName(){assertEquals("Apple", a.getItemName());}

    @Test
    public void TestUser(){assertEquals(b, a.getOwner());}

    @Test
    public void TestQuantity(){assertEquals(1, a.getQuantity());}


   @Test
   public void TestChangeItemName(){
        a.changeItemName("apple");
        assertEquals("apple", a.getItemName());
    }


    @Test
    public void TestChangeItemPrice(){
        a.changeItemPrice(30);
        assertEquals(30, a.getItemPrice());
    }

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
}
