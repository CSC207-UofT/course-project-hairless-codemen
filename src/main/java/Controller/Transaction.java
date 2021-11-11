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
import java.util.*;

/**
 * remember to generate a successful order
 */
public class Transaction {

    public static boolean buy_item(ArrayList<Item> items, User buyman){

        if (ItemManager.get_all_price(items) <= UserManager.getMoney(buyman)) {
            ArrayList<Item> i_list = new ArrayList<>();
            ArrayList<Item> copy_list = new ArrayList<>(items);

            for (Item i: copy_list){
                User seller = ItemManager.getSeller(i);
                UserManager.loadmoney(seller, ItemManager.get_price(i));   //seller get money
                i_list.add(i);
                ArrayList<Item> temp_lst = new ArrayList<>(List.of(i);
                Order dingdan = OrderManager.create_order(temp_lst, buyman, seller);

            }

            UserManager.subtractMoney(buyman, ItemManager.get_all_price(items));   //subtract buyman money
            CartManager.remove_items(buyman, items);                   //remove the items in buyman's cart

            return true;
        }
        return false;
    }


    public static boolean buy(Item item){
        User seller = ItemManager.getSeller(item);

        double money = UserManager.getMoney(seller);
        double price = CartManager.getPrice(item);
        if (price < money) {
            UserManager.loadmoney(seller, price);    //should be add money
            ItemManager.removeElement(item);

            return true;
        }
        else return false;
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
     * Change the User's name by using changeName
     * Return nothing
     */

    public static double getMoney(String username){
        return UserManager.getMoney(Objects.requireNonNull(UserManager.search(username)));
    }

    public static Map<String, ArrayList<Item>> getItems(){
        return ItemManager.getItems();
    }

    public void sell(Item item){
        ItemManager.addElement(item);
    }

    public void sell(ArrayList<Item> i){
        ItemManager.addElement(i);
    }
}


