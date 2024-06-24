package Assign1;

import java.awt.Dimension;
import javax.swing.JFrame;

public class lab02 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("My First GUI Program");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Dimension windowSize = new Dimension(600, 400);
        frame.setSize(windowSize);
        frame.setVisible(true);
    }
}