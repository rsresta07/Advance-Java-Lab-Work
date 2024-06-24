package Assign3;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.NumberFormat;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class lab06 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Calculator");
        // JPanel mainPanel = new JPanel(new GridLayout(2,1));

        JPanel mainPanel = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();

        JPanel panel2 = new JPanel(new FlowLayout());

        JLabel fNum = new JLabel("Number 1");
        JLabel sNum = new JLabel("Number 2");
        JLabel result = new JLabel("Result");

        // Create a NumberFormat instance
        NumberFormat numberFormat = NumberFormat.getNumberInstance();

        // Create a JFormattedTextField with the NumberFormat
        JFormattedTextField value1 = new JFormattedTextField(numberFormat);
        JFormattedTextField value2 = new JFormattedTextField(numberFormat);

        JTextField resValue = new JTextField();
        resValue.setEditable(false); // Make the JTextField uneditable

        JButton bAdd = new JButton("+");
        JButton bSub = new JButton("-");
        JButton bMul = new JButton("*");
        JButton bDiv = new JButton("/");

        // Set the preferred size of the formattedTextField and Buttons
        value1.setPreferredSize(new Dimension(150, 30));
        value2.setPreferredSize(new Dimension(150, 30));
        resValue.setPreferredSize(new Dimension(150, 30));
        bAdd.setPreferredSize(new Dimension(50, 30));
        bSub.setPreferredSize(new Dimension(50, 30));
        bMul.setPreferredSize(new Dimension(50, 30));
        bDiv.setPreferredSize(new Dimension(50, 30));

        // ActionListener for Buttons
        bAdd.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                double num1 = Double.parseDouble(value1.getText());
                double num2 = Double.parseDouble(value2.getText());
                double res = num1 + num2;
                resValue.setText(String.valueOf(res));
            }
        });

        bSub.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                double num1 = Double.parseDouble(value1.getText());
                double num2 = Double.parseDouble(value2.getText());
                double res = num1 - num2;
                resValue.setText(String.valueOf(res));
            }
        });

        bMul.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                double num1 = Double.parseDouble(value1.getText());
                double num2 = Double.parseDouble(value2.getText());
                double res = num1 * num2;
                resValue.setText(String.valueOf(res));
            }
        });

        bDiv.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                double num1 = Double.parseDouble(value1.getText());
                double num2 = Double.parseDouble(value2.getText());
                double res = num1 / num2;
                resValue.setText(String.valueOf(res));
            }
        });

        value1.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                resValue.setText("");
            }
        });

        value2.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                resValue.setText("");
            }
        });

        // Adding components to the main panel using GridBagConstraints
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.anchor = GridBagConstraints.LINE_START;
        constraints.insets = new Insets(0, 0, 5, 20);
        mainPanel.add(fNum, constraints);

        constraints.gridx = 1;
        constraints.gridy = 0;
        constraints.anchor = GridBagConstraints.LINE_START;
        constraints.insets = new Insets(0, 10, 5, 0);
        mainPanel.add(value1, constraints);

        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.anchor = GridBagConstraints.LINE_START;
        constraints.insets = new Insets(0, 0, 5, 20);
        mainPanel.add(sNum, constraints);

        constraints.gridx = 1;
        constraints.gridy = 1;
        constraints.anchor = GridBagConstraints.LINE_START;
        constraints.insets = new Insets(0, 10, 5, 0);
        mainPanel.add(value2, constraints);

        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.anchor = GridBagConstraints.LINE_START;
        constraints.insets = new Insets(0, 0, 0, 20);
        mainPanel.add(result, constraints);

        constraints.gridx = 1;
        constraints.gridy = 2;
        constraints.anchor = GridBagConstraints.LINE_START;
        constraints.insets = new Insets(0, 10, 0, 0);
        mainPanel.add(resValue, constraints);

        // adding buttons in panel2
        panel2.add(bAdd);
        panel2.add(bSub);
        panel2.add(bMul);
        panel2.add(bDiv);

        // Center align panel2 within mainPanel
        GridBagConstraints panel2Constraints = new GridBagConstraints();
        panel2Constraints.gridx = 0;
        panel2Constraints.gridy = 3;
        panel2Constraints.gridwidth = 2;
        panel2Constraints.anchor = GridBagConstraints.CENTER; // Center align panel2
        panel2Constraints.insets = new Insets(10, 0, 0, 0); // Adjust top inset
        mainPanel.add(panel2, panel2Constraints);

        frame.add(mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setVisible(true);
    }
}