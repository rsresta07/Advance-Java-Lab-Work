package Assign4;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

public class lab10 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Rameshwor");

        JTabbedPane tabs = new JTabbedPane();

        // Dashboard panel
        JPanel dashPanel = new JPanel();
        dashPanel.add(new JLabel("Welcome to IOC"));

        // Courses panel
        JPanel coursePanel = new JPanel(new GridLayout(0, 1));
        String[] courses = { "C", "C++", "Java", "PHP" };
        coursePanel.add(new JLabel("Select the course", SwingConstants.CENTER));
        for (String course : courses) {
            coursePanel.add(new JCheckBox(course));
        }
        coursePanel.add(new JButton("Submit"));

        // Comment panel
        JPanel commentPanel = new JPanel();
        commentPanel.add(new JLabel("Leave your Comment"));
        commentPanel.add(new JTextArea(20, 50));

        // Adding tabs
        tabs.addTab("Dashboard", dashPanel);
        tabs.addTab("Courses", coursePanel);
        tabs.addTab("Comment", commentPanel);

        // Frame settings
        frame.add(tabs);
        frame.setSize(600, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}