package SpaceGame;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.Random;

public class Particle extends Rectangle {
	
	double dx, dy;

	static int size = 3;
	double range;
	double startY, startX;
	double radius = 1.5;
	double mod = .1;

	Color c = Color.RED;
	
	// thruster constructor
	public Particle() {

	}
	
	// enemy blowup constructor
	public Particle(int x, int y) {
		
		super(x, y, size, size);
		Random r = new Random();
		dx = radius * r.nextGaussian();
		dy = radius * r.nextGaussian();
		this.range = 1500;
		this.startY = y;
		this.startX = x;
		
	}

	public void move() {
		
		if (this.dy > 0) {
			dy += mod;
		} else if (this.dy < 0) {
			dy -= mod;
		}
		if (this.dx > 0) {
			dx += mod;
		} else if (this.dy < 0) {
			dx -= mod;
		}
		
		if (!this.circleCheck(range/3)) c = c.darker();
		this.translate((int) dx, (int) dy);

	}

	public void draw(Graphics2D win) {
		
		win.setColor(c);
		if (this.circleCheck(this.range)) win.fill(this);
		
	}
	
	public void setParticleColor(Color color) {
		this.c = color;
	}

	public boolean circleCheck(double r) {
		return (Math.pow(this.getCenterX() - this.startX, 2) + (Math.pow(this.getCenterY() - this.startY, 2)) < (r));
	}

}
