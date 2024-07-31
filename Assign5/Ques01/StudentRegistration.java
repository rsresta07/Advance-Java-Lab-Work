package Ques01;

import java.awt.Dimension;
import java.awt.GridLayout;
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
        JPanel mainPanel = new JPanel(new GridLayout(8, 2, 5, 5));

        nameField = new JTextField(20);
        genderComboBox = new JComboBox<>(new String[] { "Please Select One", "Male", "Female", "Others" });
        birthdateField = new JTextField(20);
        phoneField = new JTextField(20);
        emailField = new JTextField(20);
        addressField = new JTextField(20);

        String[] programs = { "Please Select One", "BIM", "BCA", "BBM", "CSIT", "BBA", "BHM" };
        programBox = new JComboBox<>(programs);
        programBox.setPreferredSize(
                new Dimension(nameField.getPreferredSize().width, programBox.getPreferredSize().height));

        JButton registerBtn = new JButton("Add");
        JButton resetBtn = new JButton("Reset");
        // JButton cancelBtn = new JButton("Cancel");

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

        // cancelBtn.addActionListener(e -> System.exit(0));

        mainPanel.add(new JLabel("Name:"));
        mainPanel.add(nameField);

        mainPanel.add(new JLabel("Gender:"));
        mainPanel.add(genderComboBox);

        mainPanel.add(new JLabel("DOB (YYYY-MM-DD):"));
        mainPanel.add(birthdateField);

        mainPanel.add(new JLabel("Phone:"));
        mainPanel.add(phoneField);

        mainPanel.add(new JLabel("Email:"));
        mainPanel.add(emailField);

        mainPanel.add(new JLabel("Address:"));
        mainPanel.add(addressField);

        mainPanel.add(new JLabel("Program:"));
        mainPanel.add(programBox);

        mainPanel.add(registerBtn);
        mainPanel.add(resetBtn);
        // mainPanel.add(cancelBtn);

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
            resetForm();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new StudentRegistration();
    }

    private void resetForm() {
        nameField.setText(null);
        genderComboBox.setSelectedIndex(0);
        birthdateField.setText(null);
        phoneField.setText(null);
        emailField.setText(null);
        addressField.setText(null);
        programBox.setSelectedIndex(0);
    }
}
