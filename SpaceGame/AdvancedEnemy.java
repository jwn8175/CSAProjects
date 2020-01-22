package SpaceGame;

import java.awt.Color;

public class AdvancedEnemy extends Enemy {
	
	double dtheta = Math.PI/30;
	double theta = Math.PI/2;
	
	public AdvancedEnemy() {
		
		this.dy = this.speed;
		this.c = Color.CYAN;
		
		this.setLocation(400, 300);
		this.setSize(40, 40);
		
	}
	
	public void update() {
		
		this.theta += this.dtheta;
		
		dx = (int) (10 * Math.sin(this.theta));
		dy = (int) (10 * Math.cos(this.theta));
		
		this.theta %= (Math.PI * 2);
		
		super.update();
		
	}
	
}
