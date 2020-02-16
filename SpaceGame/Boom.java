package SpaceGame;

import java.awt.Graphics2D;

public class Boom {
	
	Particle[] parts = new Particle[50];
	
	public Boom(Enemy e) {
		
		for (int i = 0; i < parts.length; i++) {
			parts[i] = new Particle((int) e.getCenterX(), (int) e.getCenterY());
		}
		
	}
	
	public void update() {
		
		for (int i = 0; i < parts.length; i++) {
			if (parts[i] != null) {
				parts[i].move();
				// if (parts[i].getY() > 600) parts[i] = null;
				if (!parts[i].circleCheck(parts[i].range)) parts[i] = null;
			}
		}
		// System.out.println("Boomer");
		
	}
	
	public void draw(Graphics2D win) {
		
		for (Particle p : parts) {
			if (p != null) p.draw(win);
		}
		
	}
	
}
