
package project1;

import javax.swing.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
public class Project1 {

    
    public static void main(String[] args) {
            JFrame jf = new Play();
            jf.setSize(1000,800);
            jf.setTitle("Protect the Treasure");
            jf.setDefaultCloseOperation(EXIT_ON_CLOSE);
            jf.setVisible(true);
            jf.setLocationRelativeTo(null);
    }
    
}
