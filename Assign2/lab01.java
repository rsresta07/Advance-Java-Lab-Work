package Assign2;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class lab01 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Label Demo");
        JPanel panel = new JPanel(new GridLayout(3, 2));

        JLabel name = new JLabel("Name");
        JLabel addr = new JLabel("Address");
        JTextField nameField = new JTextField(5);
        JTextField addrField = new JTextField(5);
        JButton button = new JButton("OK");
        JButton button2 = new JButton("Cancel");

        name.setText("Full Name");
        name.setHorizontalAlignment(0);
        addr.setHorizontalAlignment(0);

        panel.add(name);
        panel.add(nameField);
        panel.add(addr);
        panel.add(addrField);
        panel.add(button);
        panel.add(button2);
        frame.add(panel);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 150);
        frame.setVisible(true);
    }
}
