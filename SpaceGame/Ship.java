package SpaceGame;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.event.KeyEvent;
import java.awt.geom.AffineTransform;

import Utilities.GDV5;

public class Ship extends Polygon {

	// fields

	int dx = 0, dy = 0, speed = 5, lives = 3;
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

		double scale = 20;

		for (int i = 0; i < points[0][0].length; i++) {
			this.addPoint((int) (points[0][0][i] * scale), (int) (points[0][1][i] * scale));
		}

		for (int i = 0; i < points[1][0].length; i++) {
			layer1.addPoint((int) (points[1][0][i] * scale), (int) (points[1][1][i] * scale));
		}

		for (int i = 0; i < points[2][0].length; i++) {
			layer2.addPoint((int) (points[2][0][i] * scale), (int) (points[2][1][i] * scale));
		}

	}

	public void update() {

		// System.out.println(points.length); // is 3

		this.move();
		
	}

	public void draw(Graphics2D win) {

		AffineTransform previous = win.getTransform();
		win.rotate(theta,  this.getBounds().getCenterX(), this.getBounds().getCenterY());

		win.setColor(Color.BLUE);
		win.fill(this);

		win.setColor(Color.WHITE);
		win.fill(layer1);

		win.setColor(Color.MAGENTA);
		win.fill(layer2);

		win.setTransform(previous);
		
	}

	public void move() {

		dx = 0;
		dy = 0;

		if (GDV5.KeysPressed[KeyEvent.VK_A]) {
			dx = (int) (-speed * Math.cos(theta));
			dy = (int) (-speed * Math.sin(theta));
		};
		if (GDV5.KeysPressed[KeyEvent.VK_D]) {
			dx = (int) (speed * Math.cos(theta));
			dy = (int) (speed * Math.sin(theta));
		};
		if (GDV5.KeysPressed[KeyEvent.VK_W]) {
			dx = (int) (speed * Math.sin(theta));
			dy = (int) (-speed * Math.cos(theta));
		};
		if (GDV5.KeysPressed[KeyEvent.VK_S]) {
			dx = (int) (-speed * Math.sin(theta));
			dy = (int) (speed * Math.cos(theta));
		};

		if (GDV5.KeysPressed[KeyEvent.VK_RIGHT]) theta += dtheta;
		if (GDV5.KeysPressed[KeyEvent.VK_LEFT]) theta -= dtheta;

		this.theta %= (Math.PI * 2);

		this.translate(dx, dy);
		layer1.translate(dx, dy);
		layer2.translate(dx, dy);

	}
/*
	public void hit() {
		for (int i = 0; i < lasers.length; i++) {
			if (lasers[i] != null) {
				if (lasers[i].getBounds2D().intersects(r)))

			}
		}
	}
*/
}
