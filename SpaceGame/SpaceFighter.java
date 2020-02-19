package SpaceGame;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

import Utilities.GDV5;
import Utilities.Menu;

public class SpaceFighter extends GDV5 {

	int gameState;
	static int currentTime = 1;
	int gasLossInterval = 60;
	int invulnerabilityPeriod = 90;
	boolean invulnerability = true;
	boolean holeActive = false;
	static int score;
	static Ship ship = new Ship();
	BlackHole hole = new BlackHole();
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

		this.gameState = 0;
		score = 0;
		this.menu.setTitle("Space Shooter Game");
		this.menu.setIns("Instructions: ");

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
			if (ship.gas <= 0) gameState = -2;
			holeActive = ship.intersects(hole);
			if (holeActive) {
				ship.gas--;
			}
			space.update(this.getHeight());
			ship.update();
			hole.update();
		}

		if (gameState == 1) {
			one.update();
			if (score >= 150) {
				this.invulnerabilityPeriod = 90;
				this.invulnerability = false;
				this.gameState = 2;
				ship.gas = 100;
			}
		}
		
		if (gameState == 2) {
			two.update();
		}
		
		if (gameState == 3) {
			three.update();
			if (three.badGuys[0] == null) gameState = -1;
		}
		
		if (gameState == -1 || gameState == -2) {
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
			menu.printSpaceGameTitleScreen(win);
		}
		
		if (gameState >= 1) {
			space.draw(win);
			hole.draw(win);
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
			menu.printVictoryScreen(win, score);
		}
		
		if (gameState == -2) {
			menu.printGameOverScreen(win, score);
		}

	}
	
	// gets rid of lasers, enemies, etc that are not needed anymore
	public void cleanUp() {
				
		for (int j = 0; j < one.badGuys.length; j++) {
			if (one.badGuys[j] != null && one.badGuys[j].done) one.badGuys[j] = null;
		}
		
		for (int k = 0; k < two.badGuys.length; k++) {
			if (two.badGuys[k] != null && two.badGuys[k].done) two.badGuys[k] = null;
		}
		
		for (int k = 0; k < three.badGuys.length; k++) {
			if (three.badGuys[k] != null && three.badGuys[k].done) three.badGuys[k] = null;
		}

	}
	
	public boolean timer(int current, int target) {
		return (current % target == 0);
	}
	
	public void reset() {
		this.gameState = 0;
		score = 0;
		ship = new Ship();
		one = new Mothership(1);
		two = new Mothership(2);
		three = new Mothership(3);
	}
	
}
