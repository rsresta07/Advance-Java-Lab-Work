package Assign4;

import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;

public class lab09 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Rameshwor");
        JPanel mainPanel = new JPanel(new GridLayout(0, 1));
        JPanel panel = new JPanel(new GridLayout(3, 2));

        JLabel payLabel = new JLabel("Choose your Payment", SwingConstants.CENTER);
        JLabel resultLabel = new JLabel("", SwingConstants.CENTER);

        // Create an array of payment options
        String[] options = { "Credit Card", "Wallet", "Bank Transfer", "Cash on Delivery" };
        // Create a new ButtonGroup for the radio buttons
        ButtonGroup btnGroup = new ButtonGroup();
        // Create an array of JRadioButton for the payment options
        JRadioButton[] btns = new JRadioButton[options.length];

        // Add the payment options to the panel and the ButtonGroup
        for (int i = 0; i < options.length; i++) {
            btns[i] = new JRadioButton(options[i]);
            btnGroup.add(btns[i]);
            panel.add(btns[i]);
        }

        /*
         * Create a new JButton with the label "Ok"
         * Add an action listener to the "Ok" button to display the selected payment
         * option
         */
        JButton okBtn = new JButton("Ok");
        okBtn.addActionListener(e -> {
            for (JRadioButton btn : btns) {
                if (btn.isSelected()) {
                    resultLabel.setText("You have selected " + btn.getText());
                    break;
                }
            }
        });

        panel.add(okBtn);
        mainPanel.add(payLabel);
        mainPanel.add(panel);
        mainPanel.add(resultLabel);

        frame.add(mainPanel);
        frame.setSize(300, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}