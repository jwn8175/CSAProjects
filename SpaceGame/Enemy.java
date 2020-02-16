package SpaceGame;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class Enemy extends Rectangle {

	int dx, dy, speed = 5;
	int hp;
	double theta;
	boolean isBoom = false;
	boolean dying = false;
	Color c = Color.RED;
	Boom boom;
	BufferedImage image;

	public Enemy() {

		super(0, 0, 10, 10);

	}

	public void update() {
		
		this.translate(dx, dy);
		this.hit();
		if (this.getHp() <= 0 && !this.isBoom) {
			this.setSize(0, 0);
			this.dying = true;
			boom = new Boom(this);
			this.isBoom = true;
			System.out.println("Dying");
		}
		if (this.dying) {
			this.boom.update();
		}

	}

	public void draw(Graphics2D win) {

		if (image == null && this.hp > 0) {
			win.setColor(c);
			win.fill(this);
			win.setColor(Color.WHITE);
			win.draw(this);
		} else if (this.getHp() > 0) {
			win.drawImage(image, null, this.x, this.y);
		}

		if (this.dying) {
			boom.draw(win);
			// System.out.println("Particle Drawing.");
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

	public int getHp() {
		return this.hp;
	}

}
