package Breakout;

import java.awt.Graphics2D;

public class Boom {
	
	Particle[] parts = new Particle[100];
	
	public Boom(Ball ball) {
		for (int i = 0; i < parts.length; i++) {
			parts[i] = new Particle(ball);
			
		}
		
	}
	
	public void update() {
		for (Particle p : parts) {
			p.move();
		}
		
	}
	
	public void draw(Graphics2D win) {
		for (Particle p: parts) {
			p.draw(win);
		}
		
	}
	
}





