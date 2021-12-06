package src.main.java.Use_cases;

import src.main.java.Entities.Item;
import src.main.java.Entities.Order;
import src.main.java.Entities.OrderStorage;
import src.main.java.Entities.User;
import src.main.java.Entities.Cart;
import java.util.ArrayList;
import java.util.Map;

public class OrderManager implements Manager{

    /**
     * Search an order based on its order id.
     * @param order_id - the order id to be used to perform the search for the matched order.
     * @return the Object representing the order searched based on the id.
     * @throws NullPointerException if there is no order corresponding to the order_id given.
     */
    public static Object search(int order_id) throws NullPointerException{
        return OrderStorage.getOrders().get(order_id);
    }

    /**
     * Return whether an order with matching order id exists.
     * @param order_id the order id to be used to perform the search for the matched order.
     * @return true if a matching oder exist. False otherwise.
     */
    public static boolean hasOrder(int order_id){
        for (int ids: OrderStorage.getOrders().keySet()){
            if (order_id == ids){
                return true;
            }
        }
        return false;
    }


    /**
     * Get all orders stored in order storage in the map form.
     * @return the Map containing all orders stored in order storage, where keys in the map represents order id of each
     * order and the corresponding value is the Order object. Each key (order id) can only have one value (Order).
     */
    public static Map<Integer, Order> getItems() {return OrderStorage.getOrders();}


    /**
     * Add a list of elements into order storage.
     * @param elements - the list of elements to be added into order storage.
     */
    public static void addElement(Object[] elements){
        for (Object element: elements){
            addElement(element);
        }
    }

    /**
     * Add a list of orders into order storage.
     * @param orders - the ArrayList of orders to be added into order storage.
     */
    public static void addElement(ArrayList<Order> orders){
        for (Order o: orders){
            addElement(o);
        }
    }

    /**
     * Add an order into order storage.
     * @param element - the element to be added into order storage.
     */
    public static void addElement(Object element){
        OrderStorage.addElement(element);
    }

    /**
     * Get the total number of orders stored in order storage.
     * @return the int representing the total number of orders stored in the system (order storage).
     */
    public static int totalNumberOrder(){
        return OrderStorage.get_size();
    }

    /**
     * Returns an list of orders from a specific user.
     * @param u - the list of orders with owner being whom will be returned
     * @return an ArrayList of orders where the User u is the buyer for each one.
     */
    public static ArrayList<Order> getOrders(User u){
        ArrayList<Order> o1 = new ArrayList<>(OrderStorage.getOrders().values());
        ArrayList<Order> o2 = new ArrayList<>();
        for (Order o: o1){
            if (o.getBuyer().getName().equals(u.getName())){
                o2.add(o);
            }
        }
        return o2;
    }


    /**
     * Returns an list of orders from a specific seller.
     * @param u - the list of orders with owner being whom will be returned
     * @return the orderList from one owner
     */
    public static ArrayList<Order> getOwnerOrders(User u){
        return OrderStorage.getOwnerOrder(u);
    }

    /**
     * Creates an order with provided items, a buyer and a seller and returns the created order.
     * @param items_list - the ArrayList of items to be added to the order to be created.
     * @param buyer - the buyer of this order to be created.
     * @param seller - the seller of all items in this order. Each order can only have items from only one seller.
     * @return an Order object representing the newly created order with provided items, a buyer and a seller.
     */
    public static Order createOrder(ArrayList<Item> items_list, User buyer, User seller){
        double total_price = 0.0;
        Cart c = buyer.getCart();
        for (Item item: items_list){
            total_price += CartManager.getCartItems(c).get(item) * item.getItemPrice();
        }
        Order o = new Order(OrderStorage.get_size()+1,items_list, buyer, seller, total_price);
        addElement(o);
        return o;
    }

    /**
     * Remove a list of orders from order storage.
     * @param elements - the ArrayList of orders to be removed from order storage.
     */
    public static void removeElement(Object[] elements){}


    public static void removeElement(Object element){}

    public static String printOrders(ArrayList<Order> orders){
        StringBuilder sb = new StringBuilder();
        for (Order o: orders){
            sb.append(o);
            sb.append("\n\n");
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
