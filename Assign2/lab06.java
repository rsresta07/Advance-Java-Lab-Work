package Assign2;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class lab06 {
    public static void main(String[] args){
        JFrame frame = new JFrame("List");
        JPanel mainPanel = new JPanel();
        
        JLabel lb1 = new JLabel("Select your favorite sports from the list: ");
        String sport[] = {"Badminton", "Hockey", "Tennis", "Football", "Cricket", "Formula One","Rugby"};
        JList <String> list = new JList<String>(sport);
        JScrollPane scrollPane = new JScrollPane(list);

        mainPanel.add(lb1);
        mainPanel.add(scrollPane);

        frame.add(mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setVisible(true);
    }
}
