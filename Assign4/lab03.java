package Assign4;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class lab03 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Armstrong Checker");
        JPanel mainPanel = new JPanel(new FlowLayout());

        JLabel num = new JLabel("Number");
        JTextField numValue = new JTextField(5);
        JButton check = new JButton("Check");
        JLabel result = new JLabel();

        ArmstrongButtonListener listener = new ArmstrongButtonListener(numValue, result);
        check.addActionListener(listener);

        mainPanel.add(num);
        mainPanel.add(numValue);
        mainPanel.add(check);
        mainPanel.add(result);

        frame.add(mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 200);
        frame.setVisible(true);
    }
}

class ArmstrongButtonListener implements ActionListener {
    private JTextField value;
    private JLabel result;

    public ArmstrongButtonListener(JTextField value, JLabel result) {
        this.value = value;
        this.result = result;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int num = Integer.parseInt(value.getText());
        if (isArmstrong(num)) {
            result.setText("It is Armstrong");
        } else {
            result.setText("It is not Armstrong");
        }
    }

    private boolean isArmstrong(int number) {
        int originalNumber = number;
        int sum = 0;
        int digits = String.valueOf(number).length();

        while (number != 0) {
            int digit = number % 10;
            sum += Math.pow(digit, digits);
            number /= 10;
        }

        return sum == originalNumber;
    }
}
