package src.main.java.UI;

import src.main.java.Controller.FileFacade;
import src.main.java.Controller.InfoFacade;
import src.main.java.Entities.Cart;
import src.main.java.Entities.Item;

import javax.swing.*;
import javax.swing.text.html.parser.Entity;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class QuantFrame extends JFrame {
    final int HEIGHT = 100;
    final int WIDTH = 600;
    JButton OK = new JButton("Ok");
    JButton Back = new JButton("Back");
    JComboBox<Integer> quantityField = new JComboBox<>();
    JPanel quantRoot = new JPanel();
    JLabel quantLabel = new JLabel("Please select the quantity you wish to purchase");



    public QuantFrame(String username, Item item) {
        Object[] info = FileFacade.getUserInfo(username);
        int q = item.getQuantity();
        for (int i = 1; i <= q; i++) {
            quantityField.addItem(i);
        }
        String ItemName = item.getItemName();

        OK.addActionListener((e) -> {
            InfoFacade.addCartElement((Cart) info[0], item, quantityField.getSelectedIndex()+1);
            this.setVisible(false);
            JFrame Home = new Home(username);
            Home.setVisible(true);
        });

        Back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                QuantFrame.this.setVisible(false);
                JFrame home = new Home(username);
                home.setVisible(true);
            }
        });

        quantRoot.add(quantLabel);
        quantRoot.add(quantityField);
        quantRoot.add(OK);
        quantRoot.add(Back);
        quantityField.setVisible(true);
        this.setTitle("Product selected: "+ItemName);
        this.setSize(WIDTH, HEIGHT);
        this.add(quantRoot);


    }

    private class QuantLayout extends LayoutAdapter {

        @Override
        public void addLayoutComponent(String name, Component comp) {

        }

        @Override
        public void removeLayoutComponent(Component comp) {

        }

        @Override
        public void layoutContainer(Container parent) {
            quantityField.setBounds(0, 5, 100, 100);
        }


    }
}
