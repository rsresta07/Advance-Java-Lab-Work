package lab01;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
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
        // JFrame frame = new JFrame();
        setTitle("User Login");
        JPanel mainPanel = new JPanel(new GridBagLayout());
        GridBagConstraints constr = new GridBagConstraints();
        constr.insets = new Insets(5, 5, 5, 5);

        userNameField = new JTextField(10);
        passwordField = new JPasswordField(10);
        loginButton = new JButton("Login");

        constr.gridx = 0;
        constr.gridy = 0;
        constr.anchor = GridBagConstraints.WEST;
        mainPanel.add(new JLabel("Username:"), constr);
        constr.gridx = 1;
        mainPanel.add(userNameField, constr);

        constr.gridx = 0;
        constr.gridy = 1;
        mainPanel.add(new JLabel("Password:"), constr);
        constr.gridx = 1;
        mainPanel.add(passwordField, constr);

        constr.gridx = 0;
        constr.gridy = 2;
        constr.gridwidth = 2;
        constr.anchor = GridBagConstraints.CENTER;
        mainPanel.add(loginButton, constr);

        add(mainPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(250, 200);
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
