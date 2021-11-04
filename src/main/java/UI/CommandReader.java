package src.main.java.UI;

import src.main.java.Entities.Item;
import src.main.java.Controller.Login;
import src.main.java.Controller.Transaction;
import src.main.java.Entities.User;

import java.io.*;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

public class CommandReader {

    public static Object[] signUp() throws IOException {
        Scanner in = new Scanner(System.in);
        System.out.println("Please create an account by entering your username: ");
        String username = in.nextLine();
        System.out.println("Please enter your password: ");
        String password = in.nextLine();
        return Login.signup(username, password);
    }

//    public boolean buy_item(ArrayList<Item> items, User buyman, User sellman) {
//        Scanner in2 = new Scanner(System.in);
//        System.out.println("Which item would you like to buy? Please input a number from 1 to " +
//                (items.size()) + ": ");
//        int number = Integer.parseInt(in2.nextLine());
//        System.out.println("Buying item #" + number + ": " + items.get(number - 1) + "...");
//        return Transaction.buy_item
//    }

    public static void itemInfo(Map<String, ArrayList<Item>> items) {
        System.out.println("We have the following items:");
        int i = 0;
        for (String itemName : items.keySet()) {
            System.out.println((i + 1) + ". " + itemName);
            i++;
        }
    }

    public static void main(String[] args) throws IOException {
        File f = new File("src/main/java/Files/Users.txt");
        FileOutputStream fos = new FileOutputStream(f);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        User user = new User("B", 2, "3434");
        oos.writeObject(user);
    }
}