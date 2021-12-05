package src.main.java.UI;

import src.main.java.Controller.FileFacade;
import src.main.java.Controller.InfoFacade;
import src.main.java.Entities.Cart;
import src.main.java.Entities.Item;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class QuantFrame extends JFrame {
    final int HEIGHT = 100;
    final int WIDTH = 500;
    JButton OK = new JButton("OK");
    JComboBox<Integer> quantityField = new JComboBox<>();
    JPanel quantRoot = new JPanel();
    JLabel quantLabel = new JLabel("Please select the quantity you wish to purchase");



    public QuantFrame(String username, Item item) {
        List[] quantlist= new List[0];
        int q = item.getQuantity();
        for (int i = 1; i <= q; i++) {
            quantityField.addItem(i);
        }

        OK.addActionListener((e) -> {
            InfoFacade.addCartElement((Cart) FileFacade.getUserInfo(username)[0], item, quantityField.getSelectedIndex()+1);
            this.dispose();
        });

        quantRoot.add(quantLabel);
        quantRoot.add(quantityField);
        quantRoot.add(OK);
        quantityField.setVisible(true);
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
            int width = parent.getWidth();
            int height = parent.getHeight();
            quantityField.setBounds(0, 0, 100, 100);
        }


    }
}
