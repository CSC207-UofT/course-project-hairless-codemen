package src.main.java.Entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Cart implements Serializable, Iterable<Item> {
    private final ArrayList<Item> items;

    /**
     * Constructor of Cart that has list of items
     * @param items An Arraylist of items in the cart
     */
    public Cart(ArrayList<Item> items){

        this.items = items;
    }

    /**
     * Constructor of a complete new cart
     */
    public Cart(){

        this.items = new ArrayList<Item>();
    }

    /**
     * get the items in the cart
     * @return a list of items in the cart
     */

    public ArrayList<Item> getItems(){

        return this.items;
    }

    /**
     * add a list of items into cart
     * @param item list of Item will be added into cart
     */
    public void addItem(Item[] item) {

        items.addAll(Arrays.asList(item));
    }


    /**
     * add single item to the cart
     * @param item single item will be added into cart
     */
    public void addItem(Item item){

        items.add(item);
    }

    /**
     *Remove item from
     * @param item
     */
    public void removeItem(ArrayList<Item> item){
        for (Item i : item){
            items.remove(i);
        }
    }

    public void removeItem(Item i){
        items.remove(i);
    }

    @Override
    public Iterator<Item> iterator() {
        return new CartIterator();
    }

    private class CartIterator implements Iterator<Item>{
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
            return current < items.size();
        }

        /**
         * Returns the next element in the iteration.
         *
         * @return the next element in the iteration
         * @throws NoSuchElementException if the iteration has no more elements
         */
        @Override
        public Item next() {
            Item i;
            try{
                i = items.get(current);
            }catch (IndexOutOfBoundsException e){
                throw new NoSuchElementException();
            }
            current += 1;
            return i;
        }
    }
}
