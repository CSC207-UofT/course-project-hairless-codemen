package src.main.java.UI;

import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import java.awt.*;
import java.util.Enumeration;

public class FontFrame extends JFrame {

    public FontFrame() {
        final int HEIGHT =80;
        final int WIDTH=200;
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
            InitGlobalFont(new Font("Times New Roman", Font.BOLD, a));
            Frame frame=new Frame(new Font("Times New Roman", Font.BOLD, a));
            FontFrame.this.setVisible(false);
            frame.setVisible(true);
        }));
        this.add(f);
        this.setVisible(true);
        this.setSize(WIDTH, HEIGHT);

    }

    private static void InitGlobalFont(Font font) {
        FontUIResource fontResource = new FontUIResource(font);
        for (Enumeration<Object> keys = UIManager.getDefaults().keys(); keys.hasMoreElements(); ) {
            Object key = keys.nextElement();
            Object value = UIManager.get(key);
            if (value instanceof FontUIResource) {
                System.out.println(key);
                UIManager.put(key, fontResource);
            }


        }
    }}