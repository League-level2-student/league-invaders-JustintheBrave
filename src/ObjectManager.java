import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager implements ActionListener{
	RocketShip rocket;
	Random random = new Random();
	ArrayList <Projectile> projectiles = new ArrayList <Projectile>();
	ArrayList <Alien> aliens = new ArrayList <Alien>();
	
	int score = 0;
	
	
	public ObjectManager(RocketShip rockett) {
		this.rocket=rockett;
	}
	
	public void addProjectile(Projectile p) {
		projectiles.add(p);
	}
	
	public void addAlien(){
		aliens.add(new Alien(random.nextInt(LeagueInvaders.WIDTH),0,50,50));
	}
	
	public void update() {
		for(int i=0; i<aliens.size(); i++) {
			aliens.get(i).update();	
		}
		
		for (int i = 0; i < projectiles.size(); i++) {
			projectiles.get(i).update();
		}
		
		checkCollision();
		purgeObjects();
		
	}
	
	void draw(Graphics g) {
		rocket.draw(g);
		
		for (int i = 0; i < aliens.size(); i++) {
			aliens.get(i).draw(g);
		}
		
		for (int i = 0; i < projectiles.size(); i++) {
			projectiles.get(i).draw(g);
		}
	}
	
	public void purgeObjects() {
		for (int i = 0; i < aliens.size(); i++) {
			if(aliens.get(i).isActive==false) {
				aliens.remove(i);
			}
		}
		
		for (int i = 0; i < projectiles.size(); i++) {
			if(projectiles.get(i).isActive==false) {
				projectiles.remove(i);
			}
		}
	}
	
	public void checkCollision(){
		for (int e = 0; e < aliens.size(); e++) {
			if(rocket.collisionBox.intersects(aliens.get(e).collisionBox)) {
				rocket.isActive=false;
				aliens.get(e).isActive=false;
			}
		}
		for (int i = 0; i < aliens.size(); i++) {
			for (int j = 0; j < projectiles.size(); j++) {
				if(projectiles.get(j).collisionBox.intersects(aliens.get(i).collisionBox)) {
					projectiles.get(j).isActive=false;
					aliens.get(i).isActive=false;
					score++;
				}
			}
		}
	}
	
	public int getScore() {
		return score;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		addAlien();
	}
	
	
}

