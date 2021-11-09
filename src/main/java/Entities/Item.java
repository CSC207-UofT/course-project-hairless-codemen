package src.main.java.Entities;


import java.io.Serializable;

public class Item implements Serializable {



    private String name;
    private final User owner;
    private double price;
    private int quantity;
    private final String category;

    /**
     * The first constructor of Item for Item has customized quantity
     * @param name name of the item
     * @param owner the owner of the item, who sells it
     * @param price the price of the item
     * @param quantity quantity of the item
     * @param category category the item belongs to
     */
    public Item(String name, User owner, double price, int quantity, String category){
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.owner = owner;
        this.category = category;
    }

    /**
     * Second constructor of Item has default quantity one
     * @param name name of the item
     * @param owner the owner of the item, who sells it
     * @param price the price of the item
     * @param category category the item belongs to
     */
    public Item(String name, User owner, double price, String category){
        this.name = name;
        this.price = price;
        this.owner = owner;
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
     * @param new_name The new name we want to use.
     */
    public void changeItemName(String new_name){
        this.name = new_name;
    }

    /**
     * Change the price of the Item.
     * @param new_price The new price we want to set.
     */
    public void changeItemPrice(double new_price){
        this.price = new_price;
    }

    /**
     * Increase the quantity of the Item's stock.
     * @param new_quantity The quantity we want to increase by.
     */
    public void addQuantity(int new_quantity){
        this.quantity = this.quantity + new_quantity;
    }

    /**
     * Subtract the quantity of the Item's stock.
     * @param new_quantity The quantity we want to decrease by.
     */
    public void subtractQuantity(int new_quantity){
        this.quantity = this.quantity - new_quantity;
    }

    @Override
    public String toString(){
        return name + ": "  + "Category: " + category + ", Quantity: " + quantity + ", Price: $" + price;
    }
}