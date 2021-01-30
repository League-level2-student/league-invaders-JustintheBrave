import java.awt.Dimension;

import javax.swing.JFrame;

public class LeagueInvaders {

	JFrame frame;
	public static final int WIDTH = 500;
	public static final int HEIGHT = 800;
	
	GamePanel panel;
	
	public static void main(String[] args) {
		LeagueInvaders league = new LeagueInvaders();
		league.setup();

	}
	
	public LeagueInvaders() {
		frame = new JFrame();
		panel = new GamePanel();
	}
	
	public void setup() {
		frame.add(panel);
		frame.setVisible(true);
		frame.setSize(WIDTH, HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	
}
