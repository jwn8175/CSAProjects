package SpaceGame;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.AffineTransform;
import java.util.Random;

public class BlackHole extends Rectangle{
	
	Color body = Color.decode("#231887");
	Color border = Color.WHITE;
	int size = 80;
	double theta = 0;
	double dtheta = Math.PI/30;
	// int timeout = 6000;
	boolean done = false;
	
	public BlackHole() {
		this.setSize(size, size);
		Random r = new Random();
		this.setLocation(r.nextInt(800 - size), r.nextInt(300 - size) + 300);
	}

	public void update() {
		this.theta %= Math.PI * 2;
		this.theta += dtheta;
		// this.timeout--;
		// if (this.timeout == 0) this.done = true;
	}

	public void draw(Graphics2D win) {
		AffineTransform previous = win.getTransform();
		win.rotate(this.theta,  this.getCenterX(), this.getCenterY());
		win.setColor(border);
		// win.drawLine((int) this.getMinX(), (int) this.getMinY(), (int) this.getMaxX(), (int) this.getMaxY());
		win.draw(this);
		win.setColor(body);
		win.fill(this);
		win.setTransform(previous);
	}

}