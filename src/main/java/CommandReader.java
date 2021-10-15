package src.main.java;

import src.main.java.Entities.Item;

import java.sql.Array;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

public class CommandReader {

    public static Object[] signup() {
        Scanner in = new Scanner(System.in);
        System.out.println("Please create an account by entering your username: ");
        String username = in.nextLine();
        System.out.println("Please enter your password: ");
        String password = in.nextLine();
        return LoginC.signup(username, password);
    }

    public static boolean buy(ArrayList<Item> items, int userId){
        Scanner in2 = new Scanner(System.in);
        System.out.println("Which item would you like to buy? Please input a number from 1 to " +
                (items.size()) + ": ");
        int number = Integer.parseInt(in2.nextLine());
        System.out.println("Buying item #" + number + ": " + items.get(number - 1) + "...");
        return Transaction.buy(items.get(number - 1), userId);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to our buying and selling program! ");
        Object[] lst = signup();
        String name = (String) lst[0];
        int id = (int) lst[1];
        System.out.println("Welcome, " + name + "! Your user id on our platform is #" + id);
        System.out.println("Since you are a new user, you have $100 on your account to begin with!");
        ArrayList<Item> items = Transaction.loadItems();
        System.out.println("We have the following items:");
        for (int i = 0; i < items.size(); i++){
            System.out.println( (i + 1) + ". " + items.get(i));
        }
        System.out.println(name + ", would you like to buy items from us today? Please enter 'yes' or 'no':");
        String answer = input.nextLine();
        while (!answer.equals("no")){
            boolean status = buy(items, id);
            if (status){
                System.out.println("Success!");}
            else {
                System.out.println("Fail!");
            }
            System.out.println("We have the following items:");
            items = Transaction.getItems();
            for (int i = 0; i < items.size(); i++){
                System.out.println( (i + 1) + ". " + items.get(i));
            }
            System.out.println(name + ", would you like to buy items from us today? Please enter 'yes' or 'no':");
            answer = input.nextLine();
        }
        System.out.println("Sorry about not having what you want, " + name + ". Have a nice day! " +
                "We welcome you to come back again soon!");
    }
}
