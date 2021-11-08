package src.main.java.Use_cases;

import src.main.java.Entities.*;

import java.io.*;
import java.util.ArrayList;
import java.util.Map;

public class ItemReadWriter implements Serializable{
    public static void saveIntoFile(Map<String, ArrayList<Item>> items) throws IOException {
        FileOutputStream fos = new FileOutputStream("ItemData.ser");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(items);
        oos.close();
        fos.close();
        System.out.println("Items serialization success");
    }

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

