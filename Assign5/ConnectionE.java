// FIXME: the terminal says 'MySQL JDBC Driver not found.'

package Assign5;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionE {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/nccs_db";
        String username = "root";
        String password = "";

        try {
            // Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish the connection
            Connection conn = DriverManager.getConnection(url, username, password);

            if (conn != null) {
                System.out.println("Connection established successfully!");
            }
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver not found.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Failed to establish a connection to the database.");
            e.printStackTrace();
        }
    }
}
