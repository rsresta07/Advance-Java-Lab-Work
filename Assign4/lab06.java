package Assign4;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class lab06 {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        JPanel mainPanel = new JPanel(new GridBagLayout());
        GridBagConstraints constr = new GridBagConstraints();
        constr.fill = GridBagConstraints.HORIZONTAL;

        JLabel question = new JLabel("Who is the founder of java?");
        JButton option1 = new JButton("Dennis Ritchie");
        JButton option2 = new JButton("James Gosling");
        JButton option3 = new JButton("Guido Van Rossum");
        JButton option4 = new JButton("Patrick Naughton");
        JLabel answer = new JLabel("");

        // Add ActionListeners to the buttons
        option1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                answer.setText("Incorrect! Dennis Ritchie is the founder of C.");
            }
        });

        option2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                answer.setText("Correct! James Gosling is the founder of Java.");
            }
        });

        option3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                answer.setText("Incorrect! Guido Van Rossum is the founder of Python.");
            }
        });

        option4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                answer.setText("Incorrect! Patrick Naughton is not the founder.");
            }
        });

        constr.gridx = 0;
        constr.gridy = 0;
        constr.insets = new Insets(0, 0, 30, 0);
        constr.gridwidth = 2;
        constr.anchor = GridBagConstraints.CENTER;
        mainPanel.add(question, constr);

        constr.gridx = 0;
        constr.gridy = 1;
        constr.gridwidth = 1;
        constr.insets = new Insets(0, 0, 0, 0);
        mainPanel.add(option1, constr);

        constr.gridx = 1;
        constr.gridy = 1;
        mainPanel.add(option2, constr);

        constr.gridx = 0;
        constr.gridy = 2;
        mainPanel.add(option3, constr);

        constr.gridx = 1;
        constr.gridy = 2;
        mainPanel.add(option4, constr);

        constr.gridx = 0;
        constr.gridy = 3;
        constr.insets = new Insets(30, 0, 0, 0);
        constr.gridwidth = 2;
        constr.anchor = GridBagConstraints.CENTER;
        mainPanel.add(answer, constr);

        frame.add(mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 600);
        frame.setVisible(true);
    }
}
