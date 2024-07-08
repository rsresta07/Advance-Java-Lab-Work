package Assign3;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class lab05 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Rameshwor");
        JPanel mainPanel = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();

        JLabel num1 = new JLabel("Number 1");
        JLabel num2 = new JLabel("Number 2");
        JTextField field1 = new JTextField();
        JTextField field2 = new JTextField();
        JButton button1 = new JButton("Swap");

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String temp = field1.getText();
                field1.setText(field2.getText());
                field2.setText(temp);
            }
        });


        num1.setPreferredSize(new Dimension(100,20));
        num2.setPreferredSize(new Dimension(100,20));
        button1.setPreferredSize(new Dimension(100,20));
        field1.setPreferredSize(new Dimension(100,20));
        field2.setPreferredSize(new Dimension(100,20));

        constraints.gridx = 0;
        constraints.gridy = 0;
        mainPanel.add(num1, constraints);

        constraints.gridx = 1;
        constraints.gridy = 0;
        mainPanel.add(field1, constraints);

        constraints.gridx = 0;
        constraints.gridy = 1;
        mainPanel.add(num2, constraints);

        constraints.gridx = 1;
        constraints.gridy = 1;
        mainPanel.add(field2, constraints);

        constraints.gridx = 0;
        constraints.gridy = 2;
        mainPanel.add(button1, constraints);

        frame.add(mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // frame.pack();
        frame.setSize(300, 200);
        frame.setVisible(true);
    }
}
