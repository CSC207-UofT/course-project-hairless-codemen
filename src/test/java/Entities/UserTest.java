package src.test.java.Entities;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import src.main.java.Entities.User;

public class UserTest {
    User a;

    @BeforeEach
    void setup(){
        a=new User("Crystal", -1, "Qx951225");
    }

    @Test
    public void TestUsername(){assertEquals("Crystal",a.getName());}

    @Test
    public void TestUserId(){assertEquals(-1, a.getId());}

    @Test
    public void TestUserPassword(){assertEquals("Qx951225", a.getPassword());}

    @Test
    public void TestChangename(){
        a.changeName("Howard");
        assertEquals("Howard", a.getName());
    }

    @Test
    public void TestSetPassword(){
        a.setPassword("951225Qx");
        assertEquals("951225Qx", a.getPassword());
    }

}
