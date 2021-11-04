package src.main.java.Controller;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import src.main.java.Entities.Item;
import src.main.java.Entities.Cart;
import src.main.java.Entities.User;

import java.util.ArrayList;
import src.main.java.Entities.Item;
import src.main.java.Entities.Order;
import src.main.java.Entities.OrderStorage;
import src.main.java.Entities.User;
import src.main.java.Use_cases.ItemManager;
import src.main.java.Use_cases.CartManager;
import src.main.java.Use_cases.OrderManager;
import src.main.java.Use_cases.UserManager;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

class TransactionTest {
    Cart c;
    Item item1, item2;
    User buyman;
    User sellman;
    ArrayList<Item> lst = new ArrayList<>();

    @BeforeEach
    void setup() {
        c = new Cart(lst);
        buyman = new User("happybuy", "1234", 9999.99);
        sellman = new User("happysell", "2345");
        item1 = new Item("Banana", sellman, 40, "Fruit");
        item2 = new Item("Apple", sellman, 60, "Fruit");
    }

    @Test
    public void TestTransaction() throws IOException {
        lst.add(item1);
        lst.add(item2);
        buyman.getCart().addItem(item1);
        buyman.getCart().addItem(item2);
        assertTrue(Transaction.buy_item(lst, buyman, sellman));
        assertEquals(buyman.getWallet().getMoney(), 9899.99);
        assertEquals(sellman.getWallet().getMoney(), 100);
    }

}
