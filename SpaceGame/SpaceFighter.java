package SpaceGame;

import java.awt.Graphics2D;

import Utilities.GDV5;
import Utilities.Gamestate;

public class SpaceFighter extends GDV5 {
	
	Gamestate gs = new Gamestate();
	
	static Ship ship = new Ship();
	Space space = new Space();
	Mothership mother = new Mothership();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SpaceFighter game = new SpaceFighter();
		game.start();
			
	}
	
	public SpaceFighter() {
		
		this.gs.setState(0);
		
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
		// space.update(this.getHeight());
		// mother.update();
		
		ship.update();
		
	}

	@Override
	public void draw(Graphics2D win) {
		// TODO Auto-generated method stub
		
		// space.draw(win);
		// mother.draw(win);
		
		ship.draw(win);
		
	}

}
