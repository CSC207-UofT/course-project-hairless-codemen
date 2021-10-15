package src.main.java.Entities;


public class Item {

    private String name;
    private final User owner;
    private double price;
    private int quantity;
    private final String category;

    public Item(String name, User owner, double price, int quantity, String category){
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.owner = owner;
        this.category = category;
    }

    public Item(String name, User owner, double price, String category){
        this.name = name;
        this.price = price;
        this.owner = owner;
        this.quantity = 1;
        this.category = category;
    }
    /**
     * Get the selling Item's name
     * Return type string
     */
    public String getItemName(){
        return this.name;
    }

    public User getOwner(){ return this.owner;}

    /**
     * Get the price for the selling Item
     * Return a double type representing the price
     */
    public double getItemPrice(){
        return this.price;
    }

    public String getCategory(){
        return this.category;
    }

    /**
     * Get how many stocks are left for the selling Item
     * Return an int type
     */
    public int getQuantity(){
        return this.quantity;
    }
    /**
     * Change the Item's name
     * Return nothing
     */
    public void changeItemName(String new_name){
        this.name = new_name;
    }
    /**
     * Change the price of the Item
     * Return nothing
     */
    public void changeItemPrice(double new_price){
        this.price = new_price;
    }

    /**
     * To increase/subtract the quantity of the Item
     * Return nothing
     */
    public void addQuantity(int new_quantity){
        this.quantity = this.quantity + new_quantity;
    }

    public void subtractQuantity(int new_quantity){
        this.quantity = this.quantity - new_quantity;
    }

    @Override
    public String toString(){
        return name + ": " + "Category " + category + ", quantity " + quantity + ", with price $" + price;
    }
}