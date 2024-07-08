package Assign4;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class lab13 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Rameshwor");
        JPanel panel = new JPanel();

        String[][] data = {
                { "1234", "John", "pencil", "10" },
                { "4567", "Mirian", "pen", "25" },
                { "4792", "Katy", "chair", "280" },
                { "5489", "Agnes", "table", "510" },
                { "6887", "Stanley", "flower", "30" },
        };

        String[] columnNames = { "ID", "Name", "Product", "Price in $" };

        JTable table = new JTable(data, columnNames);
        table.setPreferredScrollableViewportSize(new Dimension(450, 80));

        panel.add(new JScrollPane(table));

        frame.add(panel);
        frame.setSize(500, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}