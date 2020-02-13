package SpaceGame;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class Enemy extends Rectangle {
	
	int dx, dy, speed = 5;
	int hp;
	double theta;
	boolean dying = false;
	Color c = Color.RED;
	Boom boom;
	BufferedImage image;
	
	public Enemy() {
		
		super(0, 0, 10, 10);
		boom = new Boom(this);
		
	}
	
	public void update() {
		
		this.translate(dx, dy);
		if (this.hp <= 0) this.dying = true;
		
	}
	
	public void draw(Graphics2D win) {
		
		if (image == null && this.hp != 0) {
			win.setColor(c);
			win.fill(this);
			win.setColor(Color.WHITE);
			win.draw(this);
		} else if (this.hp != 0) {
			win.drawImage(image, null, this.x, this.y);
		}
		
		if (this.dying) {
			boom.draw(win);
			System.out.println("Particle Drawing.");
		}
		
	}
	
	public void deathAnimation() {
		
		this.dying = true;
		this.boom.update();
		
	}
	
	public int getHp() {
		return this.hp;
	}
	
}
