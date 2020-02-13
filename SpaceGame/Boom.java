package SpaceGame;

import java.awt.Graphics2D;

public class Boom {
	
	Particle[] parts = new Particle[50];
	
	public Boom(Enemy e) {
		
		for (Particle p : parts) {
			p = new Particle((int) e.getCenterX(), (int) e.getCenterY());
		}
		
	}
	
	public void update() {
		
		for (Particle p : parts) {
			if (p != null) {
				p.move();
				if (p.getY() > 600) p = null;
			}
		}
		
	}
	
	public void draw(Graphics2D win) {
		
		for (Particle p : parts) {
			if (p != null) p.draw(win);
		}
		
	}
	
}
