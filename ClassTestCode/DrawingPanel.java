package ClassTestCode;

import javax.swing.*;
import java.awt.*;

public class DrawingPanel extends JPanel {
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLUE);
        g.fillRect(50, 50, 100, 100); // Draws a blue rectangle
        g.setColor(Color.RED);
        g.fillOval(200, 50, 100, 100); // Draws a red oval
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("2D Drawing Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new DrawingPanel());
        frame.setSize(400, 300);
        frame.setVisible(true);
    }
}
