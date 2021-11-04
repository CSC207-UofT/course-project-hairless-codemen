package src.test.java.Entities;

import org.junit.jupiter.api.Test;
import src.main.java.Entities.User;
import src.main.java.Entities.UserStorage;
import src.main.java.Use_cases.UserReadWriter;

import java.io.IOException;

public class UserReadWriterTest {

    @Test
    public void TestSave() throws IOException {
        User u1 = new User("A", 2, "1234");
        User u2 = new User ("B", 3, "2345");
        User u3 = new User("C", 4, "6666");
        UserStorage.addElement(u1);
        UserStorage.addElement(u2);
        UserStorage.addElement(u3);
        UserReadWriter.SaveIntoFile(UserStorage.getUserList());
        System.out.println(UserStorage.getUserList());
    }

    @Test
    public void TestRead() throws IOException, ClassNotFoundException {
        UserReadWriter.readFromFile();
        System.out.println(UserStorage.getUserList());
        }

    }


