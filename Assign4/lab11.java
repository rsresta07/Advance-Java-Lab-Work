package Assign4;

import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class lab11 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Rameshwor");
        JPanel panel = new JPanel();

        String[] newFruits = { "pineapple", "kiwi", "blueberry", "raspberry", "avocado", "coconut", "papaya",
                "watermelon" };
        JList<String> list = new JList<>(newFruits);
        list.setVisibleRowCount(4);
        list.setFixedCellHeight(15);
        list.setFixedCellWidth(100);
        JScrollPane sp = new JScrollPane(list, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        JButton copyBtn = new JButton("copy>>>");
        JTextArea textArea = new JTextArea(5, 15);
        copyBtn.addActionListener(e -> {
            List<String> selectedValues = list.getSelectedValuesList();
            textArea.setText(String.join("\n", selectedValues));
        });

        panel.add(sp);
        panel.add(copyBtn);
        panel.add(textArea);

        frame.add(panel);
        frame.setSize(500, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}