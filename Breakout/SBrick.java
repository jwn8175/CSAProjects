package Breakout;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class SBrick extends Rectangle {
	
	Color c;
	int code;
	boolean active = false;
	
	static int width = 75, height = 35, buffer = 5;
	
	public SBrick(int x, int y, int code) {
		
		super(x, y, width, height);
		if (code == 0) {
			this.c = Color.CYAN;
			this.active = true;
		}
		if (code == 1) {
			this.c = Color.GREEN;
			this.active = false;
		}		
	}
	
	public void draw(Graphics2D win) {

		win.setColor(this.c);
		if (this.active) win.fill(this);
		if (!this.active) win.draw(this);
	}


	public void swap() {
		this.active = !this.active;
	}
	
}



