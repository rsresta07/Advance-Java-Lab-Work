package extraextra;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class lab03 extends JPanel {

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.RED);
        g.drawOval(10, 10, 200, 150);
        g.setColor(Color.YELLOW);
        g.fillOval(10, 10, 200, 150);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Green Line");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.add(new lab03());
        frame.setVisible(true);
    }
}