package src.main.java.Controller;
import src.main.java.Entities.*;
import src.main.java.Use_cases.*;

import java.util.ArrayList;
import java.util.Map;

public class Finder {

    /**
     * The "types" of search allowed.
     */
    public enum Find_By {NAME, OWNER, CATEGORY}

    /**
     * Return the search result by specifying where to search.
     * @param target - a string which represents the target of our search.
     * @param f - the indication of where to search.
     * @return the matching Item(s) from the search words or null if no match found.
     */
    public static ArrayList<Item> find(String target, Find_By f){
        if (f.equals(Find_By.NAME)){return ItemManager.search(target);}
        else if (f.equals(Find_By.OWNER)){return ItemManager.search_by_owner(target);}
        else if (f.equals(Find_By.CATEGORY)){return ItemManager.search_by_category(target);}
        return null;
    }

    /**
     * Return the search result which is an Order.
     * @param target - an integer which represents the order number.
     * @return the matching Order which has this order number or null if no match found.
     */
    public static Order find(int target){
        if (!OrderManager.has_order(target)){
            return null;
        }
        return (Order) OrderManager.search(target);
    }

    /**
     * Return the orderList from one owner.
     * @param u - the owner of the items.
     * @return the orderList from one owner
     */
    public static ArrayList<Order> find(User u){
        return OrderManager.getOwnerOrders(u);
    }

}
