package src.main.java.UI;
import src.main.java.Controller.Login;


import javax.swing.*;


public class Entry {
    public static void main (String [] args) {

        Login login = new Login();
        Frame frame = new Frame(login);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.addWindowFocusListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                Login.logout();
            }
        });
        frame.setVisible(true);
    }
}
