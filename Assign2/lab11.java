package Assign2;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class lab11 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("MenusBar");

        JMenuBar menuBar = new JMenuBar();
        String[] menuNames = { "File", "Edit", "Run", "Source", "Refactor", "Navigate", "Search", "Project", "Window",
                "Help" };
        for (String name : menuNames) {
            menuBar.add(new JMenu(name));
        }

        JMenu project = (JMenu) menuBar.getMenu(7);
        String[] projectItems = { "Open Project", "Close Project", "Build All", "Build Project" };
        for (String item : projectItems) {
            project.add(new JMenuItem(item));
        }

        frame.setJMenuBar(menuBar);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 600);
        frame.setVisible(true);
    }
}