package src.main.java.Entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class OrderStorage implements Storable, Serializable {
    private static final Map<Integer, Order> orderList = new HashMap<>();

    public static void addElement(ArrayList<Object> orders){
        for (Object order : orders){
            addElement(order);
        }
    }

    public static void addElement(Map<Integer, Order> m){
        for (Order o: m.values()){
            addElement(o);
        }
    }

    public static Map<Integer, Order> getItems() {return OrderStorage.orderList;}

    int getTotalNumber() {
        return 0;
    }

    public static void addElement(Object object) {
        orderList.put(((Order) object).getOrder_id(), (Order) object);
    }

    public static void deleteElement(Object object) {orderList.remove(((Order) object).getOrder_id());
    }

    public static int get_size(){
        return orderList.size();
    }
}
