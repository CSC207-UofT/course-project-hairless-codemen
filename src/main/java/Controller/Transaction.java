package src.main.java.Controller;

import src.main.java.Entities.Item;
import src.main.java.Entities.User;
import src.main.java.Entities.Cart;
import src.main.java.UI.Entry;
import src.main.java.Use_cases.ItemManager;
import src.main.java.Use_cases.CartManager;
import src.main.java.Use_cases.OrderManager;
import src.main.java.Use_cases.UserManager;

import java.util.*;

/**
 * remember to generate a successful order
 */
public class Transaction {

    /**
     * Return whether a User is able to make a purchase. Make changes to involving Users' money if purchase made
     * successfully.
     * @param buyer -  a User who wish to make the purchase.
     * @return the True iff the buyer has enough money to purchase the Item(s); Otherwise return False.
     */
    public static boolean buyItem(User buyer){

        if (buyer.getCart().getTotalPrice() <= UserManager.getMoney(buyer)) {
            Map<User, ArrayList<Item>> category= new HashMap<>();
            for (Item i: buyer.getCart().getItems()){
                ArrayList<Item> item = new ArrayList<>();
                item.add(i);
                User seller = ItemManager.getSeller(i);
                double m = ItemManager.get_price(i)*(CartManager.getCartItems(buyer.getCart()).get(i));
                UserManager.loadMoney(seller, m);   //seller get money
                if(category.containsKey(seller)){category.get(seller).add(i);}
                else {category.put(seller, item);}
            }

            for(User u: category.keySet()){
                OrderManager.create_order(category.get(u), buyer, u); // create order with the same seller
            }

            UserManager.subtractMoney(buyer, buyer.getCart().getTotalPrice());   //subtract buyer money

            for (Map.Entry<Item, Integer> entry : CartManager.getCartItems(buyer.getCart()).entrySet()){
                ItemManager.removeElement(entry.getKey(), entry.getValue());
            }

            CartManager.removeItems(buyer, buyer.getCart().getItems());    //remove the items in buyer's cart
            return true;
        }
        return false;
    }

    /**
     * Sell an Item.
     * @param item - the Item being sold.
     * Return nothing
     */
    public static void sell(Item item){
        ItemManager.addElement(item);
    }

    /**
     * Sell multiple Items.
     * @param items - the list of Items being sold.
     * Return nothing
     */
    public static void sell(ArrayList<Item> items){
        ItemManager.addElement(items);
    }

    /**
     * Add money to a User.
     * @param u - the User we want to add money to.
     * @param money - the amount of money we wish to add.
     * Return nothing
     */
    public static void addMoney(User u, double money){
        UserManager.loadMoney(u, money);
    }

}


