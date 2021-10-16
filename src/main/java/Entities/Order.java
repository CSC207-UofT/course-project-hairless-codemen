package src.main.java.Entities;

import java.util.ArrayList;

public class Order {
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

    @Override
    public String toString() {
        StringBuilder items = new StringBuilder();
        for (Item i : items_list){
            String s = i.toString() + "\n";
            items.append(s);
        }
        return "Order #" + order_id + ": \n" + "Buyer: " + buyer.toString() + "\n Seller: " + owner.toString() +
                "\n Contains the following items:" + items + "\n Total: " + total;
    }
}