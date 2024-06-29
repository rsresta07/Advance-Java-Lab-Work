package Assign2;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

public class lab10Box {
    public static void main(String[] args) {
        JFrame frame = new JFrame("BoxLayout Demo");
        BoxLayout boxLayout = new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS);
        frame.setLayout(boxLayout);

        for (int i = 1; i <= 5; i++) {
            frame.add(new JButton("Button " + i));
        }

        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}