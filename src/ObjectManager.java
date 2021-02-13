import java.util.ArrayList;
import java.util.Random;

public class ObjectManager {
	RocketShip rocket;
	Random random = new Random();
	ArrayList <Projectile> projectiles = new ArrayList <Projectile>();
	ArrayList <Alien> aliens = new ArrayList <Alien>();
	
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
		
	}
	
	//ON STEP 5 
}

