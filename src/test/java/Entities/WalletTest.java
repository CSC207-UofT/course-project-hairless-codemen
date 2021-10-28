package src.test.java.Entities;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import src.main.java.Entities.*;
import static org.junit.jupiter.api.Assertions.*;

public class WalletTest {

    @Test
    public void TestWallet(){
        Wallet w1 = new Wallet();
        Wallet w2 = new Wallet(100);
        assertEquals(0.0, w1.getMoney());
        assertEquals(100, w2.getMoney());
    }

    @Test
    public void TestLoadMoney(){
        Wallet w1 = new Wallet();
        Wallet w2 = new Wallet(100);
        w1.loadMoney(3.5);
        w2.loadMoney(10.0);
        assertEquals(3.5, w1.getMoney());
        assertEquals(110.0, w2.getMoney());
    }

    @Test
    public void TestSubtractMoney(){
        Wallet w1 = new Wallet();
        Wallet w2 = new Wallet(100);
        w1.loadMoney(3.5);
        w2.subtractMoney(30.0);
        w1.subtractMoney(2.7);
        assertEquals(0.8, w1.getMoney());
        assertEquals(70, w2.getMoney());
    }
}
