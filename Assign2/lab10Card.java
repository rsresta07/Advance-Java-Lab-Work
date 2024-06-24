// import statements  

package Assign2;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class lab10Card extends JFrame implements ActionListener {
    CardLayout crd;
    // button variables to hold the references of buttons
    JButton btn1, btn2, btn3;
    Container cPane;

    // constructor of the class
    lab10Card() {
        cPane = getContentPane();
        // default constructor used
        // therefore, components will
        // cover the whole area
        crd = new CardLayout();
        cPane.setLayout(crd);
        
        // creating the buttons
        btn1 = new JButton("Apple");
        btn2 = new JButton("Boy");
        btn3 = new JButton("Cat");

        // adding listeners to it
        btn1.addActionListener(this);
        btn2.addActionListener(this);
        btn3.addActionListener(this);

        cPane.add("a", btn1); // first card is the button btn1
        cPane.add("b", btn2); // first card is the button btn2
        cPane.add("c", btn3); // first card is the button btn3

    }

    public void actionPerformed(ActionEvent e) {
        // Upon clicking the button, the next card of the container is shown
        // after the last card, again, the first card of the container is shown upon
        // clicking
        crd.next(cPane);
    }

    // main method
    public static void main(String args[]) {
        // creating an object of the class CardLayoutExample1
        lab10Card crdl = new lab10Card();

        // size is 300 * 300
        crdl.setSize(300, 300);
        crdl.setVisible(true);
        crdl.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}