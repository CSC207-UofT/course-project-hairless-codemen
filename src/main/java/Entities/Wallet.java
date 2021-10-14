package src.main.java.Entities;

public class Wallet {
    private double money;

    public Wallet(double money){
        this.money = money;
    }

    public Wallet(){
        this.money = 0.0;
    }

    public double getMoney() {
        return this.money;
    }

    public void loadMoney(int money){
        this.money += money;
    }

    public void subtractMoney(int money){
        this.money -= money;
    }
}
