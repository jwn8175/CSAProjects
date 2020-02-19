package SpaceGame;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

public class CrazyEnemy extends Enemy {

	double dtheta = Math.PI/120;
	double theta = 0;
	double face;
	EnemyLaser[] lasers = new EnemyLaser[20];

	public CrazyEnemy() {

		this.pointValue = 20;
		this.c = Color.CYAN;
		this.hp = 3;
		this.setSize(30, 30);
		this.setLocation(90, 300);

	}

	public CrazyEnemy(int newY) {
		
		this.c = Color.CYAN;
		this.hp = 3;
		this.setSize(30, 30);
		this.setLocation(90, newY);

	}

	public void update() {
		
		this.face = this.getFace();
		this.dx = (int) (this.speed * Math.sin(this.theta));
		this.dy = - (int) (this.speed * Math.sin(this.theta) * Math.cos((this.theta)));
		this.theta += this.dtheta;
		this.theta %= Math.PI * 2;
		
		if (SpaceFighter.currentTime % 60 == 0) {
			this.shoot();
			System.out.println("Enemy Shoots.");
		}
		
		for (int i = 0; i < this.lasers.length; i++) {
			if (lasers[i] != null) {
				lasers[i].move();
				if (lasers[i].outOfBounds || lasers[i].gone) {
					lasers[i] = null;
					// System.out.println("Laser Gone");
				}
			}
		}
		
		// this.translate(dx, dy);
		super.update();

	}

	public void draw(Graphics2D win) {
		/*
		double deltaY = SpaceFighter.ship.getBounds().getCenterY() - this.getBounds().getCenterY();
		double deltaX = SpaceFighter.ship.getBounds().getCenterX() - this.getBounds().getCenterX();
		double angle = Math.atan2(deltaY, deltaX);
		*/
		
		// current rotation
		AffineTransform previous = win.getTransform();
		
		// rotates pen
		win.rotate(this.getFace(), this.getCenterX(), this.getCenterY());
		super.draw(win);
				
		// rotate to previous
		win.setTransform(previous);
		
		for (Laser las : lasers) {
			if (las != null) {
				las.draw(win);
			}
		}
		
	}
	
	public void shoot() {
		
		EnemyLaser tempLaser = new EnemyLaser(this.getFace(), this);
		// pew.setColor(Color.YELLOW);
		
		for (int i = 0; i < this.lasers.length; i++) {
			if (lasers[i] == null) {
				lasers[i] = tempLaser;
				return;
			}
		}
	}

}
