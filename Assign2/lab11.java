package Assign2;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class lab11{

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setTitle("MenusBar");

        JMenuBar menuBar = new JMenuBar();

        JMenu fileMenu = new JMenu("File");
        JMenu edit = new JMenu("Edit");
        JMenu run = new JMenu("Run");
        JMenu source = new JMenu("Source");
        JMenu refactor = new JMenu("Refactor");
        JMenu nav = new JMenu("Navigate");
        JMenu search = new JMenu("Search");
        JMenu project = new JMenu("Project");
        JMenu window = new JMenu("Window");
        JMenu help = new JMenu("Help");

        JMenuItem openProject = new JMenuItem("Open Project");
        JMenuItem closeProject = new JMenuItem("Close Project");
        JMenuItem buildAll = new JMenuItem("Build All");
        JMenuItem buildProject = new JMenuItem("Build Project");

        project.add(openProject);
        project.add(closeProject);
        project.add(buildAll);
        project.add(buildProject);

        menuBar.add(fileMenu);
        menuBar.add(edit);
        menuBar.add(run);
        menuBar.add(source);
        menuBar.add(refactor);
        menuBar.add(nav);
        menuBar.add(search);
        menuBar.add(project);
        menuBar.add(window);
        menuBar.add(help);
        
        frame.setJMenuBar(menuBar);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600,600);
        frame.setVisible(true);
    }
}