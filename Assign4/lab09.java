package Assign4;

import java.awt.GridLayout;
import java.util.ArrayList;

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

        JLabel payLabel = new JLabel("Choose your Payment");
        JLabel resultLabel = new JLabel();;

        ArrayList<JRadioButton> btn = new ArrayList<>();
        btn.add(new JRadioButton("Credit Card"));
        btn.add(new JRadioButton("Wallet"));
        btn.add(new JRadioButton("Bank Transfer"));
        btn.add(new JRadioButton("Cash on Delivery"));

        ButtonGroup btnGroup = new ButtonGroup();
        btnGroup.add(btn.get(0));
        btnGroup.add(btn.get(1));
        btnGroup.add(btn.get(2));
        btnGroup.add(btn.get(3));

        JButton okBtn = new JButton("Ok");

        okBtn.addActionListener(e -> {
            String ans = "";

            for (JRadioButton jRadioButton : btn) {
                if (jRadioButton.isSelected()) {
                    ans = jRadioButton.getText();
                }
            }
            resultLabel.setText(String.format("You have selected %s", ans));
        });

        payLabel.setHorizontalAlignment(SwingConstants.CENTER);
        resultLabel.setHorizontalAlignment(SwingConstants.CENTER);
        
        mainPanel.add(payLabel);

        panel.add(btn.get(0));
        panel.add(btn.get(1));
        panel.add(btn.get(2));
        panel.add(btn.get(3));
        panel.add(okBtn);

        mainPanel.add(panel);
        mainPanel.add(resultLabel);
        
        frame.add(mainPanel);
        frame.setSize(300, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
