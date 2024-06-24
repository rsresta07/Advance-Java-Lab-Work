package Assign2;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
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

public class Calculator {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Calculator");
        JPanel mainPanel = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();

        JLabel fNum = new JLabel("First Number");
        // fNum.setHorizontalAlignment(JLabel.LEFT);
        JLabel sNum = new JLabel("Second Number");
        // sNum.setHorizontalAlignment(JLabel.LEFT);
        JLabel result = new JLabel("Result");
        // result.setHorizontalAlignment(JLabel.LEFT);

        JTextField resValue = new JTextField(); // No initial value
        resValue.setEditable(false); // Make the JTextField uneditable
        JButton bAdd = new JButton("+");
        JButton bSub = new JButton("-");

        // Create a NumberFormat instance
        NumberFormat numberFormat = NumberFormat.getNumberInstance();
        // Create a JFormattedTextField with the NumberFormat
        JFormattedTextField value1 = new JFormattedTextField(numberFormat);
        value1.setValue(null); // Set initial value
        JFormattedTextField value2 = new JFormattedTextField(numberFormat);
        value2.setValue(null);

        // Set the preferred size of the formattedTextField and Buttons
        value1.setPreferredSize(new Dimension(150, 30));
        value2.setPreferredSize(new Dimension(150, 30));
        bAdd.setPreferredSize(new Dimension(150, 30));
        bSub.setPreferredSize(new Dimension(150, 30));
        resValue.setPreferredSize(new Dimension(150, 30));

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
        mainPanel.add(fNum, constraints);

        constraints.gridx = 1;
        constraints.gridy = 0;
        constraints.anchor = GridBagConstraints.LINE_START;
        mainPanel.add(value1, constraints);

        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.anchor = GridBagConstraints.LINE_START;
        mainPanel.add(sNum, constraints);

        constraints.gridx = 1;
        constraints.gridy = 1;
        constraints.anchor = GridBagConstraints.LINE_START;
        mainPanel.add(value2, constraints);

        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.anchor = GridBagConstraints.LINE_START;
        mainPanel.add(result, constraints);

        constraints.gridx = 1;
        constraints.gridy = 2;
        constraints.anchor = GridBagConstraints.LINE_START;
        mainPanel.add(resValue, constraints);

        constraints.gridx = 0;
        constraints.gridy = 3;
        constraints.anchor = GridBagConstraints.LINE_START;
        mainPanel.add(bAdd, constraints);

        constraints.gridx = 1;
        constraints.gridy = 3;
        constraints.anchor = GridBagConstraints.LINE_START;
        mainPanel.add(bSub, constraints);

        frame.add(mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // frame.setSize(600, 600);
        frame.pack();
        frame.setVisible(true);
    }
}