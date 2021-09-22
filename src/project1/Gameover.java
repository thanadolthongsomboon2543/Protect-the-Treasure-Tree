
package project1;

import java.awt.*;
import javax.swing.*;

public class Gameover extends JPanel{
        ImageIcon gameover = new ImageIcon(this.getClass().getResource("gameover.gif"));
	ImageIcon exit = new ImageIcon(this.getClass().getResource("Exit.jpg"));
	ImageIcon restarts = new ImageIcon(this.getClass().getResource("Restart.jpg"));
	public JButton BRestart = new JButton(restarts);
	public JButton BExit = new JButton(exit);
        
        Gameover(){
            this.setLayout(null);
		BRestart.setBounds(500, 850, 150,90);
		add(BRestart);
		
		BExit.setBounds(500,650,150,90);
                add(BExit);
		
        }
        public void paintComponent(Graphics g){
		  super.paintComponent(g);
		  g.drawImage(gameover.getImage(),0,0,1000,800,this);
                  g.setColor(Color.BLACK);
                  g.setFont(new Font("Papyrus",Font.CENTER_BASELINE,90));		
                  g.drawString("Game Over",70,200);	
        
}
}