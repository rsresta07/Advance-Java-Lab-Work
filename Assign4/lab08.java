package Assign4;

import java.awt.GridLayout;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class lab08 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Food Order");
        JPanel mainPanel = new JPanel(new GridLayout(0, 1));
        JPanel optionPanel = new JPanel(new GridLayout(3, 2));

        JLabel lb1 = new JLabel("Food Ordering System");

        ArrayList<JCheckBox> check = new ArrayList<JCheckBox>();
        check.add(new JCheckBox("Chowmein"));
        check.add(new JCheckBox("momo"));
        check.add(new JCheckBox("pizza"));
        check.add(new JCheckBox("fryRice"));

        JButton submit = new JButton("Submit");
        JLabel order = new JLabel("order");

        lb1.setHorizontalAlignment(SwingConstants.CENTER);
        order.setHorizontalAlignment(SwingConstants.CENTER);

        submit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int count = 0;
                String ans = null;

                for (JCheckBox jCheckBox : check) {
                    if (jCheckBox.isSelected()) {
                        count++;
                        ans = jCheckBox.getText() + " ";
                    }
                }

                order.setText(String.format("You have selected %d items they are %s", count, ans));

            }
        });

        mainPanel.add(lb1);
        mainPanel.add(optionPanel);
        mainPanel.add(order);

        optionPanel.add(check.get(0));
        optionPanel.add(check.get(1));
        optionPanel.add(check.get(2));
        optionPanel.add(check.get(3));

        optionPanel.add(submit);

        frame.add(mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(350, 350);
        frame.setVisible(true);
    }

}
