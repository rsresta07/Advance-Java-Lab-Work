package Assign2;

import javax.swing.*;

public class NumericInputExample {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Numeric Input Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a SpinnerNumberModel with initial value, minimum, maximum, and step
        // size
        SpinnerNumberModel model = new SpinnerNumberModel(0, 0, 100, 1);

        // Create a JSpinner with the model
        JSpinner spinner = new JSpinner(model);

        // Optionally set the editor to a JFormattedTextField to handle formatting
        JSpinner.NumberEditor editor = new JSpinner.NumberEditor(spinner, "#");
        spinner.setEditor(editor);

        frame.getContentPane().add(spinner);
        frame.pack();
        frame.setVisible(true);
    }
}
