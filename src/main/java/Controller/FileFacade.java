package src.main.java.Controller;

import src.main.java.Entities.*;
import src.main.java.Use_cases.*;

import java.io.IOException;


public class FileFacade {

    /**
     * Add a single user to the system.
     * @param u - the User to be added.
     */
    public static void addUser(User u) {
        UserManager.addElement(u);
    }

    /**
     * Creates a user with given username and password.
     * @param username - the username for the new user.
     * @param password - the password for the new user.
     * @return the User object created.
     */
    public static User createUser(String username, String password) {
        return UserManager.create(username, password);
    }

    /**
     * Given the username of a user, return a list of relevant information about this user.
     * @param username - the username of the user whose information will be returned.
     *                  Precondition: the user with this username must exist in the system.
     * @return a list of information about this user (this User's Cart, this User's amount of money stored in the
     * wallet, all orders made by this user, and the User object).
     */
    public static Object[] getUserInfo(String username) {
        Object[] lst = UserManager.getUserInfo(username);
        User u = (User) lst[0];
        return new Object[]{lst[1], lst[2], OrderManager.getOrders(u), u};
    }

    /**
     * Read all Users from UserData.ser. If there isn't any users stored in UserData.ser, add one default user to the
     * system.
     */
    public static void readUser() throws IOException, ClassNotFoundException {
        try {
            UserReadWriter.readFromFile();
        } catch (IOException | ClassNotFoundException e) {
            User u = createUser("default", "000000");
            addUser(u);
            UserReadWriter.SaveIntoFile(UserManager.getUserList());
            UserReadWriter.readFromFile();
        }
    }

    /**
     * Read all Items from ItemData.ser. If there isn't any items stored in ItemData.ser, load default items to the
     * system.
     */
    public static void readItem() throws IOException {
        try {
            ItemReadWriter.readFromFile();

        } catch (IOException | ClassNotFoundException e) {
            User u = createUser("default", "000000");
            ItemManager.loadItems(u);
            ItemReadWriter.saveIntoFile(ItemManager.getItems());

        }
    }

    /**
     * Read all Orders from OrderData.ser. If there isn't any orders stored in OrderData.ser, add one default order to
     * the system.
     */
        public static void readOrder() throws IOException, ClassNotFoundException {
            try {
                OrderReadWriter.readFromFile();} catch (IOException | ClassNotFoundException e ) {
                User u = createUser("1", "1");
                User u1 = createUser("default1", "000000");
                addUser(u);
                addUser(u1);
                Order o = new Order(0, ItemManager.getItemsList(), u, u1, 1000);
                OrderManager.addElement(o);
                OrderReadWriter.saveIntoFile(OrderManager.getItems());
                OrderReadWriter.readFromFile();

            }
        }
    }



