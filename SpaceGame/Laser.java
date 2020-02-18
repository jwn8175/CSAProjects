package SpaceGame;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Laser extends Rectangle {

	Color c;

	int dx, dy;

	int speed = 9;
	double theta;
	boolean outOfBounds = false;

	public Laser() {

	}
	
	// for ship laser
	public Laser(double ptheta) {
		super(0, 0, 5, 5);

		this.c = Color.GREEN;
		this.theta = ptheta;
		this.x = (int) (SpaceFighter.ship.getHitBox().getCenterX() + Math.sin(theta) * 50 - 2.5 * Math.cos(theta));
		this.y = (int) (SpaceFighter.ship.getHitBox().getCenterY() - Math.cos(theta) * 50);

		this.setLocation(x, y);
	}

	public void move() {
		this.dx = (int) (speed * Math.sin(theta));
		this.dy = (int) (-speed * Math.cos(theta));

		this.outOfBoundsCheck();
		this.translate(dx, dy);

	}

	public void draw(Graphics2D win) {
		win.setColor(c);
		win.fill(this);
	}

	public void setColor(Color c) {
		this.c = c;
	}

	public void outOfBoundsCheck() {
		this.outOfBounds = (this.getX() > 800 || this.getX() < 0 || this.getY() < 0 || this.getY() > 600);
	}

}
