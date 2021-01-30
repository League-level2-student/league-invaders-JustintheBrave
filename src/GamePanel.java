import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;

public class GamePanel extends JPanel {
	final int MENU = 0;
	final int GAME = 1;
	final int END = 2;
	int currentState = MENU;
	
	Font titleFont;
	Font menuFont;
	
	public GamePanel() {
		titleFont = new Font("Arial", Font.PLAIN, 48);
		menuFont = new Font("Arial", Font.PLAIN, 24);
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
		 g.setColor(Color.BLACK);
		 g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
	 }
	 public void drawEndState(Graphics g)  { 
		 g.setColor(Color.RED);
		 g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
	 }
}
