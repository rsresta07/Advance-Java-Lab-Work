/* 
 * This lab06 uses the same database as the lab03 database
 */

package Ques06;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class lab06 {
    public static void main(String[] args) {
        try {
            String jdbcURL = "jdbc:mysql://localhost:3306/employees_db";
            String username = "root";
            String password = "";

            Connection conn = DriverManager.getConnection(jdbcURL, username, password);
            
            // Create statement for updatable ResultSet
            Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

            // Execute query to retrieve ResultSet
            String query = "SELECT * FROM employees";
            ResultSet rs = stmt.executeQuery(query);

            // Update a record in the ResultSet
            if (rs.next()) { // Move to the first row
                rs.updateString("name", "Rahul"); // Example of updating a field
                rs.updateRow(); // Commit changes to the database
            }

            // Verify the update
            rs.beforeFirst(); // Move cursor to the beginning
            while (rs.next()) {
                System.out.println(rs.getInt("id") + "\t" + rs.getString("name"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
