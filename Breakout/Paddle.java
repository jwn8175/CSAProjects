package Breakout;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

import Utilities.GDV5;

public class Paddle extends Rectangle {
	
	Color c = Color.BLUE;
		
	int dx = 0, speed = 5;
	static int width = 100, height = 30;
			
	public Paddle() {
		super(350, 600, width, height);
		
	}
	
	public void draw(Graphics2D win) {
		
		win.setColor(c);
		win.fill(this);
		
		win.setColor(Color.WHITE);
		win.draw(this);
	}
	
	public void move() {
		dx = 0;
		
		if (GDV5.KeysPressed[KeyEvent.VK_RIGHT]) dx = speed;
		if (GDV5.KeysPressed[KeyEvent.VK_LEFT]) dx = -speed;
		if (this.getMinX() < 0) this.x = 2;
		if (this.getMaxX() > 785) this.x = 684;
		
		
		this.translate(dx, 0);
		
	}
	
}





