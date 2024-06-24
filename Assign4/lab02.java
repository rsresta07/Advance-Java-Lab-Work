package Assign4;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class lab02 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Reverse Number");
        JPanel mainPanel = new JPanel(new GridLayout(0, 1));
        JPanel panel1 = new JPanel(new GridLayout(2, 2));

        JLabel num = new JLabel("Number");
        JLabel reverse = new JLabel("Reverse");
        JTextField numValue = new JTextField();
        JTextField reverseValue = new JTextField();
        reverseValue.setEditable(false);
        JButton check = new JButton("Reverse");

        ReverseButtonListener listener = new ReverseButtonListener(numValue, reverseValue);
        check.addActionListener(listener);

        panel1.add(num);
        panel1.add(numValue);
        panel1.add(reverse);
        panel1.add(reverseValue);
        mainPanel.add(panel1);
        mainPanel.add(check);

        frame.add(mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);
        frame.setVisible(true);
    }
}

class ReverseButtonListener implements ActionListener {
    private JTextField num;
    private JTextField result;

    public ReverseButtonListener(JTextField num, JTextField result) {
        this.num = num;
        this.result = result;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            int number = Integer.parseInt(num.getText());
            int reversedNumber = reverseNumber(number);
            result.setText(String.valueOf(reversedNumber));
        } catch (NumberFormatException ex) {
            result.setText("Invalid input");
        }
    }

    private int reverseNumber(int number) {
        int reversed = 0;
        while (number != 0) {
            int digit = number % 10;
            reversed = reversed * 10 + digit;
            number /= 10;
        }
        return reversed;
    }
}
