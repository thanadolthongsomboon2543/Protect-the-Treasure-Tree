
package project1;

import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.net.URL;
import javax.swing.*;
public class Theif {
    Image img;
    public int x=0;
    public int y= (int) ((Math.random()*300)+20);
    public int count=0;
    Theif()
    {
        String imageLocation = "thief.png";
                URL imageURL = this.getClass().getResource(imageLocation);
		img = Toolkit.getDefaultToolkit().getImage(imageURL);
		runner.start();
    }
    Thread runner = new Thread(new Runnable() {
            public void run() {
		while(true){
                    x += 2;
                    if(x >= 1100){
			img = null;
			runner = null;
			x = -500;
			y = -500;
                    }
                    try{
			runner.sleep(10);
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
