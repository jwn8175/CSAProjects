package SpaceGame;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

public class AdvancedEnemy extends Enemy {
	
	double dtheta = Math.PI/120;
	double theta = 0;
	
	boolean isFalling = true;
	
	public AdvancedEnemy() {
		
		this.hp = 2;
		
		this.dy = this.speed;
		this.c = Color.CYAN;
		
		this.setLocation(20, -this.height);
		this.setSize(40, 40);
		
	}
	
	public void update() {
		
		if (!this.isFalling) {
		
			this.theta += this.dtheta;
			// this.theta %= (Math.PI * 2);
			
			dx = (int) (10 * Math.sin(this.theta));
			dy = (int) (7 * Math.cos(this.theta));
			
			
		} else {
			
			if (this.y > 280) this.isFalling = false;
			
		}
		
		
		super.update();
		
	}
	
	public void draw(Graphics2D win) {
		
		// change in y and x from enemy and ship
		double deltaY = SpaceFighter.ship.getBounds().getCenterY() - this.getBounds().getCenterY();
		double deltaX = SpaceFighter.ship.getBounds().getCenterX() - this.getBounds().getCenterX();
		double angle = Math.atan2(deltaY, deltaX);
		
		// current rotation
		AffineTransform previous = win.getTransform();
				
		// rotates pen
		win.rotate(angle, this.getCenterX(), this.getCenterY());
		super.draw(win);
				
		// rotate to previous
		win.setTransform(previous);
		
	}
	
}
