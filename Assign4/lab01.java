package Assign4;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class lab01 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Prime Number Test");
        JPanel mainPanel = new JPanel(new GridLayout(0, 1));
        JPanel panel1 = new JPanel(new GridLayout(2, 2));

        JLabel num = new JLabel("Number");
        JLabel prime = new JLabel("Prime");
        JTextField numValue = new JTextField("");
        JTextField primeValue = new JTextField("");
        primeValue.setEditable(false);
        JButton check = new JButton("Check");

        PrimeButtonListener listener = new PrimeButtonListener(numValue, primeValue);
        check.addActionListener(listener);

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
}

class PrimeButtonListener implements ActionListener {
    private JTextField value;
    private JTextField result;

    public PrimeButtonListener(JTextField value, JTextField result) {
        this.value = value;
        this.result = result;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int num = Integer.parseInt(value.getText());
        result.setText(isPrime(num) ? "Yes" : "No");
    }

    private boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
