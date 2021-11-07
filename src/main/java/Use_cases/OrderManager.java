package src.main.java.Use_cases;

import src.main.java.Entities.Item;
import src.main.java.Entities.Order;
import src.main.java.Entities.OrderStorage;
import src.main.java.Entities.User;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

public class OrderManager implements Manager{
    public static Object search(int order_id) throws NullPointerException{
        return OrderStorage.getItems().get(order_id);
    }

    public static Map<Integer, Order> getItems() {return OrderStorage.getItems();}

    public static void addElement(Object[] elements){
        for (Object element: elements){
            addElement(element);
        }
    }

    public static void addElement(ArrayList<Order> orders){
        for (Order o: orders){
            addElement(o);
        }
    }

    public static void addElement(Object element){
        OrderStorage.addElement(element);
    }

    public static int total_number_order(){
        return OrderStorage.get_size();
    }

    public static ArrayList<Order> getOrders(User u){
        ArrayList<Order> o1 = new ArrayList<>(OrderStorage.getItems().values());
        ArrayList<Order> o2 = new ArrayList<>();
        for (Order o: o1){
            if (o.getBuyer().getName().equals(u.getName())){
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
        Order o = new Order(OrderStorage.get_size()+1,items_list, buyer, seller, total_price);
        addElement(o);
        return o;
    }

    public static void removeElement(Object[] elements){}

    public static void removeElement(Object element){}

    public static String printOrders(ArrayList<Order> orders){
        StringBuilder sb = new StringBuilder();
        for (Order o: orders){
            sb.append(o);
        }
        return sb.toString();
    }
    public static String printOrder(Order o){
        return o.toString();
    }

    public static String printOrders(User u){
        return printOrders(getOrders(u));
    }
}
