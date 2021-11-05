package src.main.java.Use_cases;

import src.main.java.Entities.User;
import src.main.java.Entities.UserStorage;

import java.io.*;
import java.util.Map;

public class UserReadWriter implements Serializable {

    public static void SaveIntoFile(Map<String, User> users) throws IOException {
        FileOutputStream fos = new FileOutputStream("UserData.ser");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(users);
        oos.close();
        fos.close();
        System.out.println("User serialization success");
    }
    public static void readFromFile() throws IOException, ClassNotFoundException {
        InputStream fis = new FileInputStream("UserData.ser");
        ObjectInput input = new ObjectInputStream(fis);
        Map<String, User> m = (Map<String, User>) input.readObject();
        UserStorage.addElement(m);
        input.close();
        fis.close();
        System.out.println("User read success");
    }


}
