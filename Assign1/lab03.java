package Assign1;

import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

public class lab03 {
    public static void main(String[] args){
        JFrame frame1 = new JFrame("Hello World");
        frame1.setLayout(new FlowLayout(FlowLayout.LEFT));
        JButton b1 = new JButton("Hello");

        frame1.add(b1);
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.setSize(600,400);
        frame1.setVisible(true);
    }
}
