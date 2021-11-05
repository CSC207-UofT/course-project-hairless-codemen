package src.main.java.Use_cases;

import src.main.java.Entities.Item;
import src.main.java.Entities.Order;
import src.main.java.Entities.OrderStorage;
import src.main.java.Entities.User;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

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

    public static int total_number_order(){
        return OrderStorage.get_size();
    }

    public static ArrayList<Order> getOrders(User u){
        ArrayList<Order> o1 = new ArrayList<>(OrderStorage.getItems().values());
        ArrayList<Order> o2 = new ArrayList<>();
        for (Order o: o1){
            if (o.getOwner().getName().equals(u.getName())){
                o2.add(o);
            }
        }
        return o2;
    }


    public static Order create_order(ArrayList<Item> items_list, User buyer, User seller){
        int total_price = 0;
        for (Item items: items_list){
            total_price += items.getItemPrice();
        }
        return new Order(OrderStorage.get_size()+1,items_list, buyer, seller, total_price);
    }

    public static void removeElement(Object[] elements){}

    public static void removeElement(Object element){}

    public static void printOrders(ArrayList<Order> orders){
        for (Order o: orders){
            System.out.println(o);
        }
    }
}
