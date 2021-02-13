import java.awt.Color;
import java.awt.Graphics;

public class RocketShip extends GameObject{

	
	
	public RocketShip(int locx, int locy, int sizex, int sizey) {
		super(locx, locy, sizex, sizey);
		// TODO Auto-generated constructor stub
		speed=10;
	}

	void draw(Graphics g) {
		 g.setColor(Color.BLUE);
	        g.fillRect(x, y, width, height);
	}
	
	 public void right() {
	        x+=speed;
	    }
	 public void left() {
	        x-=speed;
	    }
	 public void up() {
	        y-=speed;
	    }
	 public void down() {
	        y+=speed;
	    }

}
