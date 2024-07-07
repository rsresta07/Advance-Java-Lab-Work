package Assign3;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class lab09 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Key Event");
        JPanel mainPanel = new JPanel();

        JLabel lb1 = new JLabel("Enter text");
        JTextField text = new JTextField(10);
        JLabel lb2 = new JLabel();

        text.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                lb2.setText(text.getText());
            }
        });

        mainPanel.add(lb1);
        mainPanel.add(text);
        mainPanel.add(lb2);

        frame.add(mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);
        frame.setVisible(true);
    }
}
