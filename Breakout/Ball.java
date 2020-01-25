package Breakout;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

import Utilities.GDV5;

public class Ball extends Rectangle {
	
	int dx = 0, dy = 4;
	
	static int width = 20, height = 20;
	
	boolean start = false;
	
	public Ball() {
		super(390, 450, width, height);
		
	}
	
	public void move(Paddle pad, Brick[] wall, SBrick[] sbWall, Breakout game) {
		
		if (start) {
			
			hitEdge(game, pad);
			hitPaddle(pad);
			for (int i = 0; i < wall.length; i ++) {
				hitBrick(wall[i], game);
			}
			
			for (int i = 0; i < sbWall.length; i++) {
				hitSB(sbWall[i], game);
			}
			
			this.translate(dx, dy);
			
		} else {
			
			this.setLocation((int) pad.getCenterX() - 10, (int) pad.getY() - (int) this.getHeight() - 5);
			if (GDV5.KeysPressed[KeyEvent.VK_SPACE]) {
				this.start = true;
				this.dx = 0;
				this.dy = -4;
				
			}
		}
		
	}
	
	public void draw(Graphics2D win) {
		win.setColor(Color.WHITE);
		win.fill(this);
		
	}
	
	public void hitEdge(Breakout game, Paddle pad) {
		if (this.getMaxX() > game.getWidth() || this.getMinX() < 0) dx *= -1;
		if (this.getMinY() < 0) dy *= -1;
		if (this.getMaxY() > game.getHeight()) {
			// this.x = (int) pad.getCenterX();
			// this.y = (int) pad.getCenterY() - 30;
			this.setLocation((int) pad.getCenterX() - 10, (int) pad.getY() - (int) this.getHeight() - 5);
			this.dx = 0;
			this.dy = 0;
			game.hearts--;
			this.start = false;
		}
	
	}
	
	public void hitPaddle(Paddle pad) {
		int dir = -1;
		if (this.getBounds2D().intersects(pad)) {
			dir = GDV5.collisionDirection(pad, this, dx, dy);
			if (dir == 0) { // from the right
				if (dx > 0) dx += 1;
				else dx *= -1;
			}
			if (dir == 2) { // from the left
				if (dx < 0) dx -= 1;
				else dx *= -1;
			}
			if (dir % 2 == 1) {
				dy *= -1;
				angleX(pad);
			}
		}
		
	}
	
	public void angleX(Paddle pad) {
		int dcenter = (int) (this.getCenterX() - pad.getCenterX());
		if (this.dx == 0) this.dx = 1; // to prevent divide by 0
		int dir = dcenter >= 0 ? 1 : -1; // 1 if right side, -1 if left side
		dcenter = (int) Math.abs(this.getCenterX() - pad.getCenterX());
		
		// this.dx / Math.abs(this.dx)
		if (dcenter < 15) this.dx = 1;
		if (dcenter >= 15 && dcenter < 35) this.dx = 2;
		if (dcenter >= 35 && dcenter <= 45) this.dx = 3;
		if (dcenter > 45) this.dx = 4;
		
		this.dx *= dir;
		
	}
	
	public void hitBrick(Brick brick, Breakout game) {
		int dir = -1;
		if (this.getBounds2D().intersects(brick)) {
			dir = GDV5.collisionDirection(brick, this, dx, dy);
			brick.hit(game);
			if (dir % 2 == 0) dx *= -1;
			if (dir % 2 == 1) dy *= -1;
		}
	}
	
	public void hitSB(SBrick sb, Breakout game) {
		int dir = -1;
		if (this.getBounds2D().intersects(sb)) {
			if (sb.active) {
				dir = GDV5.collisionDirection(sb, this, dx, dy);
				if (dir % 2 == 0) dx *= -1;
				if (dir % 2 == 1) dy *= -1;
			}
		}
	}
	
}





