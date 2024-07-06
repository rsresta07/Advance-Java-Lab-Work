package ClassTestCode;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class JTextJArea {
    public static void main(String[] args) {
        JFrame frame = new JFrame("JTextField Example");
        JPanel panel = new JPanel();
        JLabel label1 = new JLabel("Name");
        JLabel label2 = new JLabel("Address");
        JTextField textField = new JTextField(20);
        JTextArea area = new JTextArea(5, 20);

        panel.add(label1);
        panel.add(textField);
        panel.add(label2);
        panel.add(area);
        frame.add(panel);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
