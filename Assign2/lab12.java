package Assign2;

import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class lab12 {
    public static void main(String[] args) {
        // Show a message dialog
        int choice = JOptionPane.showConfirmDialog(null, "Do you want to continue?", "Confirmation",
                JOptionPane.YES_NO_OPTION);
        if (choice == JOptionPane.YES_OPTION) {
            System.out.println("User chose Yes");
        } else if (choice == JOptionPane.NO_OPTION) {
            System.out.println("User chose No");
        }

        // Show a file dialog
        JFileChooser fileChooser = new JFileChooser();
        int returnValue = fileChooser.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            System.out.println("Selected file: " + selectedFile.getAbsolutePath());
        } else if (returnValue == JFileChooser.CANCEL_OPTION) {
            System.out.println("User cancelled the file selection");
        }
    }
}