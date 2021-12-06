package src.main.java.UI;
import src.main.java.Controller.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Frame extends JFrame{

    final int HEIGHT = 500;
    final int WIDTH = 500;
    public Frame(){
        JPanel panel = new JPanel();

        JLabel userLabel = new JLabel("Username:");
        panel.add(userLabel);

        JTextField userid = new JTextField(20);
        panel.add(userid);

        JLabel passwordLabel = new JLabel("Password:");
        panel.add(passwordLabel);

        JTextField passwordInput = new JPasswordField(20);
        panel.add(passwordInput);

        JButton signupButton = new JButton("register");
        panel.add(signupButton);
        JButton loginButton = new JButton("login");
        panel.add(loginButton);

        signupButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = userid.getText();
                String password = passwordInput.getText();
                if (!RegexChecker.ContainsInfo(id) || !RegexChecker.ContainsInfo(password)){
                    JOptionPane.showMessageDialog(null, "Sorry, username and password cannot be empty!");
                }
                else if (!RegexChecker.ContainsDigit(password)){
                    JOptionPane.showMessageDialog(null, "Your password should contain at least one digit.");
                }
                else if (!RegexChecker.ContainsUpper(password)){
                    JOptionPane.showMessageDialog(null, "Your password should contain at least one uppercase letter.");
                }
                else if (!RegexChecker.ContainsLower(password)){
                    JOptionPane.showMessageDialog(null, "Your password should contain at least one lowercase letter.");
                }
                else if (!RegexChecker.ContainsSpecialChar(password)){
                    JOptionPane.showMessageDialog(null, "Your password should contain at least one special character.");
                }
                else if (!RegexChecker.MinLen(password)){
                    JOptionPane.showMessageDialog(null, "Your password should contain at least 8 characters.");
                }
                else if (Login.signup(id, password)){
                    JOptionPane.showMessageDialog(null, "success!!");
                }
                else{
                    JOptionPane.showMessageDialog(null, "Username has been used, pls change " +
                            "another username.");
                }


            }
        });

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = userid.getText();
                String password = passwordInput.getText();
                boolean res = false;
                try {
                    res = Login.login(id, password);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                if(!res)
                    JOptionPane.showMessageDialog(null, "Invalid user or wrong password.");
                else{
                    Frame.this.setVisible(false);
                    JFrame Home = new Home(id);
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
