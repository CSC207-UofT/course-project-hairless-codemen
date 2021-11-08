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
    private String username;
    private JLabel Wallet = new JLabel("Wallet: ");
    private JLabel wallet;
    private JButton viewBuyList = new JButton("Want to buy?");
    private JButton load = new JButton("Load");
    private JTextField moneyInput = new JTextField(5);
    private JList BuyList = new JList();
    private JButton viewCart = new JButton("My Cart");
    private JList CartList = new JList();
    private JButton searchButton = new JButton("Search");
    private JButton sell = new JButton("Sell");
    private JButton Checkout = new JButton("Check Out");
    private JButton Order = new JButton("Order");
    private JPanel panel = new JPanel();
    private JPanel panel2 = new JPanel();
    private JPanel panel0 = new JPanel();
    private JPopupMenu BuyChange = new JPopupMenu();
    private JPopupMenu CartChange = new JPopupMenu();
    final int HEIGHT = 500;
    final int WIDTH = 500;
    private final ArrayList<String> cartList = new ArrayList<>();
    private final ArrayList<String> buyList = new ArrayList<>();

    public Home(String username){
        this.username = username;
        Object[] info = FileFacade.getUserInfo(username);
        wallet = new JLabel(Double.toString((Double) info[1]));

        for (int x=0; x< InfoFacade.getCartItems((Cart)info[0]).size(); x+=1){
            cartList.add(InfoFacade.printItem(InfoFacade.getCartItems((Cart)info[0]).get(x)));
        }
        for (int y=0; y< InfoFacade.getItems().size(); y+=1){
            buyList.add(InfoFacade.printItem(InfoFacade.getItems().get(y)));
        }

        panel0.add(moneyInput);
        panel0.add(load);
        panel0.add(Wallet);
        panel0.add(wallet);
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
                panel0.revalidate();
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
                Object selected = BuyList.getModel().getElementAt(BuyList.getSelectedIndex());
                cartList.add(selected.toString());
                InfoFacade.addCartElement((Cart) info[0], InfoFacade.getItems().get(BuyList.getSelectedIndex()));
                viewCart.doClick();
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
                viewCart.doClick();
            }
        });


        sell.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

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
        panel0.setSize(250, 50);
        panel0.setLocation((WIDTH-250)/2, 10);
        panel.setSize(400, 320);
        panel.setLocation(42, 60);
        panel.setBorder(border1);
        panel2.setSize(400, 50);
        panel2.setLocation(40, 400);
        this.add(panel0);
        this.add(panel);
        this.add(panel2);
        this.setSize(WIDTH, HEIGHT);
        this.setTitle(this.username + "'s HomePage");













    }
}
