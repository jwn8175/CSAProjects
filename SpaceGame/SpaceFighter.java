package SpaceGame;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

import Utilities.GDV5;
import Utilities.Menu;

public class SpaceFighter extends GDV5 {

	int gameState;
	int points;
	Menu menu = new Menu();

	static Ship ship = new Ship();
	Space space = new Space();
	Mothership levelOne = new Mothership(1);
	Laser laser;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SpaceFighter game = new SpaceFighter();
		game.start();
		// System.out.println(game.ship.layer2.getBounds2D().getHeight()); // is 100
		// System.out.println(game.ship.getBounds2D().getWidth()); // is 80
		
	}

	public SpaceFighter() {

		gameState = 1;
		points = 0;
		this.menu.setTitle("Space Shooter Game");
		this.menu.setIns("Instructions Here");

	}

	@Override
	public void update() {
		// TODO Auto-generated method stub

		if (gameState == 0) {
			if (GDV5.KeysTyped[KeyEvent.VK_SPACE]) {
				gameState = 1;
				GDV5.KeysTyped[KeyEvent.VK_SPACE] = false;
			}
		}

		if (gameState == 1) {
			// space.update(this.getHeight());
			levelOne.update();
			ship.update();
		}
		
		this.cleanUp();

	}

	@Override
	public void draw(Graphics2D win) {
		// TODO Auto-generated method stub

		if (gameState == 0) {
			menu.printTitleScreen(win);
		}

		if (gameState == 1) {
			levelOne.draw(win);
			ship.draw(win);
		}

		if (gameState == -1) {
			menu.printEndScreen(win, this.points);
		}

	}

	public void cleanUp() {
		
		// gets rid of lasers, enemies, etc that are not needed anymore
		for (int i = 0; i < ship.lasers.length; i++) {
			if (ship.lasers[i] != null) {
				if (ship.lasers[i].getX() > 800 || ship.lasers[i].getX() < 0 || ship.lasers[i].getY() < 0 || ship.lasers[i].getY() > 600) {
					ship.lasers[i] = null;
					System.out.println("Laser Gone.");
				}
			}
		}
		for (int j = 0; j < levelOne.badGuys.length; j++) {
			if (levelOne.badGuys[j] != null && levelOne.badGuys[j].getHp() <= 0) levelOne.badGuys[j] = null;
		}
			
	}
	
}
