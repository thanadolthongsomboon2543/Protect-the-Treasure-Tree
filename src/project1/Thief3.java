
package project1;

import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.net.URL;
import javax.swing.*;
public class Thief3 {
    Image img;
    public int x=(int)((Math.random()*300)+20);
    public int y=800;
     public int count=0;
    Thief3(){
        
    String imageLocation = "thief.png";
                URL imageURL = this.getClass().getResource(imageLocation);
		img = Toolkit.getDefaultToolkit().getImage(imageURL);
		runner.start();
    }
    Thread runner = new Thread(new Runnable() {
            public void run() {
		while(true){
                    y -= 2;
                    if( y<=-10){
			img = null;
			runner = null;
			x = -500;
			y = -500;
                    }
                    try{
			runner.sleep(20);
                    }catch(InterruptedException e){}
                }
            }
	});
	
	public Image getImage(){
            return img;
	}
	public void setX(int x)
        {
            this.x=x;
        }
        public void setY(int y)
        {
            this.y=y;
        }
	public int getX(){
            return x;
	}
	public int getY(){
            return y;
	}
	public Rectangle2D getbound(){
    	    return (new Rectangle2D.Double(x,y,45,45));
	}
    
    
    
}
