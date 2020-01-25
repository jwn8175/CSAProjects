package Breakout;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

import Utilities.GDV5;

public class Laser extends Rectangle {
	
	Color c = Color.RED;
	
	static int width = 15, height = 40;
	int dy = -10;
	
	public Laser(Paddle paddle) {
		super((int) paddle.getCenterX(), (int) paddle.getCenterY() - 40, width, height);
		
	}
	
	public void draw(Graphics2D win) {
		win.setColor(c);
		win.fill(this);
	}
	
}




