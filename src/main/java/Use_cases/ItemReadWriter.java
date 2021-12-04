package src.main.java.Use_cases;

import src.main.java.Entities.*;

import java.io.*;
import java.util.ArrayList;
import java.util.Map;

public class ItemReadWriter implements Serializable{

    /**
     * Saves a hashmap of items into ItemData.ser file.
     * @param items - the hashmap of items that will be saved into file.
     * @throws IOException - if output operations are interrupted by some error.
     */
    public static void saveIntoFile(Map<String, ArrayList<Item>> items) throws IOException {
        FileOutputStream fos = new FileOutputStream("ItemData.ser");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(items);
        oos.close();
        fos.close();
        System.out.println("Items serialization success");
    }

    /**
     * Read and add all items stored in ItemData.ser to ItemStorage
     * @throws IOException - if input operations are interrupted by some error.
     * @throws ClassNotFoundException - if the object read from ItemData is not a hashmap with keys being Strings and
     * values ArrayLists.
     */
    public static void readFromFile() throws IOException, ClassNotFoundException {
        InputStream fis = new FileInputStream("ItemData.ser");
        ObjectInput input = new ObjectInputStream(fis);
        Map<String, ArrayList<Item>> m = (Map<String, ArrayList<Item>>) input.readObject();
        ItemStorage.addElement(m);
        input.close();
        fis.close();
        System.out.println("Item read success");
    }
}

