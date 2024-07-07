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

        ImageIcon newImage = new ImageIcon("labAssignment4/new.png");
        ImageIcon openImage = new ImageIcon("labAssignment4/open.png");

        JMenuItem newItem = new JMenuItem("New file", newImage);
        JMenuItem openItem = new JMenuItem("Open file", openImage);

        normalMenu.add(newItem);
        normalMenu.add(openItem);

        JRadioButton jRadioBtn1 = new JRadioButton("First Radio Option");
        JRadioButton jRadioBtn2 = new JRadioButton("Second Radio Option");
        ButtonGroup btnGroup = new ButtonGroup();

        btnGroup.add(jRadioBtn1);
        btnGroup.add(jRadioBtn2);

        JCheckBox cBox1 = new JCheckBox("First Check Option");
        JCheckBox cBox2 = new JCheckBox("Second Check Option");
        
        radioMenu.add(jRadioBtn1);
        radioMenu.add(jRadioBtn2);

        checkMenu.add(cBox1);
        checkMenu.add(cBox2);

        menuBar.add(normalMenu);
        menuBar.add(radioMenu);
        menuBar.add(checkMenu);
        
        frame.setJMenuBar(menuBar);
        frame.setSize(200, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
