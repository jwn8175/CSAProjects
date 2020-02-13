package SpaceGame;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.Random;

public class Particle extends Rectangle {
	
	double dx, dy;

	static int size = 3;
	int radius = 5;
	double gravity = 1;

	Color c = Color.WHITE;
	
	// thruster constructor
	public Particle() {

	}
	
	// enemy blowup constructor
	public Particle(int x, int y) {
		
		super(x, y, size, size);
		Random r = new Random();
		dx = radius * r.nextGaussian();
		dy = radius * r.nextGaussian();
		
	}

	public void move() {
		
		dy += gravity;
		this.translate((int) dx, (int) dy);

	}

	public void draw(Graphics2D win) {
		
		win.setColor(c);
		win.fill(this);
		
	}
	
	public void setParticleColor(Color color) {
		this.c = color;
	}



}
