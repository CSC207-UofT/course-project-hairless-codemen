package src.main.java.UI;

import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import java.awt.*;
import java.util.Enumeration;

public class FontFrame extends JFrame {

    public FontFrame() {
        final int HEIGHT =200;
        final int Width=200;
        JLabel font=new JLabel("Font size");
        JComboBox<Integer> fontField = new JComboBox<>();
        JButton OK=new JButton("OK");
        JPanel f=new JPanel();
        f.add(font);
        f.add(fontField);
        f.add(OK);

        for (int i = 13; i <= 18; i++) {
            fontField.addItem(i);
        }

        OK.addActionListener((e -> {
            int a =fontField.getSelectedIndex()+13;

        }));
        f.setVisible(true);
        this.setSize(Width, HEIGHT);

    }



}
