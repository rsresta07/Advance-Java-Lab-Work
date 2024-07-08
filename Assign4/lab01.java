package Assign4;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.GridLayout;

public class lab01 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Prime Number Test");
        JPanel mainPanel = new JPanel(new GridLayout(0, 1));
        JPanel panel1 = new JPanel(new GridLayout(2, 2));

        JLabel num = new JLabel("Number");
        JLabel prime = new JLabel("Prime");
        JTextField numValue = new JTextField();
        JTextField primeValue = new JTextField();
        primeValue.setEditable(false);
        JButton check = new JButton("Check");

        check.addActionListener(e -> {
            try {
                int number = Integer.parseInt(numValue.getText());
                primeValue.setText(isPrime(number) ? "Yes" : "No");
            } catch (NumberFormatException ex) {
                primeValue.setText("Invalid input");
            }
        });

        panel1.add(num);
        panel1.add(numValue);
        panel1.add(prime);
        panel1.add(primeValue);
        mainPanel.add(panel1);
        mainPanel.add(check);

        frame.add(mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);
        frame.setVisible(true);
    }

    private static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}