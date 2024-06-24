package Assign3;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class lab02 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Counter");
        JPanel mainPanel = new JPanel();

        JLabel lb1 = new JLabel("Count:");
        JTextField tf1 = new JTextField("0", 10);
        JButton bt1 = new JButton("Up");
        JButton bt2 = new JButton("Down");
        JButton bt3 = new JButton("Reset");

        mainPanel.add(lb1);
        mainPanel.add(tf1);
        mainPanel.add(bt1);
        mainPanel.add(bt2);
        mainPanel.add(bt3);

        bt1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // this long method is used for understanding the code
                // otherwise the part from bt2(ActionListener) can be written in the lab report
                String text1 = tf1.getText();
                int count = Integer.parseInt(text1);
                String text2 = String.valueOf(count + 1);
                tf1.setText(text2);
            }
        });

        bt2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int count = Integer.parseInt(tf1.getText());
                tf1.setText(String.valueOf(count - 1));
            }
        });

        bt3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tf1.setText("0");
            }
        });

        frame.add(mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);
        frame.setVisible(true);
    }
}
