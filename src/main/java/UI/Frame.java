package src.main.java.UI;
import src.main.java.Controller.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Frame extends JFrame{
    JPanel panel = new JPanel();
    JPanel remindPanel=new JPanel();

    public Frame(Font font){
        int size=font.getSize();
        final int HEIGHT =200;


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

        JLabel reminder=new JLabel("Reminder: The password must contain at least 8 characters " +
                "which include an upper letter, a lower letter, one digit and a special character. ");

        remindPanel.add(reminder);

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

        this.setLayout(new BorderLayout());
        this.add(panel,BorderLayout.CENTER);
        this.add(remindPanel,BorderLayout.SOUTH);

        this.setSize(size*200, HEIGHT);
        this.setTitle("Welcome to Hairless-Codemen Trading Platform!");
    }
    private class MyFrameLayout extends LayoutAdapter {

        @Override
        public void addLayoutComponent(String name, Component comp) {

        }

        @Override
        public void removeLayoutComponent(Component comp) {

        }

        @Override
        public void layoutContainer(Container parent) {

            remindPanel.setSize(780,50);
            remindPanel.setLocation( 5, 500);
            panel.setLocation((WIDTH-250)/2 -10, (HEIGHT-250)/2);
            panel.setVisible(true);
        }
    }


}
