package Ques01;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Vector;

public class StudentManager extends JFrame {
    private JTable studentTable;
    private JButton editButton;
    private JButton deleteButton;

    public StudentManager() {
        // GUI Components
        studentTable = new JTable();
        editButton = new JButton("Edit");
        deleteButton = new JButton("Delete");

        // Load students into table
        loadStudents();

        // Add components to JFrame
        setLayout(new BorderLayout());
        add(new JScrollPane(studentTable), BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel();
        bottomPanel.add(editButton);
        bottomPanel.add(deleteButton);
        add(bottomPanel, BorderLayout.SOUTH);

        // Add action listeners
        editButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                editStudent();
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                deleteStudent();
            }
        });

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 500);
        setVisible(true);
    }

    private void loadStudents() {
        try (Connection conn = JDBCConnection.getConnection()) {
            String sql = "SELECT student_id,student_name,gender,birthdate,phone,email,address,program FROM tbl_student";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            ResultSetMetaData metaData = rs.getMetaData();

            // Get column names
            Vector<String> columnNames = new Vector<>();
            int columnCount = metaData.getColumnCount();
            for (int column = 1; column <= columnCount; column++) {
                columnNames.add(metaData.getColumnName(column));
            }

            // Get row data
            Vector<Vector<Object>> data = new Vector<>();
            while (rs.next()) {
                Vector<Object> vector = new Vector<>();
                for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
                    Object value = rs.getObject(columnIndex);
                    // Convert java.sql.Date to String if necessary
                    if (value instanceof Date) {
                        value = ((Date) value).toString(); // Convert Date to String in yyyy-MM-dd format
                    }
                    vector.add(value);
                }
                data.add(vector);
            }

            // Set table model
            studentTable.setModel(new DefaultTableModel(data, columnNames));
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private void editStudent() {
        int selectedRow = studentTable.getSelectedRow();
        // if (selectedRow != -1) {
            // Adjust based on your table columns
            int studentId = (int) studentTable.getValueAt(selectedRow, 0);
            String name = (String) studentTable.getValueAt(selectedRow, 1);
            String gender = (String) studentTable.getValueAt(selectedRow, 2);
            String birthdateStr = (String) studentTable.getValueAt(selectedRow, 3);
            String phone = (String) studentTable.getValueAt(selectedRow, 4);
            String email = (String) studentTable.getValueAt(selectedRow, 5);
            String address = (String) studentTable.getValueAt(selectedRow, 6);
            String program = (String) studentTable.getValueAt(selectedRow, 7);

            // Create input fields for editing
            JTextField nameField = new JTextField(name);
            JTextField genderField = new JTextField(gender);
            JTextField birthdateField = new JTextField(birthdateStr); // Using the same string format
            JTextField phoneField = new JTextField(phone);
            JTextField emailField = new JTextField(email);
            JTextField addressField = new JTextField(address);
            JTextField programField = new JTextField(program);

            // Show dialog for editing student information
            JPanel panel = new JPanel(new GridLayout(7, 2));
            panel.add(new JLabel("Name:"));
            panel.add(nameField);
            panel.add(new JLabel("Gender:"));
            panel.add(genderField);
            panel.add(new JLabel("Birthdate (yyyy-MM-dd):"));
            panel.add(birthdateField);
            panel.add(new JLabel("Phone:"));
            panel.add(phoneField);
            panel.add(new JLabel("Email:"));
            panel.add(emailField);
            panel.add(new JLabel("Address:"));
            panel.add(addressField);
            panel.add(new JLabel("Program:"));
            panel.add(programField);

            int result = JOptionPane.showConfirmDialog(this, panel, "Edit Student", JOptionPane.OK_CANCEL_OPTION,
                    JOptionPane.PLAIN_MESSAGE);

            if (result == JOptionPane.OK_OPTION) {
                String updatedName = nameField.getText();
                String updatedGender = genderField.getText();
                String updatedBirthdateStr = birthdateField.getText();
                String updatedPhone = phoneField.getText();
                String updatedEmail = emailField.getText();
                String updatedAddress = addressField.getText();
                String updatedProgram = programField.getText();

                java.sql.Date updatedBirthdate = null;
                // try {
                    updatedBirthdate = java.sql.Date.valueOf(updatedBirthdateStr); // Convert String to Date
                // } catch (IllegalArgumentException ex) {
                //     JOptionPane.showMessageDialog(this, "Invalid date format. Use yyyy-MM-dd.");
                //     return;
                // }

                // Update the student information in the database
                try (Connection conn = JDBCConnection.getConnection()) {
                    String sql = "UPDATE tbl_student SET student_name = ?, gender = ?, birthdate=?, phone=?, email=?, address=?, program=? WHERE student_id = ?";
                    PreparedStatement pstmt = conn.prepareStatement(sql);
                    pstmt.setString(1, updatedName);
                    pstmt.setString(2, updatedGender);
                    pstmt.setDate(3, updatedBirthdate); // Set Date
                    pstmt.setString(4, updatedPhone);
                    pstmt.setString(5, updatedEmail);
                    pstmt.setString(6, updatedAddress);
                    pstmt.setString(7, updatedProgram);
                    pstmt.setInt(8, studentId);
                    pstmt.executeUpdate();
                    JOptionPane.showMessageDialog(this, "Updated successfully");
                    loadStudents(); // Refresh table data
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(this, "Error updating.");
                }
            }
        // } else {
        //     JOptionPane.showMessageDialog(this, "Select a student to edit");
        // }
    }

    private void deleteStudent() {
        int selectedRow = studentTable.getSelectedRow();
        // if (selectedRow != -1) {
            int studentId = (int) studentTable.getValueAt(selectedRow, 0);
            try (Connection conn = JDBCConnection.getConnection()) {
                String sql = "DELETE FROM tbl_student WHERE student_id = ?";
                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setInt(1, studentId);
                pstmt.executeUpdate();
                JOptionPane.showMessageDialog(this, "Student deleted successfully");
                loadStudents(); // Refresh table data
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        // } else {
        //     JOptionPane.showMessageDialog(this, "Select a student to delete");
        // }
    }

    public static void main(String[] args) {
        new StudentManager();
    }
}
