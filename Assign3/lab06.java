package Assign3;

import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class lab06 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Calculator");
        JPanel mainPanel = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();

        JLabel fNum = new JLabel("Number 1");
        JLabel sNum = new JLabel("Number 2");
        JLabel result = new JLabel("Result");

        // Create formatted text fields for numeric input
        JTextField value1 = new JTextField(10);
        JTextField value2 = new JTextField(10);
        JTextField resValue = new JTextField(10);
        resValue.setEditable(false); // Make the result field uneditable

        // Create buttons for operations
        JButton bAdd = new JButton("+");
        JButton bSub = new JButton("-");
        JButton bMul = new JButton("*");
        JButton bDiv = new JButton("/");

        // ActionListener for operation buttons
        ActionListener operationListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double num1 = Double.parseDouble(value1.getText());
                double num2 = Double.parseDouble(value2.getText());
                double res = 0;

                if (e.getSource() == bAdd) {
                    res = num1 + num2;
                } else if (e.getSource() == bSub) {
                    res = num1 - num2;
                } else if (e.getSource() == bMul) {
                    res = num1 * num2;
                } else if (e.getSource() == bDiv) {
                    if (num2 != 0) {
                        res = num1 / num2;
                    } else {
                        resValue.setText("Error: Division by zero");
                        return;
                    }
                }
                resValue.setText(String.valueOf(res));
            }
        };

        // Add action listeners to operation buttons
        bAdd.addActionListener(operationListener);
        bSub.addActionListener(operationListener);
        bMul.addActionListener(operationListener);
        bDiv.addActionListener(operationListener);

        // KeyListener to clear result field when number fields are edited
        KeyAdapter clearResultListener = new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                resValue.setText("");
            }
        };

        value1.addKeyListener(clearResultListener);
        value2.addKeyListener(clearResultListener);

        // Add components to main panel using GridBagConstraints
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.anchor = GridBagConstraints.LINE_END;
        constraints.insets = new Insets(0, 0, 5, 10);
        mainPanel.add(fNum, constraints);

        constraints.gridx = 1;
        constraints.gridy = 0;
        constraints.anchor = GridBagConstraints.LINE_START;
        mainPanel.add(value1, constraints);

        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.anchor = GridBagConstraints.LINE_END;
        mainPanel.add(sNum, constraints);

        constraints.gridx = 1;
        constraints.gridy = 1;
        constraints.anchor = GridBagConstraints.LINE_START;
        mainPanel.add(value2, constraints);

        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.anchor = GridBagConstraints.LINE_END;
        mainPanel.add(result, constraints);

        constraints.gridx = 1;
        constraints.gridy = 2;
        constraints.anchor = GridBagConstraints.LINE_START;
        mainPanel.add(resValue, constraints);

        // Create panel for operation buttons
        JPanel operationPanel = new JPanel(new FlowLayout());
        operationPanel.add(bAdd);
        operationPanel.add(bSub);
        operationPanel.add(bMul);
        operationPanel.add(bDiv);

        // Add operation panel to main panel
        constraints.gridx = 0;
        constraints.gridy = 3;
        constraints.gridwidth = 2;
        constraints.anchor = GridBagConstraints.CENTER;
        constraints.insets = new Insets(10, 0, 0, 0);
        mainPanel.add(operationPanel, constraints);

        frame.add(mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 250);
        frame.setVisible(true);
    }
}