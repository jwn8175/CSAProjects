package SpaceGame;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Boss extends Enemy {

	int shotgunCounter = 150;
	int seekerCounter = 120;
	SeekerLaser[] seekers = new SeekerLaser[20];
	EnemyLaser[] shotgun = new EnemyLaser[11];

	public Boss() {
		
		this.pointValue = 100;
		this.hp = 25;
		this.c = Color.decode("#7d2000");
		this.setSize(200, 100);
		this.setLocation(300, 100);
		this.dy = 0;
		this.dx = 0;

	}

	public void update() {

		// this.face = this.getFace();

		if (SpaceFighter.currentTime % this.seekerCounter == 0) {
			this.seekerShoot();
			System.out.println("Seeker Firing");
		}
		
		if (SpaceFighter.currentTime % this.shotgunCounter == 0) {
			this.shotgunShoot();
			System.out.println("Shotgun Firing");
		}

		for (int i = 0; i < this.seekers.length; i++) {
			if (seekers[i] != null) {
				double deltaY = SpaceFighter.ship.getBounds().getCenterY() - seekers[i].getBounds().getCenterY();
				double deltaX = SpaceFighter.ship.getBounds().getCenterX() - seekers[i].getBounds().getCenterX();
				seekers[i].move(Math.atan2(deltaY, deltaX));
				if (seekers[i].outOfBounds || seekers[i].gone) {
					seekers[i] = null;
					// System.out.println("Seeker Gone");
				}
			}
		}
		
		for (int j = 0; j < this.shotgun.length; j++) {
			if (shotgun[j] != null) {
				shotgun[j].move();
				if (shotgun[j].outOfBounds || shotgun[j].gone) {
					shotgun[j] = null;
					// System.out.println("Seeker Gone");
				}
			}
		}
		
		super.update();

	}
	
	public void draw(Graphics2D win) {
		super.draw(win);
		for (SeekerLaser las : seekers) {
			if (las != null) {
				las.draw(win);
			}
		}
		
		for (Laser shot : shotgun) {
			if (shot != null) {
				shot.draw(win);
			}
		}
	}
	
	public void shotgunShoot() {
		
		int count = 0;
		
		for (double i = 0; i <= Math.PI; i += Math.PI/7) {
			EnemyLaser tempLaser = new EnemyLaser(i, this);
			tempLaser.speed = 7;
			shotgun[count] = tempLaser;
			// System.out.println(count);
			count++;
			// if (count == 11) return;
		}
		
	}
	
	public void shipCollide() {
		for (Rectangle r : SpaceFighter.ship.getHurtBox()) {
			if (r.intersects(this)) {
				SpaceFighter.ship.gas = 0;
			}
		}
	}
	
	public void seekerShoot() {

		SeekerLaser tempLaser = new SeekerLaser(this.getFace(), this);

		for (int i = 0; i < seekers.length; i++) {
			if (seekers[i] == null) {
				seekers[i] = tempLaser;
				return;
			}
		}
	}

}
