package Assign2;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.plaf.DimensionUIResource;

public class lab07 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Scrollbar Demo");
        JPanel mainPanel = new JPanel();

        // Create a large panel with components to demonstrate scrolling
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
        for (int i = 1; i <= 10; i++) {
            JLabel label = new JLabel("This is Label 0" + i);
            contentPanel.add(label);
        }

        // Wrap the content panel in a JScrollPane
        JScrollPane scrollPane = new JScrollPane(contentPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPane.setPreferredSize(new DimensionUIResource(100, 150));

        mainPanel.add(scrollPane);
        frame.add(mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setVisible(true);
    }
}