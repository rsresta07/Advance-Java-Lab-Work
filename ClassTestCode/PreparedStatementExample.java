package ClassTestCode;

import java.sql.*;

public class PreparedStatementExample {

    private static final String URL = "jdbc:mysql://localhost:3306/your_database";
    private static final String USER = "your_username";
    private static final String PASSWORD = "your_password";

    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement insertStmt = null;
        PreparedStatement selectStmt = null;
        ResultSet resultSet = null;

        try {
            // Establish the connection
            connection = DriverManager.getConnection(URL, USER, PASSWORD);

            // Insert a new user
            String insertSQL = "INSERT INTO users (username, password) VALUES (?, ?)";
            insertStmt = connection.prepareStatement(insertSQL);
            insertStmt.setString(1, "john_doe");
            insertStmt.setString(2, "secure_password");
            int rowsInserted = insertStmt.executeUpdate();
            System.out.println("Rows inserted: " + rowsInserted);

            // Retrieve users based on username
            String selectSQL = "SELECT * FROM users WHERE username = ?";
            selectStmt = connection.prepareStatement(selectSQL);
            selectStmt.setString(1, "john_doe");
            resultSet = selectStmt.executeQuery();

            // Process the result set
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                System.out.println("ID: " + id);
                System.out.print(", Username: " + username);
                System.out.print(", Password: " + password);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
