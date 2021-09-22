
package project1;

import java.util.*;
import java.awt.event.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;
import javax.swing.*;
import java.net.URL;
public class gameplay extends JPanel implements ActionListener {
    
   final ImageIcon stage1= new ImageIcon(this.getClass().getResource("stage1.jpg"));
   final ImageIcon stage2= new ImageIcon(this.getClass().getResource("stage2.png"));
   final ImageIcon stage3= new ImageIcon(this.getClass().getResource("stage3.jpg"));
   final ImageIcon chest = new ImageIcon(this.getClass().getResource("Chest.png"));
   final ImageIcon pause = new ImageIcon(this.getClass().getResource("pause.jpg"));
   final ImageIcon resume = new ImageIcon(this.getClass().getResource("play.jpg"));
    
        
        
        ImageIcon gameover = new ImageIcon(this.getClass().getResource("gameover.gif"));
	
	ImageIcon exitover = new ImageIcon(this.getClass().getResource("Exit.jpg"));
	ImageIcon restart = new ImageIcon(this.getClass().getResource("Restart.jpg"));
        public JButton BStartover = new JButton(restart);
	public JButton BExitover  = new JButton(exitover);
     
        Home hg = new Home();
        
        public JLabel score = new JLabel(); 
        public JButton BPause  = new JButton(pause); 
	public JButton BResume  = new JButton(resume);
        public ArrayList<Theif>t1=new ArrayList<Theif>();
        public ArrayList<Thief2>t2=new ArrayList<Thief2>();
        public ArrayList<Thief3>t3=new ArrayList<Thief3>();
        public ArrayList<Thief4>t4=new ArrayList<Thief4>();
        
        public int times  ;
	public int rs1 = 1;
	public int rs2 = 2;
        public int rs3 = 3;
	boolean timestart = true;
	boolean startthief = false;
    
        private Gameover gover = new Gameover();
    
    Thread time = new Thread(new Runnable(){
            public void run(){
		while(true){
                    try{
			Thread.sleep(10);
                    }catch(Exception e){ }
                    
                    if(timestart == false){
			repaint();
                    }
		}
            }
	});
     Thread actor = new Thread(new Runnable(){
            public void run(){
		while(true){
                	try{
                            Thread.sleep(1);
			}catch(Exception e){}
                            repaint();
		}
            }
	});
    
    Thread tthief1 = new Thread(new Runnable(){
            public void run() {
                while(true){
                	try{
                            if(startthief == false){
				Thread.sleep((long)(Math.random()*10000)+2000);
                            }
			}catch(InterruptedException e){
                            e.printStackTrace();
			}
			if(startthief == false){
                            t1.add(new Theif());
			}
		}
            }
	});
	 Thread tthief2 = new Thread(new Runnable(){
            public void run() {
                while(true){
                	try{
                            if(startthief == false){
				Thread.sleep((long)(Math.random()*10000)+2000);
                            }
			}catch(InterruptedException e){
                            e.printStackTrace();
			}
			if(startthief == false){
                            t2.add(new Thief2());
			}
		}
            }
	});
	Thread tthief3 = new Thread(new Runnable(){
            public void run() {
                while(true){
                	try{
                            if(startthief == false){
				Thread.sleep((long)(Math.random()*10000)+2000);
                            }
			}catch(InterruptedException e){
                            e.printStackTrace();
			}
			if(startthief == false){
                            t3.add(new Thief3());
			}
		}
            }
	});
    Thread tthief4 = new Thread(new Runnable(){
            public void run() {
                while(true){
                	try{
                            if(startthief == false){
				Thread.sleep((long)(Math.random()*10000)+2000);
                            }
			}catch(InterruptedException e){
                            e.printStackTrace();
			}
			if(startthief == false){
                            t4.add(new Thief4());
			}
		}
            }
	});
    
     Thread t = new Thread(new Runnable(){
            public void run() {
		while(true){
                	if(timestart == false){
                            
                            times = (times-1) ;
                           
			}
			try{
                            Thread.sleep(1000);
			}catch(InterruptedException e)
			{
                            e.printStackTrace();
			}
		}
            }
	});
    
    
    gameplay()
    {           this.setFocusable(true);
		this.setLayout(null);
                BStartover.addActionListener(this);
                BExitover.addActionListener(this);
                BPause.setBounds(850,100,40,40);
                BResume.setBounds(850,150, 40, 40);
                BPause.addActionListener(this);
                BResume.addActionListener(this);
                this.add(BPause);
                this.add(BResume) ;
                this.addMouseListener(new MouseListener(){
                    @Override
                    public void mouseClicked(MouseEvent e) {
                       
                        if(e.getSource()==t1)
                       {
                         t1.removeAll(t1);
                       }
                       else if(e.getSource()==t2)
                       {
                         t2.removeAll(t2);
                       }
                       else if(e.getSource()==t3)
                       {
                         t3.removeAll(t3);
                       }
                       else if(e.getSource()==t4)
                       {
                         t4.removeAll(t4);
                       }
                    }

                    @Override
                    public void mousePressed(MouseEvent e) {
                        
                    }

                    @Override
                    public void mouseReleased(MouseEvent e) {
                        
                    }

                    @Override
                    public void mouseEntered(MouseEvent e) {
                        
                    }

                    @Override
                    public void mouseExited(MouseEvent e) {
                       
                    }
                    
                });
                        this.add(score);
               
                actor.start();        
                t.start();
                time.start();
                tthief1.start();
                tthief2.start();
                tthief3.start();
                tthief4.start();
              
    }
    
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        if(times==0)
        {
             t.stop();
                actor.stop();
                time.stop();
                tthief1.stop();
                tthief2.stop();
                tthief3.stop();
                tthief4.stop();
            this.remove(BPause);
            this.remove(BResume);
            BStartover.setBounds(750, 650, 300,90);
            BExitover.setBounds(500, 650, 220, 90);
            this.add(BStartover);
            this.add(BExitover);
            this.setLayout(null);
            g.drawImage(gameover.getImage(),0,0,1000,800,this);
            g.setColor(Color.BLACK);
                g.setFont(new Font("Papyrus",Font.HANGING_BASELINE,40));		   
                g.setFont(new Font("Papyrus",Font.HANGING_BASELINE,70));
                g.drawString("Congratulation",290,100);
                g.drawString("You Win!",310, 150);
        }
        else if(times<=40)
        {
            g.drawImage(stage2.getImage(), 0,0 ,1000,800, this);
            g.drawImage(chest.getImage(), 500,400,200,200,this);
            
            //======thief1========
            for(int i=0;i<t1.size();i++)
            {
                g.drawImage(t1.get(i).getImage(), t1.get(i).getX(),t1.get(i).getY(), 100, 100, this);
            }
            for(int i=0;i<t1.size();i++){
                if(Intersect(t1.get(i).getbound(),k))
                {
                    t1.removeAll(t1);
                     this.remove(BPause);
            this.remove(BResume);
            
                t.stop();
                actor.stop();
                time.stop();
                tthief1.stop();
                tthief2.stop();
                tthief3.stop();
                tthief4.stop();
               g.drawImage(gameover.getImage(),0,0,1000,800,this);
                g.setColor(Color.BLACK);
                g.setFont(new Font("Papyrus",Font.HANGING_BASELINE,40));		   
                g.setFont(new Font("Papyrus",Font.HANGING_BASELINE,70));
                g.drawString("Game Over",290,50);
                g.drawString("Continue?",290, 100);
             BStartover.setBounds(750, 650, 300,90);
            BExitover.setBounds(300, 650, 220, 90);
            this.setLayout(null);
             this.add(BStartover);
            this.add(BExitover);
          
                }
            }
            //======thief2=====
            for(int i=0;i<t2.size();i++)
            {
                g.drawImage(t2.get(i).getImage(), t2.get(i).getX(),t2.get(i).getY(), 100, 100, this);
            }
            for(int i=0;i<t2.size();i++){
                if(Intersect(t2.get(i).getbound(),k))
                {
                    t2.removeAll(t2);
                     this.remove(BPause);
            this.remove(BResume);
            t.stop();
                actor.stop();
                time.stop();
                tthief1.stop();
                tthief2.stop();
                tthief3.stop();
                tthief4.stop();
           
               g.drawImage(gameover.getImage(),0,0,1000,800,this);
                g.setColor(Color.BLACK);
                g.setFont(new Font("Papyrus",Font.HANGING_BASELINE,40));		   
                g.setFont(new Font("Papyrus",Font.HANGING_BASELINE,70));
                g.drawString("Game Over",290,150);
                g.drawString("Continue?",290, 100);
             BStartover.setBounds(750, 650, 300,90);
            BExitover.setBounds(300, 650, 220, 90);
            this.setLayout(null);
             this.add(BStartover);
            this.add(BExitover);
        }
        
    }
            //======thief3======
            for(int i=0;i<t3.size();i++)
            {
                g.drawImage(t3.get(i).getImage(), t3.get(i).getX(),t3.get(i).getY(), 100, 100, this);
            }
            for(int i=0;i<t3.size();i++){
                if(Intersect(t3.get(i).getbound(),k))
                {
                    t3.removeAll(t3);
                     this.remove(BPause);
            this.remove(BResume);
             t.stop();
                actor.stop();
                time.stop();
                tthief1.stop();
                tthief2.stop();
                tthief3.stop();
                tthief4.stop();
            
               g.drawImage(gameover.getImage(),0,0,1000,800,this);
                g.setColor(Color.BLACK);
                g.setFont(new Font("Papyrus",Font.HANGING_BASELINE,40));		   
                g.setFont(new Font("Papyrus",Font.HANGING_BASELINE,70));
                g.drawString("Game Over",290,150);
                g.drawString("Continue?",290, 100);
               BStartover.setBounds(750, 650, 300,90);
            BExitover.setBounds(300, 650, 220, 90);
           this.setLayout(null);
             this.add(BStartover);
            this.add(BExitover);
                }
            } 
            //======thief4======
            for(int i=0;i<t4.size();i++)
            {
                g.drawImage(t4.get(i).getImage(), t4.get(i).getX(),t4.get(i).getY(), 100, 100, this);
            }
            for(int i=0;i<t4.size();i++){
                if(Intersect(t4.get(i).getbound(),k))
                {
                    t4.removeAll(t4);
                     this.remove(BPause);
            this.remove(BResume);
             t.stop();
                actor.stop();
                time.stop();
                tthief1.stop();
                tthief2.stop();
                tthief3.stop();
                tthief4.stop();
            BStartover.setBounds(750, 650, 300,90);
            BExitover.setBounds(300, 650, 220, 90);
           this.setLayout(null);
             this.add(BStartover);
            this.add(BExitover);
                g.drawImage(gameover.getImage(),0,0,1000,800,this);
                g.setColor(Color.BLACK);
                g.setFont(new Font("Papyrus",Font.HANGING_BASELINE,40));		   
                g.setFont(new Font("Papyrus",Font.HANGING_BASELINE,70));
                g.drawString("Game Over",290,50);
                g.drawString("Continue?",290, 100);
               
                }
            } 
            g.setFont(new Font("Hobo Std",Font.HANGING_BASELINE,30));
		g.setColor(Color.BLACK);   
		g.setFont(new Font("Hobo Std",Font.HANGING_BASELINE,50));
		g.drawString("Stage "+rs2,350,80);
		g.drawString("Time "+times,335,150);
          
        }
        else if(times<=30)
        {
            g.drawImage(stage3.getImage(), 0,0 ,1000,800, this);
            g.drawImage(chest.getImage(), 500,400,300,300,this);
            
            //======thief1========
            for(int i=0;i<t1.size();i++)
            {
                g.drawImage(t1.get(i).getImage(), t1.get(i).getX(),t1.get(i).getY(), 50, 50, this);
            }
            for(int i=0;i<t1.size();i++){
                if(Intersect(t1.get(i).getbound(),k))
                {
                    t1.removeAll(t1);
                     this.remove(BPause);
            this.remove(BResume);
             t.stop();
                actor.stop();
                time.stop();
                tthief1.stop();
                tthief2.stop();
                tthief3.stop();
                tthief4.stop();
             
               g.drawImage(gameover.getImage(),0,0,1000,800,this);
                g.setColor(Color.BLACK);
                g.setFont(new Font("Papyrus",Font.HANGING_BASELINE,40));		   
                g.setFont(new Font("Papyrus",Font.HANGING_BASELINE,70));
                g.drawString("Game Over",290,50);
                g.drawString("Continue?",290, 100);
              BStartover.setBounds(750, 650, 300,90);
               BExitover.setBounds(300, 650, 220, 90);
              this.setLayout(null);
              this.add(BStartover);
              this.add(BExitover);
           
                }
            }
            //======thief2=====
            for(int i=0;i<t2.size();i++)
            {
                g.drawImage(t2.get(i).getImage(), t2.get(i).getX(),t2.get(i).getY(), 50, 50, this);
            }
            for(int i=0;i<t2.size();i++){
                if(Intersect(t2.get(i).getbound(),k))
                {
                    t2.removeAll(t2);
                     this.remove(BPause);
            this.remove(BResume);
             t.stop();
                actor.stop();
                time.stop();
                tthief1.stop();
                tthief2.stop();
                tthief3.stop();
                tthief4.stop();
            
               g.drawImage(gameover.getImage(),0,0,1000,800,this);
                g.setColor(Color.BLACK);
                g.setFont(new Font("Papyrus",Font.HANGING_BASELINE,40));		   
                g.setFont(new Font("Papyrus",Font.HANGING_BASELINE,70));
                g.drawString("Game Over",290,50);
                g.drawString("Continue?",290, 100);
             BStartover.setBounds(750, 650, 300,90);
            BExitover.setBounds(300, 650, 220, 90);
            this.setLayout(null);
             this.add(BStartover);
            this.add(BExitover);
        }
        
    }
            //======thief3======
            for(int i=0;i<t3.size();i++)
            {
                g.drawImage(t3.get(i).getImage(), t3.get(i).getX(),t3.get(i).getY(), 50, 50, this);
            }
            for(int i=0;i<t3.size();i++){
                if(Intersect(t3.get(i).getbound(),k))
                {
                    t3.removeAll(t3);
                     this.remove(BPause);
            this.remove(BResume);
            
             t.stop();
                actor.stop();
                time.stop();
                tthief1.stop();
                tthief2.stop();
                tthief3.stop();
                tthief4.stop();
           
               g.drawImage(gameover.getImage(),0,0,1000,800,this);
                g.setColor(Color.BLACK);
                g.setFont(new Font("Papyrus",Font.HANGING_BASELINE,40));		   
                g.setFont(new Font("Papyrus",Font.HANGING_BASELINE,70));
                g.drawString("Game Over",290,50);
                g.drawString("Continue?",290, 100);
               BStartover.setBounds(750, 650, 300,90);
            BExitover.setBounds(300, 650, 220, 90);
           this.setLayout(null);
             this.add(BStartover);
            this.add(BExitover);
                }
            } 
            //======thief4======
            for(int i=0;i<t4.size();i++)
            {
                g.drawImage(t4.get(i).getImage(), t4.get(i).getX(),t4.get(i).getY(), 50, 50, this);
            }
            for(int i=0;i<t4.size();i++){
                if(Intersect(t4.get(i).getbound(),k))
                {
                    t4.removeAll(t4);
                     this.remove(BPause);
            this.remove(BResume);
             t.stop();
                actor.stop();
                time.stop();
                tthief1.stop();
                tthief2.stop();
                tthief3.stop();
                tthief4.stop();
            
               g.drawImage(gameover.getImage(),0,0,1000,800,this);
                g.setColor(Color.BLACK);
                g.setFont(new Font("Papyrus",Font.HANGING_BASELINE,40));		   
                g.setFont(new Font("Papyrus",Font.HANGING_BASELINE,70));
                g.drawString("Game Over",290,50);
                g.drawString("Continue?",290, 100);
              BStartover.setBounds(750, 650, 300,90);
            BExitover.setBounds(300, 650, 220, 90);
           this.setLayout(null);
             this.add(BStartover);
            this.add(BExitover);
                }
            } 
            g.setFont(new Font("Hobo Std",Font.HANGING_BASELINE,30));
		g.setColor(Color.BLACK);   
		g.setFont(new Font("Hobo Std",Font.HANGING_BASELINE,50));
		g.drawString("Stage "+rs3,350,80);
		g.drawString("Time "+times,335,150);
  
        }
        else{
             g.drawImage(stage1.getImage(), 0,0 ,1000,800, this);
             g.drawImage(chest.getImage(), 500,400,100, 100,this);
            
            //======thief1========
            for(int i=0;i<t1.size();i++)
            {
                g.drawImage(t1.get(i).getImage(), t1.get(i).getX(),t1.get(i).getY(), 50, 50, this);
            }
            for(int i=0;i<t1.size();i++){
                if(Intersect(t1.get(i).getbound(),k))
                {
                   t1.removeAll(t1);
                     this.remove(BPause);
            this.remove(BResume);
             t.stop();
                actor.stop();
                time.stop();
                tthief1.stop();
                tthief2.stop();
                tthief3.stop();
                tthief4.stop();
           
               g.drawImage(gameover.getImage(),0,0,1000,800,this);
                g.setColor(Color.BLACK);
                g.setFont(new Font("Papyrus",Font.HANGING_BASELINE,40));		   
                g.setFont(new Font("Papyrus",Font.HANGING_BASELINE,70));
                g.drawString("Game Over",290,50);
                g.drawString("Continue?",290, 100);
             BStartover.setBounds(750, 650, 300,90);
            BExitover.setBounds(300, 650, 220, 90);
            this.setLayout(null);
             this.add(BStartover);
            this.add(BExitover);
         
                }
            }
            //======thief2=====
            for(int i=0;i<t2.size();i++)
            {
                g.drawImage(t2.get(i).getImage(), t2.get(i).getX(),t2.get(i).getY(), 50, 50, this);
            }
            for(int i=0;i<t2.size();i++){
                if(Intersect(t2.get(i).getbound(),k))
                {
                    t2.removeAll(t2);
                     this.remove(BPause);
            this.remove(BResume);
             t.stop();
                actor.stop();
                time.stop();
                tthief1.stop();
                tthief2.stop();
                tthief3.stop();
                tthief4.stop();
            
               g.drawImage(gameover.getImage(),0,0,1000,800,this);
                g.setColor(Color.BLACK);
                g.setFont(new Font("Papyrus",Font.HANGING_BASELINE,40));		   
                g.setFont(new Font("Papyrus",Font.HANGING_BASELINE,70));
                g.drawString("Game Over",290,50);
                g.drawString("Continue?",290, 100);
                BStartover.setBounds(750, 650, 300,90);
            BExitover.setBounds(300, 650, 220, 90);
            this.setLayout(null);
             this.add(BStartover);
            this.add(BExitover);
        }
        
    }
            //======thief3======
            for(int i=0;i<t3.size();i++)
            {
                g.drawImage(t3.get(i).getImage(), t3.get(i).getX(),t3.get(i).getY(), 50, 50, this);
            }
            for(int i=0;i<t3.size();i++){
                if(Intersect(t3.get(i).getbound(),k))
                {
                    t3.removeAll(t3);
                     this.remove(BPause);
            this.remove(BResume);
             t.stop();
                actor.stop();
                time.stop();
                tthief1.stop();
                tthief2.stop();
                tthief3.stop();
                tthief4.stop();
           
               g.drawImage(gameover.getImage(),0,0,1000,800,this);
                g.setColor(Color.BLACK);
                g.setFont(new Font("Papyrus",Font.HANGING_BASELINE,40));		   
                g.setFont(new Font("Papyrus",Font.HANGING_BASELINE,70));
                g.drawString("Game Over",290,50);
                g.drawString("Continue?",290, 100);
                 BStartover.setBounds(750, 650, 300,90);
            BExitover.setBounds(300, 650, 220, 90);
           this.setLayout(null);
             this.add(BStartover);
            this.add(BExitover);
                
                }
            } 
            //======thief4======
            for(int i=0;i<t4.size();i++)
            {
                g.drawImage(t4.get(i).getImage(), t4.get(i).getX(),t4.get(i).getY(), 50, 50, this);
            }
            for(int i=0;i<t4.size();i++){
                if(Intersect(t4.get(i).getbound(),k))
                {
                    t4.removeAll(t4);
                    
                     this.remove(BPause);
            this.remove(BResume);
             t.stop();
                actor.stop();
                time.stop();
                tthief1.stop();
                tthief2.stop();
                tthief3.stop();
                tthief4.stop();
           
               g.drawImage(gameover.getImage(),0,0,1000,800,this);
                g.setColor(Color.BLACK);
                g.setFont(new Font("Papyrus",Font.HANGING_BASELINE,40));		   
                g.setFont(new Font("Papyrus",Font.HANGING_BASELINE,70));
                g.drawString("Game Over",290,50);
                g.drawString("Continue?",290, 100);
                 BStartover.setBounds(500, 650, 300,90);
            BExitover.setBounds(300, 650, 220, 90);
           this.setLayout(null);
             this.add(BStartover);
            this.add(BExitover);
                }
            } 
                g.setFont(new Font("Hobo Std",Font.HANGING_BASELINE,30));
		g.setColor(Color.YELLOW);   
		g.setFont(new Font("Hobo Std",Font.HANGING_BASELINE,50));
		g.drawString("Stage "+rs1,350,80);
		g.drawString("Time "+times,335,150);
        }
        
    }
        
        
        
        
        
        
        
        
    
        



    
    
    
    
    public Rectangle2D k=getbound();
   
    public static Rectangle2D getbound(){
    	    return (new Rectangle2D.Double(500,400,100,100));
	}
      
    
    
    
    public boolean Intersect(Rectangle2D a, Rectangle2D b){
		return (a.intersects(b));
	}
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
		if(e.getSource()== BStartover){		
                    this.setSize(1000,800);
                    this.add(hg);
                    this.setLocation(null);
                    timestart = true;
                    startthief = true;
		}else if(e.getSource() == BExitover){
                    System.exit(0);
		}		
	}

   
   
}
