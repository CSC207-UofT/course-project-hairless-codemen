package src.test.java.Use_cases;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import src.main.java.Entities.Item;
import src.main.java.Entities.ItemStorage;
import src.main.java.Entities.User;
import src.main.java.Entities.UserStorage;
import src.main.java.Use_cases.ItemManager;
import src.main.java.Use_cases.UserManager;

import java.util.ArrayList;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class UserManagerTest {
    User u1, u2, u3, u4, u5, u6;
    @BeforeEach
    void setup() {
        u1 = new User("A", "1234", 100);
        u2 = new User("B", "2345", 50);
        u3 = new User("C", "3456");
        u4 = new User("X", "1111");
        u5 = new User("HX", "3333");
        u6 = new User("AAA", "!!!");
        UserStorage.addElement(u1);
        UserStorage.addElement(u2);
        UserStorage.addElement(u3);
    }

    @Test
    public void TestCreateUser(){
        assertTrue(UserManager.createUser("D", "6789"));
        assertFalse(UserManager.createUser("D", "123"));
        assertFalse(UserManager.createUser("A", "111"));
    }

    @Test
    public void TestGetUserInfo(){
        Object[] lst = UserManager.getUserInfo("A");
        assertEquals(lst[0], u1);
        assertEquals(lst[1], u1.getCart());
        assertEquals(lst[2], 100.0);
    }

    @Test
    public void TestLogin(){
        assertTrue(UserManager.login("A", "1234"));
        assertTrue(UserManager.login("B", "2345"));
        assertFalse(UserManager.login("E", "1111"));
        assertFalse(UserManager.login("C", "3455"));
    }

    @Test
    public void TestGetUserList(){
        Map<String, User> m = UserManager.getUserList();
        assertEquals(m.get("A"), u1);
        assertEquals(m.get("B"), u2);
        assertEquals(m.get("C"), u3);
        assertNull(m.get("F"));
    }

    @Test
    public void TestSearch(){
        assertEquals(UserManager.search("A"), u1);
        assertEquals(UserManager.search("B"), u2);
        assertEquals(UserManager.search("C"), u3);
        assertThrows(NullPointerException.class, (Executable) UserManager.search("D"));
    }

    @Test
    public void TestGetMoney(){
        assertEquals(UserManager.getMoney(u1), 100.0);
        assertEquals(UserManager.getMoney(u2), 50.0);
        assertEquals(UserManager.getMoney(u3), 0.0);
    }

    @Test
    public void TestSubtractMoney(){
        UserManager.subtractMoney(u1, 30);
        assertEquals(UserManager.getMoney(u1), 70.0);
        UserManager.subtractMoney(u2, 10);
        assertEquals(UserManager.getMoney(u2), 40.0);
    }

    @Test
    public void TestLoadMoney(){
        UserManager.loadMoney(u3, 40);
        assertEquals(UserManager.getMoney(u3), 40.0);
        UserManager.loadMoney(u1, 20);
        assertEquals(UserManager.getMoney(u1), 120.0);
    }

    @Test
    public void TestAddElement(){
        Object[] lst = new Object[]{u4, u5};
        UserManager.addElement(lst);
        assertEquals(UserManager.getUserList().get("X"), u4);
        assertEquals(UserManager.getUserList().get("HX"), u5);
    }

    @Test
    public void TestAddElement2(){
        UserManager.addElement(u6);
        assertEquals(UserManager.getUserList().get("AAA"), u6);
    }

}
