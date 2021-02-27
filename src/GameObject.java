import java.awt.Rectangle;


public class GameObject {
	 int x;
	 int y;
	 int width;
	 int height;
	 int speed=0;
	 boolean isActive = true;
	 
	 Rectangle collisionBox;
	 
	 public GameObject(int locx, int locy,int sizex,int sizey) {
		 this.x=locx;
		 this.y=locy;
		 this.width=sizex;
		 this.height=sizey;
		 
		 collisionBox = new Rectangle(x,y,width,height);
	 }
	 
	 public void update() {
		 collisionBox.setBounds(x, y, width, height);
	 }
}
