package SpaceGame;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class Enemy extends Rectangle {

	int dx, dy, speed = 5;
	int hp;
	int pointValue;
	int boomCount = 0;
	double theta;
	double face;
	boolean isBoom = false;
	boolean dying = false;
	boolean done = false;
	Color c = Color.RED;
	Boom boom;
	BufferedImage image;

	public Enemy() {
		super(0, 0, 10, 10);
	}

	public void update() {
		
		if (this.hp <= 0) this.dying = true;
		if (this.hp <= 0 && !this.isBoom) {
			boom = new Boom(this);
			SpaceFighter.score += pointValue;
			this.setSize(0, 0);
			this.dying = true;
			this.isBoom = true;
			System.out.println("Dying");
		}
		
		if (this.dying) {
			this.boom.update();
		}
		
		this.shipCollide();
		this.hit();
		this.translate(dx, dy);
		
	}

	public void draw(Graphics2D win) {

		if (image == null && this.hp > 0) {
			win.setColor(c);
			win.fill(this);
			win.setColor(Color.WHITE);
			win.draw(this);
		} else if (this.hp > 0) {
			win.drawImage(image, null, this.x, this.y);
		}

		if (this.dying && this.boom != null) {
			boom.draw(win);
			this.done = this.boomDone();
			// System.out.println("Booming.");
		}

	}
	
	/*
	public void deathAnimation() {

		this.dying = true;
		this.boom.update();

	}
	*/

	public void hit() {

		for (int i = 0; i < SpaceFighter.ship.lasers.length; i++) {
			if (SpaceFighter.ship.lasers[i] != null && SpaceFighter.ship.lasers[i].intersects(this)) {
				this.hp--;
				SpaceFighter.ship.lasers[i] = null;
			}
		}
		// System.out.println("Hit Detection");

	}
	
	public double getFace() {
		double deltaY = SpaceFighter.ship.getBounds().getCenterY() - this.getBounds().getCenterY();
		double deltaX = SpaceFighter.ship.getBounds().getCenterX() - this.getBounds().getCenterX();
		double angle = Math.atan2(deltaY, deltaX);
		return angle;
	}
	
	public void shipCollide() {
		for (Rectangle r : SpaceFighter.ship.getHurtBox()) {
			if (r.intersects(this)) {
				this.hp = 0;
				SpaceFighter.ship.gas -= 20;
			}
		}
		
	}
	
	public boolean boomDone() {
		int count = 0;
		for (Particle p : this.boom.parts) {
			if (p == null) count++;
		}
		return (count == 50);
	}

}
