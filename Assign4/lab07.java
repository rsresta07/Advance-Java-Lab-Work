package Assign4;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class lab07 {
    public static void main(String[] args) {
        // Create a new JFrame
        JFrame frame = new JFrame("Rameshwor");
        frame.setSize(300, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null); // Center the window

        // Load and scale images
        ImageIcon bulbOnIcon = scaleImageIcon(
                new ImageIcon(lab07.class.getResource("../img/bulb_on.png")), 200, 200);
        ImageIcon bulbOffIcon = scaleImageIcon(
                new ImageIcon(lab07.class.getResource("../img/bulb_off.png")), 200, 200);

        // Create a panel to hold components
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        // Create the toggle button
        JButton toggleButton = new JButton("Turn On");

        // Create label for bulb image
        JLabel bulbImageLabel = new JLabel();
        bulbImageLabel.setHorizontalAlignment(SwingConstants.CENTER);
        bulbImageLabel.setIcon(bulbOffIcon);
        bulbImageLabel.setPreferredSize(new Dimension(200, 200)); // Set preferred size

        toggleButton.addActionListener(new ActionListener() {
            boolean bulbOn = false;

            @Override
            public void actionPerformed(ActionEvent e) {
                bulbOn = !bulbOn;
                if (bulbOn) {
                    toggleButton.setText("Turn Off");
                    bulbImageLabel.setIcon(bulbOnIcon);
                } else {
                    toggleButton.setText("Turn On");
                    bulbImageLabel.setIcon(bulbOffIcon);
                }
            }
        });

        // Add button and image label to panel
        panel.add(toggleButton, BorderLayout.NORTH);
        panel.add(bulbImageLabel, BorderLayout.CENTER);

        // Add panel to the frame
        frame.add(panel);

        // Make the frame visible
        frame.setVisible(true);
    }

    private static ImageIcon scaleImageIcon(ImageIcon icon, int width, int height) {
        Image image = icon.getImage(); // Transform image
        Image scaledImage = image.getScaledInstance(width, height, Image.SCALE_SMOOTH); // Scale image
        return new ImageIcon(scaledImage); // Transform back to image icon
    }
}
