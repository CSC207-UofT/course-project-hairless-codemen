package src.main.java.UI;
import src.main.java.Controller.Login;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.io.IOException;
import java.util.ArrayList;

public class Home extends JFrame{
    private String username;
    private int userid;
    private JButton viewBuyList;
    private JList BuyList;
    private JButton viewSellList;
    private JList SellList;
    private JButton viewCart;
    private JList Cart;
    private JButton searchButton;
    private JTextField searchInput;
    final int HEIGHT = 500;
    final int WIDTH = 500;
    Login system;

    private ArrayList<String> buyList = new ArrayList<>();
    private ArrayList<String> sellList = new ArrayList<>();
    private ArrayList<String> cart = new ArrayList<>();

    public Home(String username, Login system){
        this.username = username;
        this.userid =


    }
}
