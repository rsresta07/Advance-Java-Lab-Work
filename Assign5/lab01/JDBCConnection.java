package lab01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConnection {
    public static Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/nccs_db";
        String user = "root";
        String password = "";
        return DriverManager.getConnection(url, user, password);
    }
}
