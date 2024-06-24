package Assign3;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class lab07 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Factorial");
        JPanel mainPanel = new JPanel();

        JLabel num = new JLabel("Number");
        JTextField numValue = new JTextField(10);
        JButton calcu = new JButton("Calculate");
        JLabel fact = new JLabel("Factorial");
        JTextField factValue = new JTextField(10);

        calcu.setPreferredSize(new Dimension(90, 20));

        calcu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                float result = 1;
                Float n = Float.parseFloat(numValue.getText());
                for (int i = 1; i <= n; i++) {
                    result *= i;
                }
                factValue.setText(String.valueOf(result));
            }
        });

        mainPanel.add(num);
        mainPanel.add(numValue);
        mainPanel.add(calcu);
        mainPanel.add(fact);
        mainPanel.add(factValue);

        frame.add(mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 200);
        frame.setVisible(true);
    }
}
