package SpaceGame;

import java.awt.Graphics2D;
import java.util.Random;

public class Mothership {

	Enemy[] one = new Enemy[20];
	Enemy[] badGuys;
	int index = 0;
	int maxAdv = 10;
	int adv = 0;
	int pointsValue = 50;

	public Mothership() {  

	}
	
	public Mothership(int code) {
		
		if (code == 1) {
			this.badGuys = new Enemy[8];
			for (int i = 100; i <= 700; i += 75) {
				Enemy e = new BasicEnemy(i);
				
				if (badGuys[index] == null) badGuys[index] = e;
				index++;
				index %= badGuys.length;
			}
			// System.out.println("This happened.");
		}
		
	}

	public void update() {
	
		// movement
		for (int i = 0; i < badGuys.length; i++) {
			Enemy e = badGuys[i];
			if (e != null) e.update();
		}

	}

	public void draw(Graphics2D win) {

		for (int i = 0; i < badGuys.length; i++) {
			Enemy e = badGuys[i];
			if (e != null) {
				e.draw(win);
				// System.out.println("This happened.");
			}
		}

	}

}
