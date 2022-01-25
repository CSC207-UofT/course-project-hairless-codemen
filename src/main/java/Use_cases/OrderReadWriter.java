package src.main.java.Use_cases;

import src.main.java.Entities.*;

import java.io.*;
import java.util.ArrayList;
import java.util.Map;

public class OrderReadWriter implements Serializable{
    /**
     * Saves a hashmap of orders into OrderData.ser file.
     * @param orders - the hashmap of orders that will be saved into file.
     * @throws IOException - if output operations are interrupted by some error.
     */
    public static void saveIntoFile(Map<Integer, Order> orders) throws IOException {
        FileOutputStream fos = new FileOutputStream("OrderData.ser");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(orders);
        oos.close();
        fos.close();
        System.out.println("Orders serialization success");
    }

    /**
     * Read and add all items stored in OrderData.ser to OrderStorage
     * @throws IOException - if input operations are interrupted by some error.
     * @throws ClassNotFoundException - if the object read from ItemData is not a hashmap with keys being Integers and
     * values Orders
     */
    public static void readFromFile() throws IOException, ClassNotFoundException {
        InputStream fis = new FileInputStream("OrderData.ser");
        ObjectInput input = new ObjectInputStream(fis);
        Map<Integer, Order> m = (Map<Integer, Order>) input.readObject();
        OrderStorage.addElement(m);
        input.close();
        fis.close();
        System.out.println("Order read success");
    }

}

