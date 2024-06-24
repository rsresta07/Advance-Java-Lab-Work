package Assign2;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class lab05 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("List Demo");
        JPanel mainPanel = new JPanel();
        
        JLabel lb1 = new JLabel("Choose the planet ");

        String planetName[] = { "Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Neptune", "Uranus",
                "Pluto" };
        JList<String> list = new JList<String>(planetName);
        JScrollPane scrollPane = new JScrollPane(list); // Wrap the JList in a JScrollPane

        // Set the preferred size of the scroll pane
        scrollPane.setPreferredSize(new Dimension(100, 75));

        mainPanel.add(lb1);
        mainPanel.add(scrollPane);

        frame.add(mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 300);
        frame.setVisible(true);
    }
}