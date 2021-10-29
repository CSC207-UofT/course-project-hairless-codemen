package src.main.java.Use_cases;

import src.main.java.Entities.Item;
import src.main.java.Entities.Order;
import src.main.java.Entities.OrderStorage;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class OrderManager implements Manager{
    public static Object search(int order_id){return OrderStorage.getItems().get(order_id);}

    public static void addElement(Object[] elements) throws IOException {
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

    public static void removeElement(Object[] elements){}

    public static void removeElement(Object element){}
}
