package Ques03;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class lab03 {

    public static void main(String[] args) {
        // Database URL, username, and password
        String jdbcUrl = "jdbc:mysql://localhost:3306/employees_db";
        String username = "root";
        String password = "";

        try {
            // Establish the connection
            Connection conn = DriverManager.getConnection(jdbcUrl, username, password);

            // Insert records
            String insertSQL = "INSERT INTO employees (id, name, position, salary) VALUES (?, ?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(insertSQL);

            // Insert first record
            pstmt.setInt(1, 1);
            pstmt.setString(2, "Apradhi Adhikari");
            pstmt.setString(3, "Manager");
            pstmt.setDouble(4, 75000.00);
            pstmt.executeUpdate();

            // Insert second record
            pstmt.setInt(1, 2);
            pstmt.setString(2, "Godatta Prasad");
            pstmt.setString(3, "Developer");
            pstmt.setDouble(4, 65000.00);
            pstmt.executeUpdate();

            // Insert third record
            pstmt.setInt(1, 3);
            pstmt.setString(2, "Nani Thaku");
            pstmt.setString(3, "Designer");
            pstmt.setDouble(4, 60000.00);
            pstmt.executeUpdate();

            // Insert forth record
            pstmt.setInt(1, 4);
            pstmt.setString(2, "Cholendra Shumsher");
            pstmt.setString(3, "General Manager");
            pstmt.setDouble(4, 100000.00);
            pstmt.executeUpdate();

            // Update a record
            String updateSQL = "UPDATE employees SET salary = ? WHERE id = ?";
            pstmt = conn.prepareStatement(updateSQL);
            pstmt.setDouble(1, 80000.00);
            pstmt.setInt(2, 1);
            pstmt.executeUpdate();

            // Delete a record
            String deleteSQL = "DELETE FROM employees WHERE id = ?";
            pstmt = conn.prepareStatement(deleteSQL);
            pstmt.setInt(1, 3);
            pstmt.executeUpdate();

            // Execute a SELECT query
            Statement stmt = conn.createStatement();
            String selectSQL = "SELECT id, name, position FROM employees";
            ResultSet rs = stmt.executeQuery(selectSQL);

            // Extract data from result set
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String position = rs.getString("position");

                System.out.print("ID: " + id);
                System.out.print(", Name: " + name);
                System.out.println(", Position: " + position);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
