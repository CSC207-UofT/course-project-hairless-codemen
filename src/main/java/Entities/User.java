package src.main.java.Entities;

public class User {

    private String name;
    private double wallet;
    private final String id;
    private String password;

    public User(String name, String id, String password){
        this.name = name;
        this.wallet = 0.0;
        this.id = id;
        this.password = password;
    }
    /**
     * create another constructor for invited customers, they have some money after they create account.
     */
    public User(String name, String id, String password, double daddymoney){
        this.name = name;
        this.wallet = daddymoney;
        this.id = id;
        this.password = password;
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
    public double getMoney(){
        return this.wallet;
    }

    /**
     * return the id of the User
     */

    public String getId(){
        return this.id;
    }

    /**
     * increase the money inside the wallet
     */

    public void increase_money(double new_money){
        this.wallet = this.wallet + new_money;

    }

    /**
     * subtract the money inside the wallet
     */
    public void subtract_money(double new_money){
        this.wallet = this.wallet - new_money;
    }
}

