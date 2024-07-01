package Assign4;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

        JLabel question = new JLabel("Who is the founder of java?");
        JButton option1 = new JButton("Dennis Ritchie");
        JButton option2 = new JButton("James Gosling");
        JButton option3 = new JButton("Guido Van Rossum");
        JButton option4 = new JButton("Patrick Naughton");
        JLabel answer = new JLabel("");

        question.setHorizontalAlignment(SwingConstants.CENTER);
        answer.setHorizontalAlignment(SwingConstants.CENTER);

        // Add ActionListeners to the buttons
        option1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                answer.setText("You are incorrect!");
            }
        });

        option2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                answer.setText("You are correct!");
            }
        });

        option3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                answer.setText("You are incorrect!");
            }
        });

        option4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                answer.setText("You are incorrect!");
            }
        });

        mainPanel.add(question);
        mainPanel.add(optionPanel);
        mainPanel.add(answer);
        optionPanel.add(option1);
        optionPanel.add(option2);
        optionPanel.add(option3);
        optionPanel.add(option4);

        frame.add(mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(350, 350);
        frame.setVisible(true);
    }
}
