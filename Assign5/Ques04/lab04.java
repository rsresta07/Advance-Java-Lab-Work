/* 
 * This lab04 uses the same database as the lab03 database
 */

package Ques04;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class lab04 {

    public static void main(String[] args) {
        try {
            // Database credentials
            String jdbcUrl = "jdbc:mysql://localhost:3306/employees_db";
            String user = "root";
            String pass = "";
            
            // Open a connection
            Connection conn = DriverManager.getConnection(jdbcUrl, user, pass);

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

            // Execute an INSERT query
            String insertSQL = "INSERT INTO employees (id, name, position) VALUES (5, 'Joe Mama', 'Janitor'),(6,'Sofat', 'Designer')";
            int insertCount = stmt.executeUpdate(insertSQL);
            System.out.println("Inserted records: " + insertCount);

            // Execute an UPDATE query
            String updateSQL = "UPDATE employees SET salary = '20000' WHERE name = 'Joe Mama'";
            int updateCount = stmt.executeUpdate(updateSQL);
            System.out.println("Updated records: " + updateCount);

            // Execute a DELETE query
            String deleteSQL = "DELETE FROM employees WHERE name = 'Sofat'";
            int deleteCount = stmt.executeUpdate(deleteSQL);
            System.out.println("Deleted records: " + deleteCount);

            // Clean-up environment
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException se) {
            // Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            // Handle errors for Class.forName
            e.printStackTrace();
        }
        System.out.println("Goodbye!");
    }
}
