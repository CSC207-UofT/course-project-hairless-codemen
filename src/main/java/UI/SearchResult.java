package src.main.java.UI;

import src.main.java.Controller.FileFacade;
import src.main.java.Controller.InfoFacade;
import src.main.java.Controller.Login;
import src.main.java.Entities.Cart;
import src.main.java.Entities.Item;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.ArrayList;

public class SearchResult extends JFrame {
    private final int HEIGHT = 500;
    private final int WIDTH = 500;
    public SearchResult(String username, ArrayList<Item> result){
        JPanel panel = new JPanel();
        JPanel panel2 = new JPanel();
        JList resultList = new JList();
        ArrayList<String> res = new ArrayList<>();
        JPopupMenu CartChange = new JPopupMenu();
        JMenuItem addInto = new JMenuItem("Add into my cart");
        JButton Back = new JButton("Back");
        panel.setLayout(new BorderLayout());
        CartChange.add(addInto);
        resultList.add(CartChange);
        JScrollPane scrollPane = new JScrollPane(resultList);
        panel.add(scrollPane);
        Object[] info = FileFacade.getUserInfo(username);
        for (Item item : result) {
            res.add(InfoFacade.printItem(item));
        }
        resultList.setListData(res.toArray());
        panel2.add(Back);

        resultList.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if(e.getButton()==1&&resultList.getSelectedIndex()!=-1){
                    CartChange.show(e.getComponent(), e.getX(), e.getY());
                }
            }
        });

        addInto.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                InfoFacade.addCartElement((Cart)info[0], result.get(resultList.getSelectedIndex()));
                JOptionPane.showMessageDialog(null,"Successfully added!");
            }
        });

        Back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SearchResult.this.setVisible(false);
                JFrame SearchFrame = new SearchFrame(username);
                SearchFrame.setVisible(true);
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

        this.setLayout(null);
        panel.setSize(350,250);
        panel2.setSize(350,50);
        panel.setLocation((WIDTH-350)/2, 80);
        panel2.setLocation((WIDTH-350)/2, 340);
        this.add(panel);
        this.add(panel2);
        this.setSize(WIDTH,HEIGHT);
        this.setTitle("Search Result");
    }
}
