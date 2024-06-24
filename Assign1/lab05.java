package Assign1;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class lab05 {
    public static void main(String[] args) {
        JFrame frame1 = new JFrame("Hello World");
        
        JPanel panel1 = new JPanel(new GridBagLayout());
        GridBagConstraints size = new GridBagConstraints();
        
        JButton b1 = new JButton("One");
        JButton b2 = new JButton("Two");
        JButton b3 = new JButton("Three");
        JButton b4 = new JButton("Four");
        
        b1.setPreferredSize(new Dimension(100, 20));
        b2.setPreferredSize(new Dimension(100, 20));
        b3.setPreferredSize(new Dimension(100, 20));
        b4.setPreferredSize(new Dimension(100, 20));
        
        size.gridx = 0;
        size.gridy = 0;
        size.insets = new Insets(0, 0, 10, 10);
        panel1.add(b1, size);
        
        size.gridx = 1;
        size.gridy = 0;
        // Add some horizontal spacing between b1 and b2
        size.insets = new Insets(0, 10, 10, 0);
        panel1.add(b2, size);
        
        size.gridx = 0;
        size.gridy = 1;
        // Add some vertical spacing between b1 and b2
        size.insets = new Insets(10, 0, 0, 10);
        panel1.add(b3, size);

        size.gridx = 1;
        size.gridy = 1;
        // Add some vertical spacing and horizontal spacing between b3 and b4
        size.insets = new Insets(10, 10, 0, 0);
        panel1.add(b4, size);

        frame1.add(panel1);
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.setSize(400, 400);
        frame1.setVisible(true);
    }
}