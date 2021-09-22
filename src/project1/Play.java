
package project1;

import java.awt.event.*;
import javax.swing.*;
public class Play extends JFrame implements ActionListener{
    
    Home hg= new Home();
    gameplay game=new gameplay();
    Gameover over=new Gameover();
    
    
    public Play(){
        this.setSize(1000,800);
        this.add(hg);
        hg.BExit.addActionListener(this);
        hg.BStart.addActionListener(this);
        game.BExitover.addActionListener(this);
        game.BPause.addActionListener(this);
        game.BResume.addActionListener(this);
        game.BStartover.addActionListener(this);
        over.BExit.addActionListener(this);
        over.BRestart.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==hg.BStart)
        {
            this.setLocationRelativeTo(null);
		this.remove(hg);
                this.setSize(1000,800);
                this.add(game);
                game.requestFocusInWindow();
                game.timestart=false;
                game.startthief=false;
                game.times=60;
                game.timestart=false;
        }
        else if(e.getSource()==hg.BExit)
        {
            System.exit(0);
        }
        else if(e.getSource()==game.BExitover)
        {
         System.exit(0);
        }
        else if(e.getSource()==game.BPause)
        {
            this.setLocationRelativeTo(null);
		this.setSize(1000,800);
		this.add(game);
		game.requestFocusInWindow();
		game.t.suspend();
		game.time.suspend();
		game.tthief1.suspend();
                game.tthief2.suspend();
                game.tthief3.suspend();
                game.tthief4.suspend();
                game.actor.suspend();
        }
        else if(e.getSource()==game.BResume)
        {
            this.setSize(1000,800);
		this.add(game);
		game.requestFocusInWindow();
		game.t.resume();
		game.time.resume();
		game.tthief1.resume();
                game.tthief2.resume();
                game.tthief3.resume();
                game.tthief4.resume();
                game.actor.resume();
        }
        else if(e.getSource()==over.BRestart)
        {
            this.remove(over);
            this.setSize(1000,800);
                this.add(game);
                game.requestFocusInWindow();
                game.timestart=false;
                game.startthief=false;
                game.times=60;
                game.timestart=false;
        }
        else if(e.getSource()==over.BExit)
        {
            System.exit(0);
        }
        this.validate();
        this.repaint();
    }
     public static void main(String[] args) {
            JFrame jf = new Play();
            jf.setSize(1000,800);
            jf.setTitle("Protect the Treasure");
            jf.setDefaultCloseOperation(EXIT_ON_CLOSE);
            jf.setVisible(true);
            jf.setLocationRelativeTo(null);
    }    
    
}
