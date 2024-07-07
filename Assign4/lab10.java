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

        JPanel dashPanel = new JPanel();
        JPanel coursePanel = new JPanel(new GridLayout(0, 1));
        JPanel commentPanel = new JPanel();
        
        JLabel dashLabel = new JLabel("Welcome to 10C");
        dashPanel.add(dashLabel);

        JLabel courseLabel = new JLabel("Select the course");
        courseLabel.setHorizontalAlignment(SwingConstants.CENTER);
        JCheckBox cBox1 = new JCheckBox("C");
        JCheckBox cBox2 = new JCheckBox("C++");
        JCheckBox cBox3 = new JCheckBox("Java");
        JCheckBox cBox4 = new JCheckBox("PHP");
        JButton submitBtn = new JButton("Submit");

        coursePanel.add(courseLabel);
        coursePanel.add(cBox1);
        coursePanel.add(cBox2);
        coursePanel.add(cBox3);
        coursePanel.add(cBox4);
        coursePanel.add(submitBtn);

        JLabel commentLabel = new JLabel("Leave your Comment");
        JTextArea cmtArea = new JTextArea(20, 50);
        commentPanel.add(commentLabel);
        commentPanel.add(cmtArea);

        tabs.addTab("Dashboard", dashPanel);
        tabs.addTab("Courses", coursePanel);
        tabs.addTab("Comment", commentPanel);
        
        frame.add(tabs);
        frame.setSize(600, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
