package src.test.java.Entities;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import src.main.java.Entities.*;


import static org.junit.jupiter.api.Assertions.*;

public class UserStorageTest {
    User u1, u2, u3;

    @BeforeEach
    void setUp(){
        u1 = new User("A", 2, "1234");
        u2 = new User ("B", 3, "2345");
        u3 = new User("C", 4, "6666");
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
}
