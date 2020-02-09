package SpaceGame;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Laser extends Rectangle {
	
	Color c = Color.GREEN;
	
	public Laser() {
		
		super(0, 0, 4, 10);
		
		this.x = (int) SpaceFighter.ship.getBounds2D().getCenterX();
		this.y = (int) SpaceFighter.ship.getBounds2D().getMinY();
		
		this.setLocation(x, y);
		
	}
	
	public void draw(Graphics2D win) {
		
		win.setColor(c);
		win.fill(this);
		
	}
	
	
}
