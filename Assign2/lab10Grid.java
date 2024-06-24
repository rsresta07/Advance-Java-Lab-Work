package Assign2;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class lab10Grid {
    public static void main(String[] args) {
        JFrame frame = new JFrame("GridLayout Demo");
        frame.setLayout(new GridLayout(3, 2));

        for (int i = 1; i <= 6; i++) {
            frame.add(new JButton("Button " + i));
        }

        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
