package src.main.java.Entities;

import java.io.Serializable;
import java.util.*;

public class OrderStorage implements Storable, Serializable, Iterable<Order> {
    private static final Map<Integer, Order> orderList = new HashMap<>();

    /**
     * Add a list of orders to order storage.
     * @param orders - the list of orders to be added to order storage.
     */
    public static void addElement(ArrayList<Object> orders){
        for (Object order : orders){
            addElement(order);
        }
    }

    /**
     * Add a hashmap of orders to order storage
     * @param m - the hashmap of order to be added to order storage (keys in this hashmap represents order ids, and
     * there should be only one order associated with each key, since each order's order id number is unique.
     */
    public static void addElement(Map<Integer, Order> m){
        for (Order o: m.values()){
            addElement(o);
        }
    }

    /**
     * Get the orders stored in order storage in its original hashmap form.
     * @return the order hashmap stored in order storage.
     */
    public static Map<Integer, Order> getOrders() {return OrderStorage.orderList;}

    /**
     * Add an order to order storage.
     * @param object - order to be added to order storage
     */
    public static void addElement(Object object) {
        orderList.put(((Order) object).getOrder_id(), (Order) object);
    }

    /**
     * Delete an order from order storage.
     * @param object - order to be deleted from order storage
     */
    public static void deleteElement(Object object) {orderList.remove(((Order) object).getOrder_id());
    }

    /**
     * Get the total number of orders stored in order storage.
     * @return the total number of orders stored in order storage.
     */
    public static int get_size(){
        return orderList.size();
    }

    /**
     * Get the the orderList from one owner stored in order storage.
     * @return the orderList from one owner
     */
    public static ArrayList<Order> getOwnerOrder(User owner){
        ArrayList<Order> lst = new ArrayList<>();
        for (Order o: orderList.values()) {
            if (owner.getName().equals(o.getOwner().getName())){
                lst.add(o);
            }
        }
        return lst;
    }


    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<Order> iterator() {
        return new OrderIterator();
    }

    private static class OrderIterator implements Iterator<Order>{
        private int current = 0;
        /**
         * Returns {@code true} if the iteration has more elements.
         * (In other words, returns {@code true} if {@link #next} would
         * return an element rather than throwing an exception.)
         *
         * @return {@code true} if the iteration has more elements
         */
        @Override
        public boolean hasNext() {
            return current < orderList.size();
        }

        /**
         * Returns the next element in the iteration.
         *
         * @return the next element in the iteration
         * @throws NoSuchElementException if the iteration has no more elements
         */
        @Override
        public Order next() {
            Order o;
            try{
                ArrayList<Order> orders = new ArrayList<>(orderList.values());
                o = orders.get(current);
            }catch (IndexOutOfBoundsException e){
                throw new NoSuchElementException();
            }
            current += 1;
            return o;
        }
    }
}
