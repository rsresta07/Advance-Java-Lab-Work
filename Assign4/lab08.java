package Assign4;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class lab08 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Rameshwor");
        JPanel mainPanel = new JPanel(new GridLayout(0, 1));
        JPanel panel = new JPanel(new GridLayout(3, 2));

        JLabel label = new JLabel("Food Ordering System", SwingConstants.CENTER);
        JLabel order = new JLabel("", SwingConstants.CENTER);

        String[] items = { "Momo", "Pizza", "Chowmein", "Fry Rice" };
        JCheckBox[] checkboxes = new JCheckBox[items.length];
        for (int i = 0; i < items.length; i++) {
            checkboxes[i] = new JCheckBox(items[i]);
            panel.add(checkboxes[i]);
        }

        JButton submitBtn = new JButton("Submit");
        submitBtn.addActionListener(e -> {
            int count = 0;
            StringBuilder selectedItems = new StringBuilder();
            for (JCheckBox checkbox : checkboxes) {
                if (checkbox.isSelected()) {
                    count++;
                    selectedItems.append(checkbox.getText()).append(" ");
                }
            }
            order.setText(String.format("You have selected %d items. They are %s", count, selectedItems.toString()));
        });

        panel.add(submitBtn);

        mainPanel.add(label);
        mainPanel.add(panel);
        mainPanel.add(order);

        frame.add(mainPanel);
        frame.setSize(450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
