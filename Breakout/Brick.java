package Breakout;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.Random;

import Utilities.SoundDriverHo;

public class Brick extends Rectangle {

	// instance fields
	Color currentColor;
	int lives = -1;
	Random r = new Random();

	// static fields
	static int width = 75, height = 35, buffer = 5;
	static boolean isBoom = false;
	static boolean isPowerup = false;
	static boolean s;

	// constructor
	public Brick(int x, int y, int lives) {
		// refers to the parent class (Rectangle)
		super(x, y, width, height);
		this.lives = lives;
	}

	public void draw(Graphics2D win) {
		if (this.lives == 3) this.currentColor = Color.MAGENTA;
		if (this.lives == 2) this.currentColor = Color.RED;
		if (this.lives == 1) this.currentColor = Color.YELLOW;
		if (this.lives <= -1) this.currentColor = Color.LIGHT_GRAY;

		win.setColor(this.currentColor);
		win.fill(this);

	}

	public void hit(Breakout game) {
		this.lives --;
		if (this.lives == 0) {
			this.setSize(0, 0);
			game.score += 50;
			isBoom = true;
			isPowerup = r.nextInt(10) > 2;
			s = true;
			
		} else {
			if (this.lives == 3) this.currentColor = Color.MAGENTA;
			if (this.lives == 2) this.currentColor = Color.RED;
			if (this.lives == 1) this.currentColor = Color.YELLOW;
			s = false;
		}
		
	}
	
	public void zap(Breakout game) {
		if (this.lives < 0) {
			this.setSize(0, 0);
		} else {
			this.lives --;
			if (this.lives == 0) {
				this.setSize(0, 0);
				game.score += 50;
				// isBoom = true;
				// isPowerup = r.nextInt(10) > -1;
				s = true;
				
			} else {
				if (this.lives == 3) this.currentColor = Color.MAGENTA;
				if (this.lives == 2) this.currentColor = Color.RED;
				if (this.lives == 1) this.currentColor = Color.YELLOW;
				s = false;
			}
		}
	}

	public void setLives(int lives) {
		this.lives = lives;
	}

}









