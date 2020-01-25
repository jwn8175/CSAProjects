package SpaceGame;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class Enemy extends Rectangle {
	
	int dx, dy, speed = 5;
	int hp;
	Color c = Color.RED;
	BufferedImage image;
	
	public Enemy() {
		
		super(0, 0, 10, 10);
		
	}
	
	public void update() {
		
		this.translate(dx, dy);
		
	}
	
	public void draw(Graphics2D win) {
		
		if (image == null) {
			win.setColor(c);
			win.fill(this);
		} else {
			win.drawImage(image, null, this.x, this.y);
		}
		
	}
	
}
