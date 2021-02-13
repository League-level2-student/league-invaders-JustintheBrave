import java.awt.Color;
import java.awt.Graphics;

public class Projectile extends GameObject{

	public Projectile(int locx, int locy, int sizex, int sizey) {
		super(locx, locy, sizex, sizey);
		// TODO Auto-generated constructor stub
		speed=10;
	}
	
	public void update() {
		y-=speed;
	}
	
	void draw(Graphics g) {
        g.setColor(Color.RED);
        g.fillRect(x, y, width, height);
	}

}
