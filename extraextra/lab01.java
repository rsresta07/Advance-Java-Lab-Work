package extraextra;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class lab01 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Display Name");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel label = new JLabel("Rameshwor Shrestha");
        frame.add(label);

        frame.setSize(300, 200);
        frame.setVisible(true);
    }
}