package src.main.java.UI;
import src.main.java.Controller.Login;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.io.IOException;

public class Frame extends JFrame{
    private JLabel userLabel;
    private JTextField userid;
    private JLabel passwordLabel;
    private JPasswordField passwordInput;
    private JButton signupButton;
    private JButton loginButton;
    private JPanel panel;
    final int HEIGHT = 500;
    final int WIDTH = 500;
    Login system;

    public Frame(Login system){
        this.system = system;
        panel = new JPanel();

        userLabel = new JLabel("Username:");
        panel.add(userLabel);

        userid = new JTextField(20);
        panel.add(userid);

        passwordLabel = new JLabel("Password:");
        panel.add(passwordLabel);

        passwordInput = new JPasswordField(20);
        panel.add(passwordInput);

        signupButton = new JButton("register");
        panel.add(signupButton);
        loginButton = new JButton("login");
        panel.add(loginButton);

        signupButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = userid.getText();
                String password = passwordInput.getText();
                try {
                    Login.signup(id, password);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                JOptionPane.showMessageDialog(null, "success!!");


            }
        });

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = userid.getText();
                String password = passwordInput.getText();
                boolean res = false;
                try {
                    res = system.login(id, password);
                } catch (IOException ex) {
                    ex.printStackTrace();
                } catch (ClassNotFoundException ex) {
                    ex.printStackTrace();
                }
                if(!res)
                    JOptionPane.showMessageDialog(null, "Invalid user or wrong password.");
                else{
                    Frame.this.setVisible(false);
                    JFrame Home = new Home(id, system);
                    Home.setVisible(true);
                }
            }
        });

        this.setLayout(null);
        panel.setSize(250, 250);
        panel.setLocation((WIDTH-250)/2, (HEIGHT-250)/2);
        this.add(panel);
        this.setSize(WIDTH, HEIGHT);
        this.setTitle("Welcome to Hairless-Codemen Trading Platform!");
    }

}
