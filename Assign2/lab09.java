package Assign2;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class lab09 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Java TextArea");
        JPanel mainPanel = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();

        JLabel controlAction = new JLabel("Control in action: TextArea");
        JLabel comment = new JLabel("Comments: ");

        JTextArea area = new JTextArea();
        JButton button = new JButton("Show");

        area.setPreferredSize(new Dimension(200, 100));

        JScrollPane scrollPane = new JScrollPane(area);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.insets = new Insets(0, 0, 50, 0);
        constraints.gridwidth = 3; // This will span the label across all three columns
        constraints.anchor = GridBagConstraints.CENTER;
        // constraints.fill = GridBagConstraints.HORIZONTAL;
        mainPanel.add(controlAction,constraints);

        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.gridwidth = 1; // Reset the gridwidth to its default value
        constraints.insets = new Insets(0,0,0,10);
        mainPanel.add(comment,constraints);

        constraints.gridx = 1;
        constraints.gridy = 1;
        constraints.insets = new Insets(0,0,0,10);
        mainPanel.add(scrollPane,constraints);

        constraints.gridx = 2;
        constraints.gridy = 1;
        mainPanel.add(button,constraints);

        frame.add(mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 600);
        frame.setVisible(true);
    }
}
