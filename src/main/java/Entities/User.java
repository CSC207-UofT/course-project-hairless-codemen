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
     * create another constructor for invited customers, they have some money after they create account.
     */
    public User(String name, int id, String password, double daddymoney){
        this.name = name;
        this.wallet = new Wallet(daddymoney);
        this.id = id;
        this.password = password;
        this.cart = new Cart();
    }
    /**
     * change the User name by using changeName
     * return nothing
     */
    public void changeName(String new_name){
        this.name = new_name;
    }
    /**
     * change the current password by using setPassword
     * return nothing
     */
    public void setPassword(String new_password){
        this.password = new_password;
    }
    /**
     * Check out my User's current User name
     * return a string representing the name of the User.
     */
    public String getName(){
        return this.name;
    }
    /**
     * Check out the amount of the money in the wallet.
     * return a type double representing the money.
     */
    public Wallet getWallet(){
        return this.wallet;
    }

    public Cart getCart(){
        return this.cart;
    }

    public int getId(){
        return this.id;
    }
}

