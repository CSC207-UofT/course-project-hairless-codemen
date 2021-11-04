package src.main.java.UI;
import src.main.java.Controller.Login;


import javax.swing.*;
import java.io.IOException;


public class Entry {
    public static void main (String [] args) throws IOException, ClassNotFoundException {

        Login login = new Login();
        Frame frame = new Frame(login);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.addWindowFocusListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                try {
                    login.logout();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        frame.setVisible(true);
    }
}
