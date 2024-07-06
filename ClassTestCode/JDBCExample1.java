package ClassTestCode;

import java.sql.*;

public class JDBCExample1 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydatabase"; // Database URL
        String username = "root";
        String password = "password";

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            // 1. Establish the JDBC connection
            connection = DriverManager.getConnection(url, username, password);

            // 2. Create a statement
            statement = connection.createStatement();

            // 3. Execute a query
            String sql = "SELECT id, name, age FROM employees";
            resultSet = statement.executeQuery(sql);

            // 4. Process the result set
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                System.out.println("ID: " + id + ", Name: " + name + ", Age: " + age);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 5. Close the resources
            try {
                if (resultSet != null)
                    resultSet.close();
                if (statement != null)
                    statement.close();
                if (connection != null)
                    connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
