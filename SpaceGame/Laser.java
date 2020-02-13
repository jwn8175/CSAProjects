package SpaceGame;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Laser extends Rectangle {
	
	Color c;
	
	int speed = 8;
	double theta;
	
	public Laser() {
		super(0, 0, 5, 5);
		
		this.c = Color.GREEN;
		this.theta = SpaceFighter.ship.theta;
		this.x = (int) (SpaceFighter.ship.getHitBox().getCenterX() + Math.sin(theta) * 50 - 2.5 * Math.cos(theta));
		this.y = (int) (SpaceFighter.ship.getHitBox().getCenterY() - Math.cos(theta) * 50);
		
		this.setLocation(x, y);
	}
	
	public Laser(Enemy e) {
		super(0, 0, 5, 5);
		
		this.c = Color.RED;
		this.theta = e.theta;
		this.x = (int) (e.getCenterX() + Math.sin(theta) * e.getWidth()/2 - 2.5 * Math.cos(theta));
		this.y = (int) (e.getCenterY() - Math.cos(theta) * e.getHeight()/2);
		
		this.setLocation(x, y);
	}
	
	public void move() {
		int dx = (int) (speed * Math.sin(this.theta));
		int dy = (int) (-speed * Math.cos(this.theta));
	
		this.translate(dx, dy);
		
	}
	
	public void draw(Graphics2D win) {
		
		win.setColor(c);
		win.fill(this);
		
	}
	
	
}
