package src.test.java.Entities;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import src.main.java.Entities.*;


import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class UserStorageTest {
    User u1, u2, u3;

    @BeforeEach
    void setUp(){
        u1 = new User("A",  "1234");
        u2 = new User ("B",  "2345");
        u3 = new User("C",  "6666");
    }

    @Test
    public void TestAddElement(){
        UserStorage.addElement(u1);
        UserStorage.addElement(u2);
        assertEquals(u1, UserStorage.getUserList().get("A"));
        assertEquals(u2, UserStorage.getUserList().get("B"));
        assertNull(UserStorage.getUserList().get("C"));
        UserStorage.addElement(u3);
        assertEquals(3, UserStorage.getUserList().size());
    }

    @Test
    public void TestDeleteElement(){
        UserStorage.addElement(u1);
        UserStorage.addElement(u2);
        UserStorage.addElement(u3);
        UserStorage.deleteElement(u1);
        assertNull(UserStorage.getUserList().get("A"));
        assertEquals(u2, UserStorage.getUserList().get("B"));
        UserStorage.deleteElement(u3);
        assertNull(UserStorage.getUserList().get("C"));
        assertEquals(u2, UserStorage.getUserList().get("B"));
    }

    @Test
    public void TestAddElement2(){
        Map<String, User> m = new HashMap<>();
        m.put("A", u1);
        m.put("B", u2);
        m.put("C", u3);
        UserStorage.addElement(m);
        assertEquals(u1, UserStorage.getUserList().get("A"));
        assertEquals(u2, UserStorage.getUserList().get("B"));
        assertEquals(u3, UserStorage.getUserList().get("C"));
    }
}
