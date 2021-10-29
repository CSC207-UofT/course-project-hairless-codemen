package src.main.java.Entities;


import java.io.Serializable;

public class Item implements Serializable {

    private String name;
    private final User owner;
    private double price;
    private int quantity;
    private final String category;
    private final double id;

    public Item(String name, User owner, double price, int quantity, String category, double id){
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.owner = owner;
        this.category = category;
        this.id = id;
    }

    public Item(String name, User owner, double price, String category, double id){
        this.name = name;
        this.price = price;
        this.owner = owner;
        this.id = id;
        this.quantity = 1;
        this.category = category;
    }
    /**
     * Get the selling Item's name.
     * @return the Item's name.
     */
    public String getItemName(){return this.name;}

    /**
     * Get the item's owner.
     * @return the item owner.
     */
    public User getOwner(){return this.owner;}

    /**
     * Get the selling Item's ID.
     * @return the Item ID.
     */
    public double getId() {return this.id;}

    /**
     * Get the price for the selling Item.
     * @return a double type representing the price.
     */
    public double getItemPrice(){
        return this.price;
    }

    /**
     * Get the category of the selling Item.
     * @return item's category.
     */
    public String getCategory(){
        return this.category;
    }

    /**
     * Get how many item(s) are left in stock.
     * @return the number of item(s) left in stock.
     */
    public int getQuantity(){
        return this.quantity;
    }

    /**
     * Change the Item's name.
     */
    public void changeItemName(String new_name){
        this.name = new_name;
    }

    /**
     * Change the Item's price.
     */
    public void changeItemPrice(double new_price){
        this.price = new_price;
    }

    /**
     * Increase the quantity of the Item in stock.
     */
    public void addQuantity(int new_quantity){
        this.quantity = this.quantity + new_quantity;
    }

    /**
     * Decrease the quantity of the Item in stock.
     */
    public void subtractQuantity(int new_quantity){
        this.quantity = this.quantity - new_quantity;
    }

    @Override
    public String toString(){
        return name + ": " + id + ": " + "Category " + category + ", quantity " + quantity + ", with price $" + price;
    }
}