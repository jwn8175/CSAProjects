package SpaceGame;

import java.awt.Color;

public class EnemyLaser extends Laser {

	public EnemyLaser(double theta, Enemy e) {
		this.setSize(5, 5);
		
		this.speed = 5;
		this.c = Color.YELLOW;
		this.theta = theta;
		this.x = (int) (e.getCenterX());
		this.y = (int) (e.getCenterY());

		this.setLocation(x, y);
	}
	
	public void move() {
		this.dx = (int) (speed * Math.cos(theta));
		this.dy = (int) (speed * Math.sin(theta));

		this.outOfBoundsCheck();
		this.translate(dx, dy);

	}

}
