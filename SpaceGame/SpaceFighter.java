package SpaceGame;

import java.awt.Graphics2D;

import Utilities.GDV5;

public class SpaceFighter extends GDV5 {
	
	static Ship ship = new Ship();
	Space space = new Space();
	Mothership mother = new Mothership();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SpaceFighter game = new SpaceFighter();
		game.start();
		
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
		space.update(this.getHeight());
		mother.update();
		
		ship.move();
		
	}

	@Override
	public void draw(Graphics2D win) {
		// TODO Auto-generated method stub
		
		space.draw(win);
		mother.draw(win);
		
		ship.draw(win);
		
	}

}
