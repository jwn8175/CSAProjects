package SpaceGame;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class Laser extends Rectangle {
	
	int dy, speed = 5;
	int damage;
	Color c = Color.RED;
	BufferedImage image;
	double theta;
	
	public Laser() {
		
		super(0, 0, 5, 10);
		
	}
	
	public void update() {
		
		this.translate(0, dy);
		
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
