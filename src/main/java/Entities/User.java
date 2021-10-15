package src.main.java.Entities;

public class User {

    private String name;
    private final int id;
    private String password;
    private final Wallet wallet;
    private final Cart cart;

    public User(String name, int id, String password){
        this.name = name;
        this.wallet = new Wallet();
        this.id = id;
        this.password = password;
        this.cart = new Cart();
    }

    /**
     * Create another constructor for invited customers, they have some money after they create account.
     */
    public User(String name, int id, String password, double daddymoney){
        this.name = name;
        this.wallet = new Wallet(daddymoney);
        this.id = id;
        this.password = password;
        this.cart = new Cart();
    }

    /**
     * Change the User's name by using changeName
     * Return nothing
     */
    public void changeName(String new_name){
        this.name = new_name;
    }

    /**
     * Change the current password by using setPassword
     * Return nothing
     */
    public void setPassword(String new_password){
        this.password = new_password;
    }

    /**
     * Check the User's current name
     * Return a string representing the name of the User
     */
    public String getName(){
        return this.name;
    }

    /**
     * Check the amount of the money in the wallet
     * Return a type double representing the money
     */
    public Wallet getWallet(){
        return this.wallet;
    }

    @Override
    public String toString() {
        return getName();
    }

    public Cart getCart(){
        return this.cart;
    }

    public int getId(){
        return this.id;
    }

    public String getPassword(){
        return this.password;
    }
}

