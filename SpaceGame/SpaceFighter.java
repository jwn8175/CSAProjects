package SpaceGame;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

import Utilities.GDV5;
import Utilities.Menu;

public class SpaceFighter extends GDV5 {

	int gameState;
	static int currentTime = 1;
	int gasLossInterval = 60;
	// int shootTimer = 180;
	static int score;
	static Ship ship = new Ship();
	Menu menu = new Menu();
	Space space = new Space();
	static Mothership one = new Mothership(1);
	static Mothership two = new Mothership(2);
	static Mothership three = new Mothership(3);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SpaceFighter game = new SpaceFighter();
		game.start();
		// System.out.println(game.ship.layer2.getBounds2D().getHeight()); // is 100
		// System.out.println(game.ship.getBounds2D().getWidth()); // is 80
		
	}

	public SpaceFighter() {

		this.gameState = 3;
		score = 0;
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
		
		if (gameState >= 1) {
			if (timer(currentTime, this.gasLossInterval)) ship.gas--;
			if (ship.gas == 0) gameState = -1;
			space.update(this.getHeight());
			ship.update();
		}

		if (gameState == 1) {
			one.update();
		}
		
		if (gameState == 2) {
			two.update();
		}
		
		if (gameState == 3) {
			three.update();
		}
		
		if (gameState == -1) {
			if (GDV5.KeysTyped[KeyEvent.VK_ENTER]) {
				this.reset();
				GDV5.KeysTyped[KeyEvent.VK_ENTER] = false;
			}
		}
		
		currentTime++;
		this.cleanUp();

	}

	@Override
	public void draw(Graphics2D win) {
		// TODO Auto-generated method stub

		if (gameState == 0) {
			menu.printTitleScreen(win);
		}
		
		if (gameState >= 1) {
			// space.draw(win);
			ship.draw(win);
			menu.drawScore(win, score);
			menu.drawGas(win, ship.gas);
		}
		
		if (gameState == 1) {
			one.draw(win);
		}
		
		if (gameState == 2) {
			two.draw(win);
		}
		
		if (gameState == 3) {
			three.draw(win);
		}

		if (gameState == -1) {
			menu.printEndScreen(win, score);
		}

	}
	
	// gets rid of lasers, enemies, etc that are not needed anymore
	public void cleanUp() {
		
		/*
		for (int i = 0; i < ship.lasers.length; i++) {
			if (ship.lasers[i] != null) {
				if (ship.lasers[i].getX() > 800 || ship.lasers[i].getX() < 0 || ship.lasers[i].getY() < 0 || ship.lasers[i].getY() > 600) {
					ship.lasers[i] = null;
					// System.out.println("Laser Gone");
				}
			}
		}
		*/
				
		for (int j = 0; j < one.badGuys.length; j++) {
			if (one.badGuys[j] != null && one.badGuys[j].done) one.badGuys[j] = null;
		}
		
		for (int k = 0; k < two.badGuys.length; k++) {
			if (two.badGuys[k] != null && two.badGuys[k].done) two.badGuys[k] = null;
		}

	}
	
	public boolean timer(int current, int target) {
		return (current % target == 0);
	}
	
	public void reset() {
		this.gameState = 0;
		score = 0;
		ship.gas = 50;
	}
	
}
