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
        JFrame frame = new JFrame("Rameshwor");
        frame.setSize(300, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        ImageIcon bulbOnIcon = scaleImageIcon(
                new ImageIcon(lab07.class.getResource("../img/bulb_on.png")), 200, 200);
        ImageIcon bulbOffIcon = scaleImageIcon(
                new ImageIcon(lab07.class.getResource("../img/bulb_off.png")), 200, 200);

        JPanel panel = new JPanel(new BorderLayout());
        JButton toggleButton = new JButton("Turn On");
        JLabel bulbImageLabel = new JLabel(bulbOffIcon);
        bulbImageLabel.setHorizontalAlignment(SwingConstants.CENTER);
        bulbImageLabel.setPreferredSize(new Dimension(200, 200));

        toggleButton.addActionListener(new ActionListener() {
            boolean bulbOn = false;

            @Override
            public void actionPerformed(ActionEvent e) {
                bulbOn = !bulbOn;
                toggleButton.setText(bulbOn ? "Turn Off" : "Turn On");
                bulbImageLabel.setIcon(bulbOn ? bulbOnIcon : bulbOffIcon);
            }
        });

        panel.add(toggleButton, BorderLayout.NORTH);
        panel.add(bulbImageLabel, BorderLayout.CENTER);
        frame.add(panel);
        frame.setVisible(true);
    }

    private static ImageIcon scaleImageIcon(ImageIcon icon, int width, int height) {
        Image image = icon.getImage();
        Image scaledImage = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(scaledImage);
    }
}
