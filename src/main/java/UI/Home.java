package src.main.java.UI;
import src.main.java.Controller.*;
import src.main.java.Entities.*;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.ArrayList;

public class Home extends JFrame{

    final int HEIGHT = 500;
    final int WIDTH = 500;
    private final ArrayList<String> cartList = new ArrayList<>();
    private final ArrayList<String> buyList = new ArrayList<>();

    public Home(String username){
        Object[] info = FileFacade.getUserInfo(username);
        JLabel wallet = new JLabel(Double.toString((Double) info[1]));
        JLabel Wallet = new JLabel("Wallet: ");
        JButton viewBuyList = new JButton("Want to buy?");
        JButton load = new JButton("Load");
        JTextField moneyInput = new JTextField(5);
        JList BuyList = new JList();
        JButton viewCart = new JButton("My Cart");
        JList CartList = new JList();
        JButton searchButton = new JButton("Search");
        JButton sell = new JButton("Sell");
        JButton Checkout = new JButton("Check Out");
        JButton Order = new JButton("Order");
        JPanel panel = new JPanel();
        JPanel panel2 = new JPanel();
        JPanel panel0 = new JPanel();
        JPopupMenu BuyChange = new JPopupMenu();
        JPopupMenu CartChange = new JPopupMenu();

        for (int x=0; x< InfoFacade.getCartItems((Cart)info[0]).size(); x+=1){
            cartList.add(InfoFacade.printItem(InfoFacade.getCartItems((Cart)info[0]).get(x)));
        }
        for (int y=0; y< InfoFacade.getItems().size(); y+=1){
            buyList.add(InfoFacade.printItem(InfoFacade.getItems().get(y)));
        }
        panel0.add(Wallet);
        panel0.add(wallet);
        panel0.add(moneyInput);
        panel0.add(load);
        panel.setLayout(new GridLayout(2,1));
        panel.add(viewBuyList);
        JMenuItem addToCart = new JMenuItem("Add into my cart.");
        BuyChange.add(addToCart);
        BuyList.add(BuyChange);
        panel.add(new JScrollPane(BuyList));
        panel.add(viewCart);
        JMenuItem RemoveFromCart = new JMenuItem("Remove from my cart.");
        CartChange.add(RemoveFromCart);
        CartList.add(CartChange);
        panel.add(new JScrollPane(CartList));
        panel2.add(sell);
        panel2.add(Order);
        panel2.add(searchButton);
        panel2.add(Checkout);

        load.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{Integer money = Integer.valueOf(moneyInput.getText());
                    Transaction.addMoney((User)info[3], money);
                    JOptionPane.showMessageDialog(null, "Success!");
                    new Home(username).setVisible(true);
                    Home.this.setVisible(false);}
                catch (NumberFormatException numberFormatException){
                    JOptionPane.showMessageDialog(null, "Please enter number(s).");
                }
            }
        });

        viewBuyList.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BuyList.setListData(buyList.toArray());
            }
        });

        viewCart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CartList.setListData(cartList.toArray());
            }
        });

        BuyList.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if(e.getButton() == 1 && BuyList.getSelectedIndex() != -1){
                    BuyChange.show(e.getComponent(),e.getX(),e.getY());
                }
            }
        });

        addToCart.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
//                Object selected = BuyList.getModel().getElementAt(BuyList.getSelectedIndex());
//                cartList.add(selected.toString());
                Item a=InfoFacade.getItems().get(BuyList.getSelectedIndex());
                QuantFrame frame=new QuantFrame(username, a);
                frame.setVisible(true);
                Home.this.setVisible(false);
            }
        });

        CartList.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if(e.getButton() == 1 && CartList.getSelectedIndex() != -1){
                    CartChange.show(e.getComponent(),e.getX(),e.getY());
                }
            }
        });

        RemoveFromCart.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                Object selected = CartList.getModel().getElementAt(CartList.getSelectedIndex());
                cartList.remove(selected.toString());
                InfoFacade.removeCartElement((Cart) info[0],
                        InfoFacade.getCartItems((Cart)info[0]).get(CartList.getSelectedIndex()));
                viewCart.doClick();
            }
        });


        sell.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Home.this.setVisible(false);
                JFrame sell = new SellFrame(username);
                sell.setVisible(true);
            }
        });

        Order.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String orderInfo = InfoFacade.printOrders((User) FileFacade.getUserInfo(username)[3]);
                if (orderInfo.equals("")){
                    JOptionPane.showMessageDialog(null, "You don't have orders now.");
                }
                else{
                JOptionPane.showMessageDialog(null, "You have these orders:\n"+orderInfo);}
            }
        });

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Home.this.setVisible(false);
                JFrame SearchFrame = new SearchFrame(username);
                SearchFrame.setVisible(true);
            }
        });

        Checkout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(Transaction.buyItem((User)info[3])){
                    JOptionPane.showMessageDialog(null,"Payment processed!");
                    new Home(username).setVisible(true);
                    Home.this.setVisible(false);
                }
                else{
                    JOptionPane.showMessageDialog(null,
                            "Sorry, payment failed. Products may be out of stock or lack of money.");
                }
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
        Border border1 = new LineBorder(Color.LIGHT_GRAY,1);
        panel0.setSize(WIDTH, 50);
        panel0.setLocation(0, 10);
        panel.setSize(400, 320);
        panel.setLocation(42, 60);
        panel.setBorder(border1);
        panel2.setSize(500, 50);
        panel2.setLocation(0, 400);
        this.add(panel0);
        this.add(panel);
        this.add(panel2);
        this.setSize(WIDTH, HEIGHT);
        this.setTitle(username + "'s HomePage");
        viewBuyList.doClick();
        viewCart.doClick();













    }
}
