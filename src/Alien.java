import java.awt.Color;
import java.awt.Graphics;

public class Alien extends GameObject{

	public Alien(int locx, int locy, int sizex, int sizey) {
		super(locx, locy, sizex, sizey);
		// TODO Auto-generated constructor stub
		speed=1;
	}
	
	public void update() {
		y+=speed;
	}
	
	void draw(Graphics g) {
        g.setColor(Color.YELLOW);
        g.fillRect(x, y, width, height);
	}

}
