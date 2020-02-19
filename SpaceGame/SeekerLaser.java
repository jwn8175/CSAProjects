package SpaceGame;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

public class SeekerLaser extends EnemyLaser {
	
	int timer = 300;
	
	public SeekerLaser(double theta, Enemy e) {
		
		super(theta, e);
		this.setSize(10, 5);
		this.setColor(Color.CYAN);
		this.speed = 3;
		
	}
	
	public void move(double ptheta) {
		this.theta = ptheta;
		// System.out.println(this.theta);
		// fix maybe
		/*
		this.theta %= Math.PI * 2;
		if (Math.abs(this.theta - ptheta) > Math.PI/6) {
			if (this.theta > ptheta) {
				this.theta -= Math.PI/100;
			} else {
				this.theta += Math.PI/100;
			}
		}
		*/
		super.move();
		timer--;
		if (timer == 0) {
			this.gone = true;
		}
	}
	
	public void draw(Graphics2D win) {
		
		AffineTransform previous = win.getTransform();
		win.rotate(this.theta, this.getCenterX(), this.getCenterY());
		super.draw(win);
		win.setTransform(previous);
		
	}
	
}