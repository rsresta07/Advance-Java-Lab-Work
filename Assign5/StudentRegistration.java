package Assign5;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class StudentRegistration {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Student Registration Form");
        JPanel mainPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        JTextField nameField = new JTextField(20);
        JTextField addressField = new JTextField(20);
        JTextField phoneField = new JTextField(20);
        JTextField emailField = new JTextField(20);

        JRadioButton maleBtn = new JRadioButton("male");
        JRadioButton femaleBtn = new JRadioButton("female");
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(maleBtn);
        genderGroup.add(femaleBtn);
        JPanel genderPanel = new JPanel();
        genderPanel.add(maleBtn);
        genderPanel.add(femaleBtn);

        String[] programs = { "BIM", "BCA", "BBM", "CSIT", "BBA", "BHM" };
        JComboBox<String> programBox = new JComboBox<>(programs);
        programBox.setPreferredSize(
                new Dimension(nameField.getPreferredSize().width, programBox.getPreferredSize().height));

        JButton addBtn = new JButton("Add");
        JButton resetBtn = new JButton("Reset");
        JButton cancelBtn = new JButton("Cancel");
        JPanel btnPanel = new JPanel();
        btnPanel.add(addBtn);
        btnPanel.add(resetBtn);
        btnPanel.add(cancelBtn);

        addBtn.addActionListener(e -> {
            String gender = maleBtn.isSelected() ? "male" : (femaleBtn.isSelected() ? "female" : "invalid");
            String message = String.format(
                    "Name: %s\nAddress: %s\nGender: %s\nProgram: %s\nPhone: %s\nEmail: %s",
                    nameField.getText(), addressField.getText(), gender, programBox.getSelectedItem(),
                    phoneField.getText(), emailField.getText());
            JOptionPane.showMessageDialog(frame, message, "User Information", JOptionPane.INFORMATION_MESSAGE);
        });

        resetBtn.addActionListener(e -> {
            nameField.setText(null);
            addressField.setText(null);
            phoneField.setText(null);
            emailField.setText(null);
            genderGroup.clearSelection();
            programBox.setSelectedIndex(0);
        });

        cancelBtn.addActionListener(e -> System.exit(0));

        frame.add(mainPanel);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
