package lab01;

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
            String sql = "SELECT * FROM tbl_student";
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
                    vector.add(rs.getObject(columnIndex));
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
        if (selectedRow != -1) {
            int studentId = (int) studentTable.getValueAt(selectedRow, 0);

            JTextField nameField = new JTextField((String) studentTable.getValueAt(selectedRow, 1));
            JComboBox<String> genderComboBox = new JComboBox<>(new String[] { "Male", "Female", "Others" });
            genderComboBox.setSelectedItem(studentTable.getValueAt(selectedRow, 2));
            JTextField birthdateField = new JTextField((String) studentTable.getValueAt(selectedRow, 3));
            JTextField phoneField = new JTextField((String) studentTable.getValueAt(selectedRow, 4));
            JTextField emailField = new JTextField((String) studentTable.getValueAt(selectedRow, 5));
            JTextField addressField = new JTextField((String) studentTable.getValueAt(selectedRow, 6));

            
            JPanel editPanel = new JPanel(new GridLayout(6, 2));
            editPanel.add(new JLabel("Name:"));
            editPanel.add(nameField);
            editPanel.add(new JLabel("Gender:"));
            editPanel.add(genderComboBox);
            editPanel.add(new JLabel("DOB:"));
            editPanel.add(birthdateField);
            editPanel.add(new JLabel("Phone:"));
            editPanel.add(phoneField);
            editPanel.add(new JLabel("Email:"));
            editPanel.add(emailField);
            editPanel.add(new JLabel("Address:"));
            editPanel.add(addressField);

            int result = JOptionPane.showConfirmDialog(null, editPanel, "Edit Student", JOptionPane.OK_CANCEL_OPTION);
            if (result == JOptionPane.OK_OPTION) {
                try (Connection conn = JDBCConnection.getConnection()) {
                    String sql = "UPDATE tbl_student SET student_name = ?, gender = ?, birthdate = ?, phone = ?, email = ?, address = ? WHERE student_id = ?";
                    PreparedStatement pstmt = conn.prepareStatement(sql);
                    pstmt.setString(1, nameField.getText());
                    pstmt.setString(2, (String) genderComboBox.getSelectedItem());
                    pstmt.setString(3, birthdateField.getText());
                    pstmt.setString(4, phoneField.getText());
                    pstmt.setString(5, emailField.getText());
                    pstmt.setString(6, addressField.getText());
                    pstmt.setInt(7, studentId);
                    pstmt.executeUpdate();
                    JOptionPane.showMessageDialog(this, "Student details updated successfully");
                    loadStudents(); // Refresh table data
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Please select a student to edit");
        }
    }

    private void deleteStudent() {
        int selectedRow = studentTable.getSelectedRow();
        if (selectedRow != -1) {
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
        } else {
            JOptionPane.showMessageDialog(this, "Please select a student to delete");
        }
    }

    public static void main(String[] args) {
        new StudentManager();
    }
}
