package src.main.java.Controller;

import src.main.java.Entities.Item;
import src.main.java.Entities.User;
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

        if (UserManager.getUserCart(buyer).getTotalPrice() <= UserManager.getMoney(buyer)) {
            Map<User, ArrayList<Item>> category= new HashMap<>();
            ArrayList<Integer> quantity = new ArrayList<>();
            for (Item i: UserManager.getUserCart(buyer).getItems()){
                quantity.add(CartManager.getCartItems(UserManager.getUserCart(buyer)).get(i));
                User seller = ItemManager.getSeller(i);
                double m = ItemManager.get_price(i)*(CartManager.getCartItems(UserManager.getUserCart(buyer)).get(i));
                UserManager.loadMoney(seller, m);   //seller get money
                if (!category.containsKey(seller)) {
                    category.put(seller, new ArrayList<>());
                }
                category.get(seller).add(i);
            }

            for(User u: category.keySet()){
                OrderManager.createOrder(category.get(u), buyer, u, quantity); // create order with the same seller
            }

            UserManager.subtractMoney(buyer, UserManager.getUserCart(buyer).getTotalPrice());   //subtract buyer money

            for (Map.Entry<Item, Integer> entry : CartManager.getCartItems(UserManager.getUserCart(buyer)).entrySet()){
                ItemManager.removeElement(entry.getKey(), entry.getValue());
            }

            CartManager.removeItems(buyer, UserManager.getUserCart(buyer).getItems());    //remove the items in buyer's cart
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
     * Add money to a User.
     * @param u - the User we want to add money to.
     * @param money - the amount of money we wish to add.
     * Return nothing
     */
    public static void addMoney(User u, double money){
        UserManager.loadMoney(u, money);
    }

}


