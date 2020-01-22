package SpaceGame;

import java.awt.Graphics2D;

import Utilities.GDV5;

public class SpaceFighter extends GDV5 {
	
	Ship ship = new Ship();
	Space space = new Space();
	Enemy be1 = new BasicEnemy();
	Enemy ae1 = new AdvancedEnemy();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SpaceFighter game = new SpaceFighter();
		game.start();
		
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
		space.update(this.getHeight());
		
		be1.update();
		ae1.update();
		
		
		ship.move();
		
	}

	@Override
	public void draw(Graphics2D win) {
		// TODO Auto-generated method stub
		
		space.draw(win);
		
		be1.draw(win);
		ae1.draw(win);
		
		
		ship.draw(win);
		
	}

}
