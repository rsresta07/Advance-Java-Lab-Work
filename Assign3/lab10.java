package Assign3;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class lab10 {
    private static int count = 0; // Use int instead of double for counting clicks

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        JPanel mainPanel = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();

        JLabel listener = new JLabel("Mouse Listener");
        JButton welcomeButton = new JButton("Welcome to MouseEventListener");
        JLabel counter = new JLabel("Mouse Clicked: 0");
        JLabel position = new JLabel("(0,0)");

        welcomeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                count++; // Increment the click count
                counter.setText("Mouse Clicked: " + count); // Update the label text
            }
        });

        mainPanel.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                position.setText("(" + e.getX() + ", " + e.getY() + ")");
            }
        });

        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.insets = new Insets(0, 0, 40, 0);
        mainPanel.add(listener, constraints);

        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.insets = new Insets(0, 0, 40, 0);
        mainPanel.add(welcomeButton, constraints);

        constraints.gridx = 0;
        constraints.gridy = 2;
        mainPanel.add(counter, constraints);

        constraints.gridx = 0;
        constraints.gridy = 3;
        mainPanel.add(position, constraints);

        frame.add(mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 600);
        frame.setVisible(true);
    }
}
