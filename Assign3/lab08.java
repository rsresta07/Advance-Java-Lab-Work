package Assign3;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class lab08 {
    private static final double USD_TO_NPR = 132.00;
    private static final double USD_TO_EUR = 0.90;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Currency Convertor");
        JPanel mainPanel = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();

        JLabel dollar = new JLabel("Dollar");
        JLabel nepalese = new JLabel("Nepalese");
        JLabel euro = new JLabel("Euro");

        JTextField dollarField = new JTextField(10);
        JTextField nepaleseField = new JTextField(10);
        JTextField euroField = new JTextField(10);

        // KeyListener for the dollar field to convert the other currency
        dollarField.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                String text = dollarField.getText(); // Taking the value of dollar
                if (!text.isEmpty()) {
                    double amt = Double.parseDouble(text); // As the value is string, converting it to double
                    // Calculating the value of nepalese currency and converting it to String
                    String nep = String.format("%.2f", amt * USD_TO_NPR);
                    nepaleseField.setText(nep);
                    // We did the same thing here but directly
                    euroField.setText(String.format("%.2f", amt * USD_TO_EUR));
                } else {
                    // If text is empty, keep the textfield unchanged
                    nepaleseField.setText("");
                    euroField.setText("");
                }
            }

        });

        nepaleseField.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                String text = nepaleseField.getText();
                if (!text.isEmpty()) {
                    double amt = Double.parseDouble(text);
                    dollarField.setText(String.format("%.2f", amt / USD_TO_NPR));
                    euroField.setText(String.format("%.2f", (amt / USD_TO_NPR) * USD_TO_EUR));
                } else {
                    dollarField.setText("");
                    euroField.setText("");
                }
            }

        });

        euroField.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                String text = euroField.getText();
                if (!text.isEmpty()) {
                    double amt = Double.parseDouble(text);
                    dollarField.setText(String.format("%.2f", amt / USD_TO_EUR));
                    nepaleseField.setText(String.format("%.2f", (amt / USD_TO_EUR) * USD_TO_NPR));
                } else {
                    dollarField.setText("");
                    nepaleseField.setText("");
                }
            }

        });

        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.anchor = GridBagConstraints.LINE_END;
        mainPanel.add(dollar, constraints);

        constraints.gridx = 1;
        constraints.gridy = 0;
        mainPanel.add(dollarField, constraints);

        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.anchor = GridBagConstraints.LINE_END;
        mainPanel.add(nepalese, constraints);

        constraints.gridx = 1;
        constraints.gridy = 1;
        mainPanel.add(nepaleseField, constraints);

        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.anchor = GridBagConstraints.LINE_END;
        mainPanel.add(euro, constraints);

        constraints.gridx = 1;
        constraints.gridy = 2;
        mainPanel.add(euroField, constraints);

        frame.add(mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 300);
        frame.setVisible(true);
    }
}
