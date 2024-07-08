package Assign4;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JRadioButton;

public class lab14 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Rameshwor");
        JMenuBar menuBar = new JMenuBar();

        JMenu normalMenu = new JMenu("Normal Menu");
        JMenu radioMenu = new JMenu("Radio Menu");
        JMenu checkMenu = new JMenu("Check Menu");

        normalMenu.add(new JMenuItem("New file", new ImageIcon("labAssignment4/new.png")));
        normalMenu.add(new JMenuItem("Open file", new ImageIcon("labAssignment4/open.png")));

        ButtonGroup btnGroup = new ButtonGroup();
        JRadioButton radioBtn1 = new JRadioButton("First Radio Option");
        JRadioButton radioBtn2 = new JRadioButton("Second Radio Option");
        btnGroup.add(radioBtn1);
        btnGroup.add(radioBtn2);
        radioMenu.add(radioBtn1);
        radioMenu.add(radioBtn2);

        checkMenu.add(new JCheckBox("First Check Option"));
        checkMenu.add(new JCheckBox("Second Check Option"));

        menuBar.add(normalMenu);
        menuBar.add(radioMenu);
        menuBar.add(checkMenu);

        frame.setJMenuBar(menuBar);
        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}