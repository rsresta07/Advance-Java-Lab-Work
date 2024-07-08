package Assign3;

import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class lab10 {
    private static int clickCount = 0;

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        JPanel mainPanel = new JPanel(new GridBagLayout());

        JLabel listener = new JLabel("Mouse Listener");
        JButton welcomeButton = new JButton("Welcome to MouseEventListener");
        JLabel counter = new JLabel("Mouse Clicked: 0");
        JLabel position = new JLabel("(0,0)");

        welcomeButton.addActionListener(e -> counter.setText("Mouse Clicked: " + (++clickCount)));

        mainPanel.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                position.setText("(" + e.getX() + ", " + e.getY() + ")");
            }
        });

        addToPanel(mainPanel, listener, 0, 0, 40);
        addToPanel(mainPanel, welcomeButton, 0, 1, 40);
        addToPanel(mainPanel, counter, 0, 2, 0);
        addToPanel(mainPanel, position, 0, 3,0);

        frame.add(mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setVisible(true);
    }

    private static void addToPanel(JPanel panel, Component component, int x, int y, int bottomInset) {
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = x;
        constraints.gridy = y;
        constraints.insets = new Insets(0, 0, bottomInset, 0);
        panel.add(component, constraints);
    }
}