package src.main.java.Use_cases;

import src.main.java.Entities.Item;
import src.main.java.Entities.Order;
import src.main.java.Entities.OrderStorage;

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Map;

public class OrderManager implements Manager{
    public static Object search(int order_id){return OrderStorage.getItems().get(order_id);}

    public static void addElement(ArrayList<Object> elements) throws IOException {
        for (Object element: elements){
            addElement(element);
        }
    }

    public static void addOrder(Order o) throws IOException {
        //  Add an order to Orders.txt file.
        File f = new File("src/main/java/Files/Orders.txt");
        FileOutputStream fos = new FileOutputStream(f);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(o);
    }

    public static void addElement(Object element) throws IOException {
        OrderStorage.addElement(element);
        addOrder((Order) element);
    }


    public static void rewrite(Map<Integer, Order> orders) throws IOException {
        boolean deleted = new File("src/main/java/Files/Orders.txt").delete();
        if (deleted){
            for (Integer order_id: orders.keySet()){
                addOrder(orders.get(order_id));
            }
        }
    }

    public static void removeElement(Object[] elements) throws IOException {
        for (Object element : elements){
            removeElement(element);
        }
    }

    public static void removeElement(Object element) throws IOException {
        OrderStorage.deleteElement(element);
        Map<Integer, Order> orders = OrderStorage.getItems();
        rewrite(orders);
    }

    public static ArrayList<Order> loadOrders(File f) throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream(f);
        ObjectInputStream ois = new ObjectInputStream(fis);
        ArrayList<Order> orders = new ArrayList<>();

        try {
            for (;;) {
                orders.add((Order) ois.readObject());
            }
        } catch (EOFException e) {
            // End of stream
        }

        return orders;
    }
}
