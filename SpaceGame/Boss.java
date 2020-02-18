package SpaceGame;

import java.awt.Color;

public class Boss extends Enemy {
	
	int shotgunCounter = 600;
	int seekerCounter = 120;
	
	public Boss() {
		
		this.hp = 5;
		this.c = Color.decode("#7d2000");
		this.setSize(200, 100);
		this.setLocation(300, 100);
		
	}
	
}
