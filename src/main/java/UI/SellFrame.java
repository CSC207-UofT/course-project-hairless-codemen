package src.main.java.UI;

import src.main.java.Controller.FileFacade;
import src.main.java.Controller.Login;
import src.main.java.Controller.Transaction;
import src.main.java.Entities.Item;
import src.main.java.Entities.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

public class   SellFrame extends JFrame {
    JPanel panel = new JPanel();
    JPanel panel1 = new JPanel();
    JLabel Name = new JLabel("Item name:");

    public SellFrame(String username){
        final int HEIGHT = 170;
        final int WIDTH = 700;

        JTextField name = new JTextField(6);
        JLabel category = new JLabel("Category:");
        JTextField categoryInput = new JTextField(6);
        JLabel price = new JLabel("Price:");
        JTextField priceInput = new JTextField(4);
        JLabel quantity = new JLabel("Qty:");
        JTextField qty = new JTextField(4);

        JButton sellButton = new JButton("Sell");
        JButton Back = new JButton("Back");

        panel.add(Name);
        panel.add(name);
        panel.add(category);
        panel.add(categoryInput);
        panel.add(price);
        panel.add(priceInput);
        panel.add(quantity);
        panel.add(qty);
        panel1.add(sellButton);
        panel1.add(Back);

        sellButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(name.getText().equals("")){
                    JOptionPane.showMessageDialog(null,
                            "Item name cannot be empty, please try again.");
                }
                else if(categoryInput.getText().equals("")){
                    JOptionPane.showMessageDialog(null,
                            "Category cannot be empty, please try again.");
                }
                else{
                try{Item item = new Item(name.getText(), (User)FileFacade.getUserInfo(username)[3],
                        Double.parseDouble(priceInput.getText()),
                        Integer.parseInt(qty.getText()), categoryInput.getText());
                Transaction.sell(item);
                JOptionPane.showMessageDialog(null,"Successfully added.");}
                catch (NumberFormatException numberFormatException){
                    JOptionPane.showMessageDialog(null,
                            "Please enter valid price and quantity.");
                }}
            }
        });

        Back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SellFrame.this.setVisible(false);
                JFrame home = new Home(username);
                home.setVisible(true);
            }
        });

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                try {
                    Login.logout();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });


        this.add(panel);
        this.add(panel1);
        this.setLayout(new SellLayout());
        this.setSize(WIDTH,HEIGHT);
        this.setTitle(username+"'s Sell Page");



    }
    private class SellLayout extends LayoutAdapter{

        @Override
        public void addLayoutComponent(String name, Component comp) {

        }

        @Override
        public void removeLayoutComponent(Component comp) {

        }

        @Override
        public void layoutContainer(Container parent) {
            int width=parent.getWidth();
            int height=parent.getHeight();
            panel.setSize(width,50);
            panel1.setSize(width,50);
            panel.setLocation(0, 30);
            panel1.setLocation(0, 90);
        }
    }
}
