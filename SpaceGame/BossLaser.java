package SpaceGame;

import java.awt.Color;

public class BossLaser extends Laser {
	
	Laser[] lasers = new Laser[50];
	
	public BossLaser() {
		for (int i = 0; i < lasers.length; i++) {
			Laser tempLaser = new Laser();
			tempLaser.theta = Math.PI/50 * i;
			tempLaser.setColor(Color.BLUE);
		}
		
	}
}
