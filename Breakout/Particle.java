package Breakout;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.Random;

public class Particle extends Rectangle {
	
	double dx, dy;
	
	static int size = 3;
	static double gravity = 1;
	static int radius = 5;
	
	Color c = Color.WHITE;
	
	public Particle(Ball ball) {
		super(ball.x, ball.y, size, size);
		
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
	
}





