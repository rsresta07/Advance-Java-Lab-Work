package Assign1;

import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

public class lab04 {
    public static void main(String[] args) {
        JFrame frame1 = new JFrame("Hello World");
        frame1.setLayout(new FlowLayout(FlowLayout.CENTER));

        JButton b1 = new JButton("Apple");
        JButton b2 = new JButton("Orange");
        JButton b3 = new JButton("Guava");

        frame1.add(b1);
        frame1.add(b2);
        frame1.add(b3);

        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.setSize(400, 200);
        frame1.setVisible(true);
    }
}
