package Assign4;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;

public class lab03 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Armstrong Checker");
        JPanel mainPanel = new JPanel(new FlowLayout());

        JLabel num = new JLabel("Number");
        JTextField numValue = new JTextField(5);
        JButton check = new JButton("Check");
        JLabel result = new JLabel();

        check.addActionListener((ActionEvent e) -> {
            int number = Integer.parseInt(numValue.getText());
            result.setText(isArmstrong(number) ? "It is Armstrong" : "It is not Armstrong");
        });

        mainPanel.add(num);
        mainPanel.add(numValue);
        mainPanel.add(check);
        mainPanel.add(result);

        frame.add(mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 200);
        frame.setVisible(true);
    }

    private static boolean isArmstrong(int number) {
        int originalNumber = number, sum = 0, digits = String.valueOf(number).length();
        while (number != 0) {
            int digit = number % 10;
            sum += Math.pow(digit, digits);
            number /= 10;
        }
        return sum == originalNumber;
    }
}