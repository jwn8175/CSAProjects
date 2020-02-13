package SpaceGame;

import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.util.Random;

public class BasicEnemy extends Enemy {
	
	double dtheta = Math.PI/30;
	double theta = Math.PI/2;
	
	// boolean isFalling = true;
	
	public BasicEnemy() {
		
		this.hp = 1;
		this.dy = this.speed;
		
		Random r= new Random();
		int newX = r.nextInt(600) + 80;
		this.setLocation(newX, -this.height);
		
	}
	
	public BasicEnemy(int newX) {
		
		this.setSize(30, 30);
		
		this.hp = 1;
		this.dy = this.speed;
		
		this.setLocation(newX, -this.height);
		// System.out.println("This happened.");
		
	}
	
	public void update() {
		
		if (this.getY() < 125) {
			super.update();
		} else {
			this.dy = 0;
		}
		
		// this.theta += this.dtheta;
		// this.theta %= (Math.PI * 2);
		
	}
	
	public void draw(Graphics2D win) {
		
		// current rotation
		// AffineTransform previous = win.getTransform();
		
		// rotates pen
		// win.rotate(theta,  this.getCenterX(), this.getCenterY());
		super.draw(win);
		
		// rotate to previous
		// win.setTransform(previous);
		
	}

}
