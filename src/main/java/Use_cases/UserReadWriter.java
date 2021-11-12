package src.main.java.Use_cases;

import src.main.java.Entities.User;
import src.main.java.Entities.UserStorage;

import java.io.*;
import java.util.Map;

public class UserReadWriter implements Serializable {

    /**
     * Saves a hashmap of users into UserData.ser file.
     * @param users - the hashmap of users that will be saved into file.
     * @throws IOException - if output operations are interrupted by some error.
     */
    public static void SaveIntoFile(Map<String, User> users) throws IOException {
        FileOutputStream fos = new FileOutputStream("UserData.ser");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(users);
        oos.close();
        fos.close();
        System.out.println("User serialization success");
    }

    /**
     * Read and add all users stored in UserData.ser to OrderStorage
     * @throws IOException - if input operations are interrupted by some error.
     * @throws ClassNotFoundException - if the object read from ItemData is not a hashmap with keys being Integers and
     * values Orders
     */
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
