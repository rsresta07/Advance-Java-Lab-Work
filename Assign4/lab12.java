package Assign4;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class lab12 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Rameshwor");
        JPanel mainPanel = new JPanel(new GridBagLayout());
        JPanel btnPanel = new JPanel();

        JLabel nameLabel = new JLabel("Name:");
        JLabel addressLabel = new JLabel("Address:");
        JLabel genderLabel = new JLabel("Gender:");
        JLabel programLabel = new JLabel("Program:");
        JLabel phoneLabel = new JLabel("Phone:");
        JLabel emailLabel = new JLabel("Email:");

        JTextField nameField = new JTextField(20);
        JTextField addressField = new JTextField(20);
        JTextField phoneField = new JTextField(20);
        JTextField emailField = new JTextField(20);

        JRadioButton jRadioBtn1 = new JRadioButton("male");
        JRadioButton jRadioBtn2 = new JRadioButton("female");
        ButtonGroup btnGroup = new ButtonGroup();
        
        btnGroup.add(jRadioBtn1);
        btnGroup.add(jRadioBtn2);

        String[] options = {"BIM", "BCA", "BBM", "CSIT", "BBA", "BHM"};
        JComboBox<String> comboBox = new JComboBox<>(options);

        JButton addBtn = new JButton("Add");
        JButton resetBtn = new JButton("Reset");
        JButton cancelBtn = new JButton("Cancel");

        btnPanel.add(addBtn);
        btnPanel.add(resetBtn);
        btnPanel.add(cancelBtn);

        addBtn.addActionListener(e -> {
            String name = nameField.getText();
            String address = addressField.getText();
            String gender = jRadioBtn1.isSelected() ? "male" : (jRadioBtn2.isSelected() ? "female" : "invalid");
            String program = (String) comboBox.getSelectedItem();
            String phone = phoneField.getText();
            String email = emailField.getText();

            String message = String.format(
                "Name: %s \nAddress: %s \nGender: %s \nProgram: %s \nPhone: %s \nEmail: %s", 
                name, address, gender, program, phone, email
            );

            JOptionPane.showMessageDialog(frame, message, "User Information", JOptionPane.INFORMATION_MESSAGE);

        });

        resetBtn.addActionListener(e -> {
            nameField.setText(null);
            addressField.setText(null);
            btnGroup.clearSelection();
            comboBox.setSelectedIndex(0);
            phoneField.setText(null);
            emailField.setText(null);
        });

        cancelBtn.addActionListener(e -> {
            System.exit(0);
        });

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(0, 0, 0, 0);
        
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        mainPanel.add(nameLabel, gbc);

        gbc.gridx = 1;
        gbc.insets = new Insets(0, 200, 0, 0);
        gbc.anchor = GridBagConstraints.EAST;
        mainPanel.add(nameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.insets = new Insets(0, 0, 0, 0);
        gbc.anchor = GridBagConstraints.WEST;
        mainPanel.add(addressLabel, gbc);

        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.EAST;
        mainPanel.add(addressField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.insets = new Insets(0, 0, 0, 0);
        gbc.anchor = GridBagConstraints.WEST;
        mainPanel.add(genderLabel, gbc);

        JPanel genderPanel = new JPanel();
        genderPanel.add(jRadioBtn1);
        genderPanel.add(jRadioBtn2);
        
        gbc.gridx = 1;
        gbc.insets = new Insets(0, 200, 0, 0);
        gbc.anchor = GridBagConstraints.CENTER;
        mainPanel.add(genderPanel, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        gbc.insets = new Insets(0, 0, 0, 0);
        gbc.anchor = GridBagConstraints.WEST;
        mainPanel.add(programLabel, gbc);

        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.EAST;
        comboBox.setPreferredSize(new Dimension(nameField.getPreferredSize().width, comboBox.getPreferredSize().height));
        mainPanel.add(comboBox, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.insets = new Insets(0, 0, 0, 0);
        gbc.anchor = GridBagConstraints.WEST;
        mainPanel.add(phoneLabel, gbc);

        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.EAST;
        mainPanel.add(phoneField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.insets = new Insets(0, 0, 0, 0);
        gbc.anchor = GridBagConstraints.WEST;
        mainPanel.add(emailLabel, gbc);

        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.EAST;
        mainPanel.add(emailField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        mainPanel.add(btnPanel, gbc);
        
        frame.add(mainPanel);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
