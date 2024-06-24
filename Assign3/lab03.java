package Assign3;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class lab03 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Choose a color");
        JPanel mainPanel = new JPanel();

        JButton redButton = new JButton("Red");
        JButton greenButton = new JButton("Green");
        JButton blueButton = new JButton("Blue");
        JButton close = new JButton("Close");

        mainPanel.add(redButton);
        mainPanel.add(greenButton);
        mainPanel.add(blueButton);
        mainPanel.add(close);

        redButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainPanel.setBackground(Color.RED);
            }
        });

        greenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainPanel.setBackground(Color.GREEN);
            }
        });

        blueButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainPanel.setBackground(Color.BLUE);
            }
        });

        close.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // System.exit(0); -> terminates the entire program or application and JVM.
                // frame.dispose(); -> terminates the specific frame but not entire application.
                System.exit(0);
            }
        });
        
        frame.add(mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setVisible(true);
    }
}
