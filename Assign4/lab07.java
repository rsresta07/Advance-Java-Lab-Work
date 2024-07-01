package Assign4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class lab07 extends JFrame {
    private JButton toggleButton;
    private JLabel bulbImageLabel;
    private ImageIcon bulbOnIcon;
    private ImageIcon bulbOffIcon;
    private boolean bulbOn;
    private final int IMAGE_WIDTH = 200; // Desired width of the bulb image
    private final int IMAGE_HEIGHT = 200; // Desired height of the bulb image

    public lab07() {
        setTitle("Bulb GUI");
        setSize(300, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the window

        bulbOn = false;

        // Load and scale images
        bulbOnIcon = scaleImageIcon(new ImageIcon(getClass().getResource("../img/bulb_on.png")), IMAGE_WIDTH, IMAGE_HEIGHT);
        bulbOffIcon = scaleImageIcon(new ImageIcon(getClass().getResource("../img/bulb_off.png")), IMAGE_WIDTH, IMAGE_HEIGHT);

        // Create a panel to hold components
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        // Create the toggle button
        toggleButton = new JButton("Turn On");
        toggleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                toggleBulb();
            }
        });

        // Create label for bulb image
        bulbImageLabel = new JLabel();
        bulbImageLabel.setHorizontalAlignment(SwingConstants.CENTER);
        bulbImageLabel.setIcon(bulbOffIcon);
        bulbImageLabel.setPreferredSize(new Dimension(IMAGE_WIDTH, IMAGE_HEIGHT)); // Set preferred size

        // Add button and image label to panel
        panel.add(toggleButton, BorderLayout.NORTH);
        panel.add(bulbImageLabel, BorderLayout.CENTER);

        // Add panel to the frame
        add(panel);

        setVisible(true);
    }

    private ImageIcon scaleImageIcon(ImageIcon icon, int width, int height) {
        Image image = icon.getImage(); // Transform image
        Image scaledImage = image.getScaledInstance(width, height, Image.SCALE_SMOOTH); // Scale image
        return new ImageIcon(scaledImage); // Transform back to image icon
    }

    private void toggleBulb() {
        bulbOn = !bulbOn;
        if (bulbOn) {
            toggleButton.setText("Turn Off");
            bulbImageLabel.setIcon(bulbOnIcon);
        } else {
            toggleButton.setText("Turn On");
            bulbImageLabel.setIcon(bulbOffIcon);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new lab07();
            }
        });
    }
}
