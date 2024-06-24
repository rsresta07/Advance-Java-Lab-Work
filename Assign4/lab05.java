package Assign4;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class lab05 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("JTextField");
        JPanel mainPanel = new JPanel(new FlowLayout());

        JLabel label1 = new JLabel("Find the largest One");
        JLabel num1 = new JLabel("First Number");
        JLabel num2 = new JLabel("Second Number");
        JTextField numValue1 = new JTextField(5);
        JTextField numValue2 = new JTextField(5);
        JButton check = new JButton("Check");
        JLabel result = new JLabel();

        LargestButtonListener listener = new LargestButtonListener(numValue1, numValue2, result);
        check.addActionListener(listener);

        mainPanel.add(label1);
        mainPanel.add(num1);
        mainPanel.add(numValue1);
        mainPanel.add(num2);
        mainPanel.add(numValue2);
        mainPanel.add(check);
        mainPanel.add(result);

        frame.add(mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 200);
        frame.setVisible(true);
    }
}

class LargestButtonListener implements ActionListener {
    private JTextField value1;
    private JTextField value2;
    private JLabel result;

    public LargestButtonListener(JTextField value1, JTextField value2, JLabel result) {
        this.value1 = value1;
        this.value2 = value2;
        this.result = result;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int num1 = Integer.parseInt(value1.getText());
        int num2 = Integer.parseInt(value2.getText());
        if (num1 > num2) {
            result.setText(num1 + " is largest");
        } else if (num1 < num2) {
            result.setText(num2 + " is largest");
        } else {
            result.setText("Both are equal");
        }
    }
}