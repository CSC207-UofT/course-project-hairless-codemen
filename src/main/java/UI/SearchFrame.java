package src.main.java.UI;

import src.main.java.Controller.FileFacade;
import src.main.java.Controller.Finder;
import src.main.java.Controller.InfoFacade;
import src.main.java.Entities.Order;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class SearchFrame extends JFrame{

    private String username;
    final int HEIGHT = 500;
    final int WIDTH = 500;

    public SearchFrame(String username){
        this.username = username;
        JTextField searchInput = new JTextField(10);
        JPanel panel = new JPanel();
        panel.add(searchInput);
        JRadioButton searchByUser = new JRadioButton("User");
        JRadioButton searchByItem = new JRadioButton("Item");
        JRadioButton searchByOrder = new JRadioButton("Order");
        JButton search = new JButton("Search");
        JButton Back = new JButton("Back");
        ButtonGroup group = new ButtonGroup();
        group.add(searchByUser);
        group.add(searchByItem);
        group.add(searchByOrder);
        searchByUser.setSelected(true);

        panel.add(searchByUser);
        panel.add(searchByItem);
        panel.add(searchByOrder);
        panel.add(search);
        panel.add(Back);

        search.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) throws NumberFormatException {
                if(searchByUser.isSelected() || searchByItem.isSelected()){
                    String res = InfoFacade.printItems(Finder.find(searchInput.getText()));
                    if (res.equals("")){
                        JOptionPane.showMessageDialog(null, "No item found.");
                    }
                    else
                    JOptionPane.showMessageDialog(null, "Here's the result:" + res);
                }
                else{
                    try{Integer id = Integer.valueOf(searchInput.getText());
                        String res = InfoFacade.printOrder(Finder.find(id));
                        JOptionPane.showMessageDialog(null, "Here's the result:" + res);}
                    catch (NumberFormatException numberFormatException){
                        JOptionPane.showMessageDialog(null, "Please enter number(s).");
                    }
                    catch (NullPointerException nullPointerException){
                        JOptionPane.showMessageDialog(null, "No order found.");
                    }
                    }

            }
        });

        Back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SearchFrame.this.setVisible(false);
                JFrame home = new Home(username);
                home.setVisible(true);
            }
        });

        this.setLayout(null);
        panel.setSize(300, 300);
        panel.setLocation((WIDTH-300)/2, (HEIGHT-300)/2);
        this.add(panel);
        this.setSize(WIDTH, 300);
        this.setTitle("Search Page");


    }
}
