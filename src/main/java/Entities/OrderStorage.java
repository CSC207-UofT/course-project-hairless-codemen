package src.main.java.Entities;

import java.io.Serializable;
import java.util.*;

public class OrderStorage implements Storable, Serializable, Iterable<Order> {
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

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<Order> iterator() {
        return new OrderIterator();
    }

    private class OrderIterator implements Iterator<Order>{
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
