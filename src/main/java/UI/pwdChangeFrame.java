package src.main.java.UI;

import src.main.java.Controller.FileFacade;
import src.main.java.Controller.InfoFacade;
import src.main.java.Controller.RegexChecker;
import src.main.java.Entities.User;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class pwdChangeFrame extends JFrame {
    private final int HEIGHT = 300;
    private final int WIDTH = 800;
    private String username;
    public pwdChangeFrame(String username){
        Object[] info = FileFacade.getUserInfo(username);
        JPanel panel0 = new JPanel();
        JLabel message = new JLabel("Please set your new password:");
        JTextField password = new JTextField(10);
        JButton Confirm = new JButton("Confirm password");
        JButton Back = new JButton("Back");
        panel0.add(message);
        panel0.add(password);
        panel0.add(Confirm);
        panel0.add(Back);

        Back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pwdChangeFrame.this.setVisible(false);
                JFrame home = new Home(username);
                home.setVisible(true);
            }
        });

        Confirm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!RegexChecker.CheckPassword(password.getText()).equals("True")){
                    JOptionPane.showMessageDialog(null, RegexChecker.CheckPassword(password.getText()));}
                else if (InfoFacade.changePassword((User)info[3], password.getText())){
                    JOptionPane.showMessageDialog(null, "Successfully Changed!");
                }
            }
        });

        this.setLayout(null);
        panel0.setSize(WIDTH, 200);
        panel0.setLocation(0, (HEIGHT-200)/2);
        this.add(panel0);
        this.setSize(WIDTH, HEIGHT);
        this.setTitle("Change Password Page");
    }
}
