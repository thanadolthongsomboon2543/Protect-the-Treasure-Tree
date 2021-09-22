
package project1;

import java.awt.*;
import javax.swing.*;
public class Home extends JPanel {
    
        ImageIcon home = new ImageIcon(this.getClass().getResource("Homescreen.jpg"));
	ImageIcon exit = new ImageIcon(this.getClass().getResource("Exit.jpg"));
        ImageIcon title = new ImageIcon(this.getClass().getResource("Title.jpg"));
	ImageIcon starts = new ImageIcon(this.getClass().getResource("Start.jpg"));
	public JButton BStart = new JButton(starts);
	public JButton BExit  = new JButton(exit);
        
        Home(){
            setLayout(null);
            BExit.setBounds(500, 650, 150,90);
            add(BExit);
            add(BStart);
            BStart.setBounds(750,650,220,90);
            add(BStart);
        }
    public void paintComponent(Graphics g){
            super.paintComponent(g);
            g.drawImage(home.getImage(),0,0,1000,800,this);
            g.drawImage(title.getImage(), 100, 200, 731, 231, this);

	}
    
}
