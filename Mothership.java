package SpaceGame;

import java.awt.Graphics2D;
import java.util.Random;

public class Mothership {
	
	Enemy[] bois = new Enemy[100];
	int index = 0;
	
	public Mothership() {
		
		
		
	}
	
	public void update() {
		
		// spawner
		if (Math.random() > 0.9) {
			
			Enemy e = null;
			if (Math.random() > 0.5) {
				e = new AdvancedEnemy();
			} else {
				e = new BasicEnemy();
			}
			
			bois[index] = e;
			index++;
			index %= bois.length;
			
		}
		
		// movement
		for (int i = 0; i < bois.length; i++) {
			
			Enemy e = bois[i];
			if(e != null) e.update();
			
		}
		
	}
	
	public void draw(Graphics2D win) {
		
		for (Enemy e : bois) {
			
			if (e != null) e.draw(win);
			
		}
		
	}
	
}
