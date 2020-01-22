package SpaceGame;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.Random;

public class Star extends Rectangle {
	
	int dy = 2;
	
	Color c = Color.WHITE;
	
	public Star(int x, int y) {
		
		super(x, y, 0 ,0);
		
		Random r = new Random();
		int size = r.nextInt(4) + 2;
		dy = size - 1;
		this.setSize(size, size);
		
	}
	
	public void update(int height) {
		
		if (this.getMinY() > height) this.setLocation((int) this.getX(), 0);
		this.translate(0, dy);
		
	}
	
	public void draw(Graphics2D win) {
		
		win.setColor(c);
		win.fill(this);
		
	}
	
}
