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
    ArrayList<Item> lst = new ArrayList<>();

//    @BeforeEach
//    void setup() {
//        c = new Cart(lst);
//        buyer = new User("happybuy", "1234", 9999.99);
//        seller = new User("happysell", "2345");
//        item1 = new Item("Banana", seller, 40, "Fruit");
//        item2 = new Item("Apple", seller, 60, "Fruit");
//        ArrayList<Item> items = ItemStorage.getItem();
//        ItemStorage.deleteElement(items);
//    }

//    @Test
//    public void TestBuy(){
//        lst.add(item1);
//        lst.add(item2);
//        buyer.getCart().addItem(item1);
//        buyer.getCart().addItem(item2);
//        Assertions.assertTrue(Transaction.buy_item(lst, buyer));
//        assertEquals(buyer.getWallet().getMoney(), 9899.99);
//        assertEquals(seller.getWallet().getMoney(), 100);
//    }

    @Test
    public void TestSell(){
        lst.add(item1);
        lst.add(item2);
        Transaction.sell(lst);
        assertEquals(ItemManager.getItemsList().size(), 2);
    }

    @Test
    public void TestSell2(){
        System.out.println(ItemManager.getItemsList());
        Transaction.sell(item1);
        assertEquals(ItemManager.getItemsList().size(), 1);
    }
}
