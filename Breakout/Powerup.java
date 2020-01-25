package Breakout;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Powerup extends Rectangle {
	
	boolean isLaser = false;
	
	Laser laser = null;
	
	Color c = Color.ORANGE.darker();
	
	int dx = 0, dy = 7;
	static int width = 30, height = 30;
	
	public Powerup(Ball ball) {
		super(ball.x, ball.y, width, height);
	}
	
	public void update(Paddle pad) {
		this.translate(dx, dy);
		hitPad(pad);
		if (isLaser) {
			laser = new Laser(pad);
			isLaser = false;
		}
		if (laser != null) laser.translate(0, -10);

	}
	
	public void draw(Graphics2D win) {
		win.setColor(c);
		win.fill(this);
		if (laser != null) {
			laser.draw(win);
		}
	}
	
	public void hitPad(Paddle pad) {
		if (this.getBounds2D().intersects(pad)) {
			isLaser = true;
			this.setSize(0, 0);
		}
	}
	
	public void hitBrick(Brick[] wall, Breakout game) {
		for (int i = 0; i < wall.length; i++) {
			if (this.laser.getBounds2D().intersects(wall[i])) {
				wall[i].zap(game);
				this.laser.setSize(0, 0);
			}
		}
	}

}



