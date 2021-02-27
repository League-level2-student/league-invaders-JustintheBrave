import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class Alien extends GameObject{

	public static BufferedImage image;
	public static boolean needImage = true;
	public static boolean gotImage = false;	
	
	public Alien(int locx, int locy, int sizex, int sizey) {
		super(locx, locy, sizex, sizey);
		// TODO Auto-generated constructor stub
		speed=1;
		
		if (needImage) {
		    loadImage ("alien.png");
		}
	}
	
	void loadImage(String imageFile) {
	    if (needImage) {
	        try {
	            image = ImageIO.read(this.getClass().getResourceAsStream(imageFile));
		    gotImage = true;
	        } catch (Exception e) {
	            
	        }
	        needImage = false;
	    }
	}
	
	public void update() {
		y+=speed;
		System.out.println(y);
		super.update();

	}
	
	void draw(Graphics g) {
		if (gotImage) {
			g.drawImage(image, x, y, width, height, null);
		} else {
			g.setColor(Color.BLUE);
			g.fillRect(x, y, width, height);
		}
	}

}
