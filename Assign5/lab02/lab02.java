package lab02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;

public class lab02 {
    public static void main(String[] args) {
        // Database URL, username and password
        String jdbcUrl = "jdbc:mysql://localhost:3306/product_db";
        String username = "root";
        String password = "";

        try {
            // Establish the connection
            Connection conn = DriverManager.getConnection(jdbcUrl, username, password);

            // Create a statement
            Statement statement = conn.createStatement();

            // Execute the SELECT query
            String sql = "SELECT * FROM products";
            ResultSet resultSet = statement.executeQuery(sql);

            System.out.println("ID\t\tName\t\tPrice\t\tQuantity");
            // Iterate through the ResultSet and print the retrieved data
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                double price = resultSet.getDouble("price");
                int quantity = resultSet.getInt("quantity");
                System.out.println(id + "\t\t" + name + "\t\t" + price + "\t\t" + quantity);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
