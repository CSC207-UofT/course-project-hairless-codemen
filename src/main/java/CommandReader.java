package src.main.java;

import src.main.java.Entities.Item;

import java.util.ArrayList;
import java.util.Scanner;

public class CommandReader {

    public static Object[] signUp() {
        Scanner in = new Scanner(System.in);
        System.out.println("Please create an account by entering your username: ");
        String username = in.nextLine();
        System.out.println("Please enter your password: ");
        String password = in.nextLine();
        return Login.signup(username, password);
    }

    public static boolean buy(ArrayList<Item> items, int userId){
        Scanner in2 = new Scanner(System.in);
        System.out.println("Which item would you like to buy? Please input a number from 1 to " +
                (items.size()) + ": ");
        int number = Integer.parseInt(in2.nextLine());
        System.out.println("Buying item #" + number + ": " + items.get(number - 1) + "...");
        return Transaction.buy(items.get(number - 1), userId);
    }

    public static void itemInfo(ArrayList<Item> items){
        System.out.println("We have the following items:");
        for (int i = 0; i < items.size(); i++){
            System.out.println((i + 1) + ". " + items.get(i));
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to our buying and selling program! ");
        Object[] lst = signUp();
        String name = (String) lst[0];
        int id = (int) lst[1];
        System.out.println("Welcome, " + name + "! Your user id on our platform is #" + id + ".");
        System.out.println("Since you are a new user, you have $100 on your account to begin with!");
        ArrayList<Item> items = Transaction.loadItems();
        itemInfo(items);
        System.out.println(name + ", would you like to buy items from us today? Please enter 'yes' or 'no':");
        String answer = input.nextLine();

        /*Since we don't have time to take care of invalid user inputs, any input other than "no" will be treated as
        * "yes". */

        while (!answer.equals("no")){
            boolean status = buy(items, id);
            if (status){
                System.out.println("Thank you for buying the items! You have $" + Transaction.getMoney(id) + " left.");}
            else {
                System.out.println("Sorry, you do not have enough money to purchase this item. You have " +
                        "$" + Transaction.getMoney(id) + " left.");
            }
            items = Transaction.getItems();
            itemInfo(items);
            System.out.println(name + ", would you like to buy items from us today? Please enter 'yes' or 'no':");
            answer = input.nextLine();
        }
        System.out.println("Thank you for shopping with us, " + name + ". Have a nice day! " +
                "We welcome you to come back again soon!");
    }
}
