package src.test.java.Entities;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import src.main.java.Entities.Wallet;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WalletTest {
    Wallet w;
    @BeforeEach
    void setup() {
        w = new Wallet(1000);
    }

    @Test
    public void TestMoney(){
        assertEquals(1000, w.getMoney());
    }

    @Test
    public void TestLoadMoney(){
        w.loadMoney(99);
        assertEquals(1099, w.getMoney());
    }

    @Test
    public void TestSubtractMoney(){
        w.subtractMoney(100);
        assertEquals(900, w.getMoney());
    }

}
