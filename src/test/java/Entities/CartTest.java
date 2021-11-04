package src.test.java.Entities;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import src.main.java.Entities.Item;
import src.main.java.Entities.Cart;
import src.main.java.Entities.User;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CartTest {
    Cart c;
    Item item1;
    User u;
    ArrayList<Item> lst = new ArrayList<>();
    @BeforeEach
    void setup() {
        c = new Cart(lst);
        u = new User("JoJo", 3333, "1234", 9999.99);
        item1 = new Item("Hina", u, 999999.99, "Pets");
    }

    @Test
    public void TestAddItem(){
        c.addItem(item1);
        ArrayList<Item> lst1 = new ArrayList<>();
        lst1.add(item1);
        assertEquals(lst1, c.getItems());
    }


}
