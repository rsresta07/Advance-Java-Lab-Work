package Assign2;

import java.awt.GridLayout;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class lab03 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("CheckBox Demo");
        JPanel panel = new JPanel(new GridLayout(0, 1));

        JLabel choose = new JLabel("Choose program to enroll");
        JCheckBox cb1 = new JCheckBox("C");
        JCheckBox cb2 = new JCheckBox("Java");
        JCheckBox cb3 = new JCheckBox("HTML");
        JCheckBox cb4 = new JCheckBox("PHP");

        JLabel lbl = new JLabel("Payment");
        JRadioButton rb1 = new JRadioButton("Now");
        JRadioButton rb2 = new JRadioButton("Later");
        ButtonGroup group = new ButtonGroup();
        group.add(rb1);
        group.add(rb2);

        panel.add(choose);
        panel.add(cb1);
        panel.add(cb2);
        panel.add(cb3);
        panel.add(cb4);
        panel.add(lbl);
        panel.add(rb1);
        panel.add(rb2);

        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 500);
        frame.setVisible(true);
    }
}
