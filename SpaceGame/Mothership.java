package SpaceGame;

import java.awt.Graphics2D;
import java.util.Random;

public class Mothership {

	Enemy[] badGuys;
	int index = 0;
	int maxAdv = 10;
	int adv = 0;

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
		
		if (code == 2) {
			this.badGuys = new Enemy[3];
			this.badGuys[0] = new CrazyEnemy(300);
			this.badGuys[1] = new CrazyEnemy(250);
			this.badGuys[2] = new AdvancedEnemy();
			// this.badGuys[3] = new AdvancedEnemy();
		}
		
		if (code == 3) {
			this.badGuys = new Enemy[1];
			this.badGuys[0] = new Boss();
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
