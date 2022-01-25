package src.main.java.UI;
import src.main.java.Controller.Login;
import src.main.java.Controller.FileFacade;


import javax.swing.*;
import java.io.IOException;



public class Entry {
    public static void main (String [] args) throws IOException, ClassNotFoundException {
        Frame frame = new Frame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        FileFacade.readUser();
        FileFacade.readItem();
        FileFacade.readOrder();

        frame.addWindowFocusListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                try {
                    Login.logout();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        frame.setVisible(true);
    }
}
