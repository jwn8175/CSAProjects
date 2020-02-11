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
	Mothership mother = new Mothership();
	Mothership levelOne = new Mothership(1);
	Laser laser = new Laser();

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SpaceFighter game = new SpaceFighter();
		game.start();

	}

	public SpaceFighter() {

		gameState = 0;
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
			// mother.levelOne();	
			levelOne.update();
			ship.update();

		}

	}

	@Override
	public void draw(Graphics2D win) {
		// TODO Auto-generated method stub

		if (gameState == 0) {
			menu.printTitleScreen(win);
		}

		if (gameState == 1) {

			// space.draw(win);
			// mother.drawOne(win);
			levelOne.draw(win);
			laser.draw(win);
			ship.draw(win);

		}

		if (gameState == -1) {
			menu.printEndScreen(win, this.points);
		}

	}

}
