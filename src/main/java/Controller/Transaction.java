package src.main.java.Controller;

import src.main.java.Entities.Item;
import src.main.java.Entities.Order;
import src.main.java.Entities.OrderStorage;
import src.main.java.Entities.User;
import src.main.java.Use_cases.ItemManager;
import src.main.java.Use_cases.CartManager;
import src.main.java.Use_cases.OrderManager;
import src.main.java.Use_cases.UserManager;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.Objects;

/**
 * remember to generate a successful order
 */
public class Transaction {

    /**
     * Return whether a User is able to make a purchase. Make changes to involving Users' money if purchase made
     * successfully.
     * @param items - a list of Item(s) that the buyer wants to buy.
     * @param buyman -  a User who wish to make the purchase.
     * @param sellman - a User who has the Item(s) that the buyer wishes to purchase.
     * @return the True iff the buyer has enough money to purchase the Item(s); Otherwise return False.
     */
    public static boolean buy_item(ArrayList<Item> items, User buyman, User sellman){
        if (ItemManager.get_all_price(items) <= UserManager.getMoney(buyman)) {
            Order dingdan = OrderManager.create_order(items, buyman, sellman);
            OrderManager.addElement(dingdan);         //create order
            UserManager.subtractMoney(buyman, ItemManager.get_all_price(items));   //subtract buyman money
            UserManager.loadMoney(sellman, ItemManager.get_all_price(items));     //seller get money
            CartManager.remove_items(buyman, items);                   //remove the items in buyman's cart
            return true;
        }
        return false;
    }



/**
public class Transaction {
    public static ArrayList<Item> loadItems() throws IOException {
        User u = (User) UserManager.createUser("User1", "1234")[0];
        Item[] itemLst = ItemManager.loadItems(u);
        return new ArrayList<>(Arrays.asList(itemLst));
    }

/**
    public static boolean buy(Item item, int userId){
        User u = UserManager.search(userId);
        double money = UserManager.getMoney(u);
        double price = CartManager.getPrice(item);
        if (price < money) {
            UserManager.subtractMoney(u, price);
            ItemManager.removeElement(item);
            return true;
        }
        else return false;
    }


    /**
     * Get the amount of money that a User has right now.
     * @param username - the User we want to know about.
     * Return a double representing the amount of money.
     */
    public static double getMoney(String username){
        return UserManager.getMoney(Objects.requireNonNull(UserManager.search(username)));
    }

    /**
     * Get all the Items stored.
     * Return a hash map containing information of all Items stored.
     */
    public static Map<String, ArrayList<Item>> getItems(){
        return ItemManager.getItems();
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
    public void sell(ArrayList<Item> items){
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


