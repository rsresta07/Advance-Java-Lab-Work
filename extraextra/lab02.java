package extraextra;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class lab02 extends JPanel {

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.GREEN);
        g.drawLine(10, 10, 100, 100);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Green Line");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.add(new lab02());
        frame.setVisible(true);
    }
}