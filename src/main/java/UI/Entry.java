package src.main.java.UI;
import src.main.java.Controller.Login;
import src.main.java.Controller.FileFacade;
import src.main.java.Use_cases.UserManager;


import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import java.awt.*;
import java.io.IOException;
import java.util.Enumeration;


public class Entry {
    private static int a = 15;
    public static void main (String [] args) throws IOException, ClassNotFoundException {
        InitGlobalFont(new Font("Times New Roman", Font.BOLD, a));
        FileFacade.readUser();
        FileFacade.readItem();
        FileFacade.readOrder();
//        Frame frame=new Frame(new Font("Times New Roman", Font.BOLD, a));
        FontFrame frame = new FontFrame();


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
    private static void InitGlobalFont(Font font) {
        FontUIResource fontResource = new FontUIResource(font);
        for(Enumeration<Object> keys = UIManager.getDefaults().keys(); keys.hasMoreElements();) {
            Object key = keys.nextElement();
            Object value = UIManager.get(key);
            if(value instanceof FontUIResource) {
                System.out.println(key);
                UIManager.put(key, fontResource);
            }
        }
    }

}
