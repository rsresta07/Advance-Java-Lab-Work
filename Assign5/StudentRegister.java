package Assign5;

import javax.swing.*;
import java.awt.*;

public class StudentRegister {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        JPanel mainPanel = new JPanel(new GridBagLayout());
        GridBagConstraints constr = new GridBagConstraints();

        JLabel title = new JLabel("Student Registration", SwingConstants.CENTER);
        JLabel StudentName = new JLabel("Student Name");
        JLabel StudentDob = new JLabel("Date of Birth");
        JLabel StudentEmail = new JLabel("Student Email");
        JLabel StudentAddr = new JLabel("Student's Address");

        JTextField studentNameField = new JTextField(10);
        JTextField studentDobField = new JTextField(10);
        JTextField studentEmailField = new JTextField(10);
        JTextField studentAddrField = new JTextField(10);

        JButton submitButton = new JButton("Submit");

        constr.gridx = 0;
        constr.gridy = 0;
        constr.gridwidth = 2;
        constr.insets = new Insets(0, 0, 5, 20);
        mainPanel.add(title, constr);

        constr.gridx = 0;
        constr.gridy = 1;
        constr.gridwidth =1;
        mainPanel.add(StudentName, constr);
        constr.gridx = 1;
        mainPanel.add(studentNameField, constr);

        constr.gridx = 0;
        constr.gridy = 2;
        mainPanel.add(StudentDob, constr);
        constr.gridx = 1;
        mainPanel.add(studentDobField, constr);

        constr.gridx = 0;
        constr.gridy = 3;
        mainPanel.add(StudentEmail, constr);
        constr.gridx = 1;
        mainPanel.add(studentEmailField, constr);

        constr.gridx = 0;
        constr.gridy = 4;
        mainPanel.add(StudentAddr, constr);
        constr.gridx = 1;
        mainPanel.add(studentAddrField, constr);
        
        constr.gridx = 0;
        constr.gridy = 5;
        constr.gridwidth = 2;
        mainPanel.add(submitButton, constr);

        frame.add(mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 600);
        frame.setVisible(true);
    }
}
