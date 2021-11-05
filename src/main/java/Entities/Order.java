package src.main.java.Entities;

import java.io.Serializable;
import java.util.ArrayList;

public class Order implements Serializable {
    private final int order_id;
    private final ArrayList<Item> items_list;
    private final User buyer;
    private final User owner;
    private final int total;


    public Order(int id, ArrayList<Item> items_list, User buyer, User owner, int total){
        this.order_id = id;
        this.items_list = items_list;
        this.buyer = buyer;
        this.owner = owner;
        this.total = total;
    }

    public int getOrder_id() {
        return order_id;
    }

    @Override
    public String toString() {
        StringBuilder items = new StringBuilder();
        for (Item i : items_list){
            String s = i.toString() + "\n";
            items.append(s);
        }
        return "Order #" + order_id + ": \n" + "Buyer: " + buyer.toString() + "\nSeller: " + owner.toString() +
                "\nContains the following items: \n" + items + "Total: $" + total;
    }

    public User getOwner(){return owner;}

    public User getBuyer(){return buyer;}
}