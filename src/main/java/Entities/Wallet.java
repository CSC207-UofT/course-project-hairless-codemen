package src.main.java.Entities;

import java.io.Serializable;

public class Wallet implements Serializable {
    private double money;

    /**
     * The first constructor of Wallet for wallet that begins with customized amount of money.
     * @param money - money already loaded in the wallet to begin with.
     */
    public Wallet(double money){
        this.money = money;
    }

    /**
     * The second constructor of Wallet initializes a wallet with 0.0 dollars.
     */
    public Wallet(){
        this.money = 0.0;
    }

    /**
     * A getter method that returns the amount of money stored in this wallet.
     * @return the amount of money stored in this wallet.
     */
    public double getMoney() {
        return this.money;
    }

    /**
     * Load a customized amount of money into this wallet.
     * @param money - amount of money to be loaded into the wallet.
     */
    public void loadMoney(double money){
        this.money += money;
    }

    /**
     * Subtract a customized amount of money from this wallet.
     * @param money - amount of money to be subtracted from the wallet.
     */
    public void subtractMoney(double money){
        this.money = Math.round((this.money - money) * 100.0)/100.0;
    }
}
