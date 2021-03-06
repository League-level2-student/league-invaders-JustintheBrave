import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener{
	final int MENU = 0;
	final int GAME = 1;
	final int END = 2;
	int currentState = MENU;
	
	Font titleFont;
	Font menuFont;
	
	Timer frameDraw;
	Timer alienSpawn;
	
	RocketShip rocket = new RocketShip(250,640,50,50);
	ObjectManager manager = new ObjectManager(rocket);
	
	public static BufferedImage image;
	public static boolean needImage = true;
	public static boolean gotImage = false;	

	public void startGame() {
		alienSpawn = new Timer(1000 , manager);
	    alienSpawn.start();
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
	
	public GamePanel() {
		titleFont = new Font("Arial", Font.PLAIN, 48);
		menuFont = new Font("Arial", Font.PLAIN, 24);
		
		frameDraw = new Timer(1000/60, this);
		frameDraw.start();
		
		if (needImage) {
		    loadImage ("space.png");
		}
	}
	
	@Override
	public void paintComponent(Graphics g){
		if(currentState == MENU){
		    drawMenuState(g);
		}else if(currentState == GAME){
		    drawGameState(g);
		}else if(currentState == END){
		    drawEndState(g);
		}
	}
	
	 public void updateMenuState() {  
		
	 }
	 public void updateGameState() { 
		 manager.update();
		 if(rocket.isActive==false) {
			 currentState=END;
		 }
	 }
	 public void updateEndState()  { 
		 
	 }
	 
	 public void drawMenuState(Graphics g) { 		 
		 g.setColor(Color.BLUE);
		 g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
		 
		 g.setFont(titleFont);
		 g.setColor(Color.YELLOW);
		 g.drawString("LEAGUE INVADERS", 25, 100);
		 
		 g.setFont(menuFont);
		 g.drawString("Press ENTER to begin", 120, 350);
		 g.drawString("Press SPACE for instructions", 100, 600);
	 }
	 public void drawGameState(Graphics g) { 
		 if (gotImage) {
				g.drawImage(image, 0,0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT, null);
			} else {
				g.setColor(Color.BLUE);
				g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
			}
		 
		 manager.draw(g);
		 g.setColor(Color.WHITE);
		 g.drawString(manager.getScore() + "", 50, 50);
		 
		
	 }
	 public void drawEndState(Graphics g)  { 
		 g.setColor(Color.RED);
		 g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
		 
		 g.setFont(titleFont);
		 g.setColor(Color.YELLOW);
		 g.drawString("LEAGUE INVADERS", 25, 100);
		 
		 g.setFont(menuFont);
		 g.setColor(Color.YELLOW);
		 g.drawString("YOU WERE KILLED", 120, 350);
		 g.drawString("Press ENTER to restart", 100, 600);
		 
	 }

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(currentState == MENU){
		    updateMenuState();
		}else if(currentState == GAME){
		    updateGameState();
		}else if(currentState == END){
		    updateEndState();
		}
		
		
		repaint();
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode()==KeyEvent.VK_ENTER) {
		    if (currentState == END) {
		        currentState = MENU;
		        
		        rocket = new RocketShip(250,640,50,50);
				manager = new ObjectManager(rocket);
		    } 
		    else {
		        currentState++;
		    }
		    if(currentState == GAME) {
		    	startGame();
		    }
		    if(currentState == END) {
		    	alienSpawn.stop();
		    }
		   
		    
		    }
		if (e.getKeyCode()==KeyEvent.VK_UP) {
			  if(currentState==GAME) {
				  if(rocket.y>=0)
				  	rocket.up();
		}
	}
		
		if (e.getKeyCode()==KeyEvent.VK_RIGHT) {
			  if(currentState==GAME) {
				  if(rocket.x<=450) {
				  	rocket.right();
				  }
		}
	}
		
		if (e.getKeyCode()==KeyEvent.VK_DOWN) {
			  if(currentState==GAME) {
				  if(rocket.y<=650) {
					  rocket.down();
				  }
		}
	}
		
		if (e.getKeyCode()==KeyEvent.VK_LEFT) {
			  if(currentState==GAME) {
				  if(rocket.x>=0) {
					  rocket.left();
			  }
		}
	}
		if(e.getKeyCode()==KeyEvent.VK_SPACE) {
			if(currentState==GAME) {
				manager.addProjectile(rocket.getProjectile());
			}
		}
		}
	
		
	
		

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
