/* 
 * This lab05 uses the same database as the lab03 database
 */

package Ques05;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class lab05 {

    
    public static void main(String[] args) {
        try {
            // Database credentials
            String jdbcUrl = "jdbc:mysql://localhost:3306/employees_db";
            String user = "root";
            String pass = "";

            // Open a connection
            Connection conn = DriverManager.getConnection(jdbcUrl, user, pass);

            // Create a statement with scrollable ResultSet
            Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            String selectSQL = "SELECT id, name, position, salary FROM employees";
            ResultSet rs = stmt.executeQuery(selectSQL);

            // Scroll forward
            System.out.println("Scrolling forward:");
            System.out.println("ID\t\tName\t\t\tPosition\t\tSalary");
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String position = rs.getString("position");
                Double salary = rs.getDouble("salary");

                System.out.println(id + "\t\t" + name + "\t\t" + position + "\t\t" + salary);
            }

            // Scroll backward
            System.out.println("\nScrolling backward:");
            System.out.println("ID\t\tName\t\t\tPosition\t\tSalary");
            while (rs.previous()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String position = rs.getString("position");
                Double salary = rs.getDouble("salary");

                System.out.println(id + "\t\t" + name + "\t\t" + position + "\t\t" + salary);
            }

            // Scroll to a specific row
            int rowNumber = 3;
            System.out.println("\nScrolling to row " + rowNumber + ":");
            System.out.println("ID\t\tName\t\t\tPosition\t\tSalary");
            if (rs.absolute(rowNumber)) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String position = rs.getString("position");
                Double salary = rs.getDouble("salary");

                System.out.println(id + "\t\t" + name + "\t\t" + position + "\t\t" + salary);
            } else {
                System.out.println("Row " + rowNumber + " does not exist.");
            }

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
