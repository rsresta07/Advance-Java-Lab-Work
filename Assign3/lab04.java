package Assign3;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class lab04 {
    public static void main(String[] args){
        JFrame frame = new JFrame("Rameshwor");
        JPanel mainPanel = new JPanel();
        
        JTextField tf1 = new JTextField("Hello",10);
        JButton bt1 = new JButton("Submit");
        JLabel lb1 = new JLabel();
        

        bt1.addActionListener((ActionListener) new ActionListener() { 
            @Override
            public void actionPerformed(ActionEvent e) {
                lb1.setText(tf1.getText());
            }
        });

        mainPanel.add(tf1);
        mainPanel.add(bt1);
        mainPanel.add(lb1);
        frame.add(mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 600);
        frame.setVisible(true);
    }
}
