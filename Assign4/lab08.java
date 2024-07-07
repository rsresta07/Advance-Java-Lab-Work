package Assign4;

import java.awt.GridLayout;
import java.util.ArrayList;

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

        JLabel label = new JLabel("Food Ordering System");

        ArrayList<JCheckBox> check = new ArrayList<>();
        check.add(new JCheckBox("Momo"));
        check.add(new JCheckBox("Pizza"));
        check.add(new JCheckBox("Chowmein"));
        check.add(new JCheckBox("Fry Rice"));

        JButton submitBtn = new JButton("Submit");
        JLabel order = new JLabel();

        submitBtn.addActionListener(e -> {
            int count = 0;
            String ans = "";

            for (JCheckBox jCheckBox : check) {
                if (jCheckBox.isSelected()) {
                    count++;
                    ans += jCheckBox.getText() + " ";
                }
            }
            order.setText(String.format("You have selected %d items they are %s", count, ans));
        });

        label.setHorizontalAlignment(SwingConstants.CENTER);
        order.setHorizontalAlignment(SwingConstants.CENTER);
        
        panel.add(check.get(0));
        panel.add(check.get(1));
        panel.add(check.get(2));
        panel.add(check.get(3));
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
