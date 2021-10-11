package src.main.java;

public class user {

    private String name;
    private double wallet;
    private String id;
    private String password;

    public user(String name, String id, String password){
        this.name = name;
        this.wallet = 0.0;
        this.id = id;
        this.password = password;
    }
    /**
     * change the user name by using changeName
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
     * Check out my user's current user name
     * return a string representing the name of the user.
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
     * return the id of the user
     */

    public String getId(){
        return this.id;
    }


}
