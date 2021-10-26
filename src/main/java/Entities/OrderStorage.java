package src.main.java.Entities;

import java.util.ArrayList;
import java.util.Arrays;

public class OrderStorage implements Storable{
    private static final ArrayList<Order> orderList = new ArrayList<Order>();

    public static void addElement(Order[] orders){
        orderList.addAll(Arrays.asList(orders));
    }

    public static ArrayList<Order> getItems() {return OrderStorage.orderList;}

    int getTotalNumber() {
        return 0;
    }

    public static void addElement(Object object) {
        orderList.add((Order) object);
    }

    public static void deleteElement(Object object) {orderList.remove((Order) object);
    }
}
