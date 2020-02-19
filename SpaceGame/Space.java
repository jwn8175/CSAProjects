package SpaceGame;

import java.awt.Graphics2D;
import java.util.Random;

public class Space {
	
	Star[] stars = new Star[100];
	
	public Space() {
		
		Random r = new Random();
		for (int i = 0; i < stars.length; i++) {
			stars[i] = new Star(r.nextInt(800), r.nextInt(600));
		}
		
	}
	
	public void update(int height) {
		for (int i = 0; i < stars.length; i++) {
			stars[i].update(height);
		}
	}
	
	public void draw(Graphics2D win) {
		for (int i = 0; i < stars.length; i++) {
			stars[i].draw(win);
		}
	}
}
