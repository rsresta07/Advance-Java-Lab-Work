package Assign4;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class lab06 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Guess the Answer");
        JPanel mainPanel = new JPanel(new GridLayout(0, 1));
        JPanel optionPanel = new JPanel(new GridLayout(2, 2));

        JLabel question = new JLabel("Who is the founder of java?", SwingConstants.CENTER);
        JLabel answer = new JLabel("", SwingConstants.CENTER);

        JButton[] options = {
                new JButton("Dennis Ritchie"),
                new JButton("James Gosling"),
                new JButton("Guido Van Rossum"),
                new JButton("Patrick Naughton")
        };

        for (JButton option : options) {
            option.addActionListener(e -> {
                if (option.getText().equals("James Gosling")) {
                    answer.setText("You are correct!");
                } else {
                    answer.setText("You are incorrect!");
                }
            });
            optionPanel.add(option);
        }

        mainPanel.add(question);
        mainPanel.add(optionPanel);
        mainPanel.add(answer);

        frame.add(mainPanel);
        frame.setSize(350, 350);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}