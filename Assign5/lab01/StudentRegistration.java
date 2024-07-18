package lab01;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class StudentRegistration extends JFrame {
    private JTextField nameField;
    private JComboBox<String> genderComboBox;
    private JTextField birthdateField;
    private JTextField phoneField;
    private JTextField emailField;
    private JTextField addressField;
    private JComboBox<String> programBox;

    public StudentRegistration() {
        JPanel mainPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        nameField = new JTextField(20);
        genderComboBox = new JComboBox<>(new String[] { "Please Select One", "Male", "Female", "Others" });
        birthdateField = new JTextField(20);
        phoneField = new JTextField(20);
        emailField = new JTextField(20);
        addressField = new JTextField(20);

        JPanel genderPanel = new JPanel();
        genderPanel.add(genderComboBox);

        String[] programs = { "Please Select One", "BIM", "BCA", "BBM", "CSIT", "BBA", "BHM" };
        programBox = new JComboBox<>(programs);
        programBox.setPreferredSize(
                new Dimension(nameField.getPreferredSize().width, programBox.getPreferredSize().height));

        JButton registerBtn = new JButton("Add");
        JButton resetBtn = new JButton("Reset");
        JButton cancelBtn = new JButton("Cancel");
        JPanel btnPanel = new JPanel();
        btnPanel.add(registerBtn);
        btnPanel.add(resetBtn);
        btnPanel.add(cancelBtn);

        registerBtn.addActionListener(e -> {
            if (nameField.getText().isEmpty() || genderComboBox.getSelectedIndex() == 0
                    || birthdateField.getText().isEmpty() || phoneField.getText().isEmpty()
                    || emailField.getText().isEmpty() || addressField.getText().isEmpty()
                    || programBox.getSelectedIndex() == 0) {
                JOptionPane.showMessageDialog(this, "All fields are required.");
                return;
            }
            registerStudent();
        });

        resetBtn.addActionListener(e -> resetForm());

        cancelBtn.addActionListener(e -> System.exit(0));

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        mainPanel.add(new JLabel("Name:"), gbc);
        gbc.gridx = 1;
        mainPanel.add(nameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        mainPanel.add(new JLabel("Gender:"), gbc);
        gbc.gridx = 1;
        mainPanel.add(genderPanel, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        mainPanel.add(new JLabel("DOB:"), gbc);
        gbc.gridx = 1;
        mainPanel.add(birthdateField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        mainPanel.add(new JLabel("Phone:"), gbc);
        gbc.gridx = 1;
        mainPanel.add(phoneField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        mainPanel.add(new JLabel("Email:"), gbc);
        gbc.gridx = 1;
        mainPanel.add(emailField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        mainPanel.add(new JLabel("Address:"), gbc);
        gbc.gridx = 1;
        mainPanel.add(addressField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 6;
        mainPanel.add(new JLabel("Program:"), gbc);
        gbc.gridx = 1;
        mainPanel.add(programBox, gbc);

        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        mainPanel.add(btnPanel, gbc);

        add(mainPanel);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);
    }

    private void registerStudent() {
        String name = nameField.getText();
        String gender = (String) genderComboBox.getSelectedItem();
        String birthdate = birthdateField.getText();
        String phone = phoneField.getText();
        String email = emailField.getText();
        String address = addressField.getText();
        String program = (String) programBox.getSelectedItem();

        try (Connection conn = JDBCConnection.getConnection()) {
            String sql = "INSERT INTO tbl_student (student_name, gender, birthdate, phone, email, address, program) VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, name);
            pstmt.setString(2, gender);
            pstmt.setString(3, birthdate);
            pstmt.setString(4, phone);
            pstmt.setString(5, email);
            pstmt.setString(6, address);
            pstmt.setString(7, program);
            pstmt.executeUpdate();
            JOptionPane.showMessageDialog(this, "Student registered successfully");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new StudentRegistration();
    }

    private void resetForm() {
        nameField.setText(null);
        genderComboBox.setSelectedIndex(0); // Clear selection
        birthdateField.setText(null);
        phoneField.setText(null);
        emailField.setText(null);
        addressField.setText(null);
        programBox.setSelectedIndex(0); // Clear selection
    }
}
