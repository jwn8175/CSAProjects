package SpaceGame;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.geom.AffineTransform;

import Utilities.GDV5;

public class Ship extends Polygon {

	// fields

	int dx = 0, dy = 0, speed = 6;
	int gas = 100;
	Laser[] lasers = new Laser[10];
	int laserIndex = 0;
	Polygon layer1 = new Polygon();
	Polygon layer2 = new Polygon();

	double[][][] points = {

			{ {4, 0, 4, 8}, {0, 3, 2, 3} },    // base
			{ {4, 1, 4, 7}, {0, 4, 2, 4} },    // first layer
			{ {4, 3, 3.7, 4.3, 5}, {-1, 2, 4, 4, 2} }    // second layer

	};

	double dtheta = Math.PI/30;
	double theta = 0;

	// constructors
	public Ship() {

		double scale = 12;

		for (int i = 0; i < points[0][0].length; i++) {
			this.addPoint((int) (points[0][0][i] * scale + 320), (int) (points[0][1][i] * scale + 425));
		}

		for (int i = 0; i < points[1][0].length; i++) {
			layer1.addPoint((int) (points[1][0][i] * scale + 320), (int) (points[1][1][i] * scale + 425));
		}

		for (int i = 0; i < points[2][0].length; i++) {
			layer2.addPoint((int) (points[2][0][i] * scale + 320), (int) (points[2][1][i] * scale + 425));
		}

	}

	public void update() {

		// System.out.println(points.length); // is 3
		if (GDV5.KeysTyped[KeyEvent.VK_SPACE]) {
			this.makeLaser();
			GDV5.KeysTyped[KeyEvent.VK_SPACE] = false;
		}
		for (int i = 0; i < lasers.length; i++) {
			if (lasers[i] != null) {
				lasers[i].move();
				if (lasers[i].outOfBounds) lasers[i] = null;
			}
		}
		
		this.move();

	}

	public void draw(Graphics2D win) {

		AffineTransform previous = win.getTransform();
		win.rotate(theta, this.getHitBox().getCenterX(), this.getHitBox().getCenterY());
		
		win.setColor(Color.RED);
		// win.draw(SpaceFighter.ship.getHitBox());
		// for (Rectangle r : this.getHurtBox()) win.draw(r);
		// win.draw(this.getHitBox());
		win.setColor(Color.BLUE);
		win.fill(this);

		win.setColor(Color.WHITE);
		win.fill(layer1);

		win.setColor(Color.MAGENTA);
		win.fill(layer2);
		
		win.setColor(Color.WHITE);
		win.draw(this);
		win.draw(layer2);

		win.setTransform(previous);

		for (int i = 0; i < lasers.length; i++) {
			if (lasers[i] != null) lasers[i].draw(win);
		}

	}

	public void move() {

		dx = 0;
		dy = 0;
		
		
		if (GDV5.KeysPressed[KeyEvent.VK_RIGHT]) theta += dtheta;
		if (GDV5.KeysPressed[KeyEvent.VK_LEFT]) theta -= dtheta;
		if (GDV5.KeysPressed[KeyEvent.VK_S]) {
			dx = (int) (-speed * Math.sin(theta));
			dy = (int) (speed * Math.cos(theta));
		};
		if (GDV5.KeysPressed[KeyEvent.VK_W]) {
			dx = (int) (speed * Math.sin(theta));
			dy = (int) (-speed * Math.cos(theta));
		};
		
		if (GDV5.KeysPressed[KeyEvent.VK_A]) {
			dx = (int) (-speed * Math.cos(theta));
			dy = (int) (-speed * Math.sin(theta));
		};
		if (GDV5.KeysPressed[KeyEvent.VK_D]) {
			dx = (int) (speed * Math.cos(theta));
			dy = (int) (speed * Math.sin(theta));
		};
		
		if (this.getHitBox().getMinY() <= 0) {
			this.dy = 1;
		}
		if (this.getHitBox().getMaxY() >= 600) {
			this.dy = -1;
		}
		if (this.getHitBox().getMinX() <= 0) {
			this.dx = 1;
		}
		if (this.getHitBox().getMaxX() >= 800) {
			this.dx = -1;
		}
		this.theta %= (Math.PI * 2);

		this.translate(dx, dy);
		layer1.translate(dx, dy);
		layer2.translate(dx, dy);

	}

	public void makeLaser() {

		Laser tempLaser = new Laser(this.theta);
		for (int i = 0; i < lasers.length; i++) {
			if (lasers[i] == null) {
				lasers[i] = tempLaser;
				// System.out.println("This Happened");
				return;
			}
		}

	}
	
	public Rectangle getHitBox() {	
		// this is to get the center of the ship for lasers, etc
		return new Rectangle((int) SpaceFighter.ship.getBounds().getCenterX() - 60, (int) SpaceFighter.ship.layer2.getBounds().getCenterY() - 60, 120, 120);
	}
	
	public Rectangle[] getHurtBox() {
		
		// this is for ship collisions like getting hit
		Rectangle[] hurtBox = new Rectangle[2];
		hurtBox[0] = new Rectangle((int) this.getBounds().getX(), (int) (this.getBounds().getY() + 20), (int) this.getBounds().getWidth(), (int) (this.getBounds().getHeight() - 3));
		// hurtBox[1] = layer1.getBounds();
		hurtBox[1] = layer2.getBounds();
		
		return hurtBox;
		
	}
	
	public void takeDamage(EnemyLaser laser) {
		for (Rectangle r : this.getHurtBox()) {
			if (laser != null && r.intersects(laser)) {
				laser.gone = true;
				this.gas -= 10;
			}
		}
		
	}
	
}
