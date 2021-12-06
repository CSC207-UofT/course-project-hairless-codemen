package src.test.java.Controller;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import src.main.java.Controller.Transaction;
import src.main.java.Entities.Item;
import src.main.java.Entities.Cart;
import src.main.java.Entities.ItemStorage;
import src.main.java.Entities.User;
import src.main.java.Use_cases.ItemManager;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class TransactionTest {
    Cart c;
    Item item1, item2;
    User buyer;
    User seller;

    @BeforeEach
    void setup() {
        c = new Cart();
        buyer = new User("happybuy", "1234", 9999.99);
        seller = new User("happysell", "2345");
        item1 = new Item("Banana", seller, 40,4,"Fruit");
        item2 = new Item("Apple", seller, 60, 7,"Fruit");
    }

    @Test
    public void TestBuy(){
        c.addItem(item1, 2);
        c.addItem(item2, 3);
        Assertions.assertTrue(Transaction.buyItem(buyer));
        assertEquals(buyer.getWallet().getMoney(), 9739.99);
        assertEquals(seller.getWallet().getMoney(), 260);
    }

    @Test
    public void TestSell(){
        Transaction.sell(c.getItems());
        assertEquals(ItemManager.getItemsList().size(), 2);
    }

    @Test
    public void TestSell2(){
        System.out.println(ItemManager.getItemsList());
        Transaction.sell(item1);
        assertEquals(ItemManager.getItemsList().size(), 1);
    }
}
