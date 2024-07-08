package Assign4;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.*;

import java.awt.GridLayout;

public class lab05 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Find the Largest Number");
        JPanel mainPanel = new JPanel(new GridLayout(0, 1));
        JPanel operationPanel = new JPanel(new GridLayout(3, 2));

        JLabel label1 = new JLabel("Find the largest number:");
        JTextField numValue1 = new JTextField(5);
        JTextField numValue2 = new JTextField(5);
        JButton check = new JButton("Check");
        JLabel result = new JLabel("", SwingConstants.CENTER);

        check.addActionListener(e -> {
            try {
                int num1 = Integer.parseInt(numValue1.getText());
                int num2 = Integer.parseInt(numValue2.getText());
                if (num1 > num2) {
                    result.setText(num1 + " is largest");
                } else if (num1 < num2) {
                    result.setText(num2 + " is largest");
                } else {
                    result.setText("Both are equal");
                }
            } catch (NumberFormatException ex) {
                result.setText("Invalid input");
            }
        });

        operationPanel.add(new JLabel("First Number"));
        operationPanel.add(numValue1);
        operationPanel.add(new JLabel("Second Number"));
        operationPanel.add(numValue2);
        operationPanel.add(check);

        mainPanel.add(label1);
        mainPanel.add(operationPanel);
        mainPanel.add(result);

        frame.add(mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.setVisible(true);
    }
}