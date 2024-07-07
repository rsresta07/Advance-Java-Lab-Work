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

        String[] fruits = {"apple", "orange", "banana", "grapes", "guava", "strawberry", "mango"};
        JList<String> list = new JList<>(fruits);
        JScrollPane sp = new JScrollPane(list);
        sp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        // sp.setPreferredSize(new Dimension(200,200));

        //a Use setVisibleRowCount() method
        list.setVisibleRowCount(4);

        //b Use setFixedCellHeight() method
        list.setFixedCellHeight(15);

        //c Use setFixedCellWidth() method
        list.setFixedCellWidth(100);

        //d Use setListData() method
        String[] newFruits = {"pineapple", "kiwi", "blueberry", "raspberry", "avocado", "coconut", "papaya", "watermelon"};
        list.setListData(newFruits);

        //e Use getSelectedValues() method to Selected Values of list
        JButton copyBtn = new JButton("copy>>>");
        JTextArea textArea = new JTextArea(5, 15);

        copyBtn.addActionListener(e -> {
            List<String> selectedValues = list.getSelectedValuesList();
            textArea.setText(String.join("", selectedValues));
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
