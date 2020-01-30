package SpaceGame;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

public class Laser extends Rectangle {
	
	int x, y, dx, dy, distance, speed = 6;
	int damage;
	Color c = Color.GREEN;
	BufferedImage image;
	double theta;
	double test; // test
	
	
	public Laser() {
		
		super(0, 0, 4, 10);
		// super(300, 400, 3, 10);
		
		this.test = SpaceFighter.ship.getBounds2D().getHeight() / 2;
		
		this.theta = SpaceFighter.ship.theta;
		this.dx = (int) (-speed * Math.sin(theta) * 1.5);
		this.dy = (int) (speed * Math.cos(theta) * 1.5);
		this.x = (int) (SpaceFighter.ship.getBounds2D().getCenterX());
		this.y = (int) (SpaceFighter.ship.getBounds2D().getCenterY());
		this.setLocation((x - 2), (y - 50));
		
	}
	
	public void update() {
		
		this.translate(dx, dy);
		
	}
	
	public void draw(Graphics2D win) {
		
		AffineTransform previous = win.getTransform();
		win.rotate(theta, this.getCenterX(), this.getCenterY());
		
		if (image == null) {
			win.setColor(c);
			win.fill(this);
		} else {
			win.drawImage(image, null, this.x, this.y);
		}
		
		win.setTransform(previous);
		
	}
	
}
