package Ques01;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class UserLogin extends JFrame {
    private JTextField userNameField;
    private JPasswordField passwordField;
    private JButton loginButton;

    public UserLogin() {
        setTitle("User Login");
        JPanel mainPanel = new JPanel(new GridLayout(3, 2));

        userNameField = new JTextField(10);
        passwordField = new JPasswordField(10);
        loginButton = new JButton("Login");

        mainPanel.add(new JLabel("Username:"));
        mainPanel.add(userNameField);
        mainPanel.add(new JLabel("Password:"));
        mainPanel.add(passwordField);
        mainPanel.add(new JLabel()); // Placeholder to center the login button
        mainPanel.add(loginButton);

        add(mainPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(350, 150);
        setVisible(true);
        setLocationRelativeTo(null);

        // When the user clicks the Login Button
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                validateLogin();
            }
        });
    }

    // Method to validate user login credentials using JDBC connection
    private void validateLogin() {
        String userName = userNameField.getText();
        String password = new String(passwordField.getPassword());
        try (Connection conn = JDBCConnection.getConnection()) {
            String sql = "SELECT * FROM tbl_users WHERE user_name =? AND password =?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, userName);
            pstmt.setString(2, password);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                JOptionPane.showMessageDialog(this, "Login Successful");
            } else {
                JOptionPane.showMessageDialog(this, "Invalid username or password");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new UserLogin();
    }
}
