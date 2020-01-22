package SpaceGame;

import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.util.Random;

public class BasicEnemy extends Enemy {
	
	double dtheta = Math.PI/30;
	double theta = Math.PI/2;
	
	public BasicEnemy() {
		
		this.dy = this.speed;
		
		Random r= new Random();
		int newX = r.nextInt(600) + 100;
		this.setLocation(newX, -this.height);
		
	}
	
	public void update() {
		
		super.update();
		
		this.theta += this.dtheta;
		this.theta %= (Math.PI * 2);
		
	}
	
	public void draw(Graphics2D win) {
		
		AffineTransform previous = win.getTransform();                  // current rotation
		
		win.rotate(theta,  this.getCenterX(), this.getCenterY());		// rotates pen
		super.draw(win);
		
		win.setTransform(previous);										// rotate to previous
		
	}

}
