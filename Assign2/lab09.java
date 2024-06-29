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
        GridBagConstraints constr = new GridBagConstraints();

        JLabel controlAction = new JLabel("Control in action: TextArea");
        JLabel comment = new JLabel("Comments: ");

        JTextArea area = new JTextArea();
        JButton button = new JButton("Show");

        area.setPreferredSize(new Dimension(200, 100));

        JScrollPane scrollPane = new JScrollPane(area);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

        constr.gridx = 0;
        constr.gridy = 0;
        constr.insets = new Insets(0, 0, 50, 0);
        constr.gridwidth = 3; // This will span the label across all three columns
        constr.anchor = GridBagConstraints.CENTER;
        mainPanel.add(controlAction, constr);

        constr.gridx = 0;
        constr.gridy = 1;
        constr.gridwidth = 1; // Reset the gridwidth to its default value
        constr.insets = new Insets(0, 0, 0, 10);
        mainPanel.add(comment, constr);

        constr.gridx = 1;
        constr.gridy = 1;
        mainPanel.add(scrollPane, constr);

        constr.gridx = 2;
        constr.gridy = 1;
        mainPanel.add(button, constr);

        frame.add(mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 600);
        frame.setVisible(true);
    }
}
