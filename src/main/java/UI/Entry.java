package src.main.java.UI;
import src.main.java.Controller.FileFacade;
import src.main.java.Controller.Login;
import src.main.java.Controller.FileFacade;
import src.main.java.Entities.User;
import src.main.java.Entities.UserStorage;
import src.main.java.Use_cases.UserReadWriter;


import javax.swing.*;
import java.io.EOFException;
import java.io.IOException;

import static src.main.java.Controller.Login.logout;


public class Entry {
    public static void main (String [] args) throws IOException, ClassNotFoundException {

        Login login = new Login();
        Frame frame = new Frame(login);
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
