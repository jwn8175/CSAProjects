package Breakout;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

import Utilities.GDV5;
import Utilities.SoundDriverHo;

public class Breakout extends GDV5 {

	// for gamestate
	Gamestate gamestate = new Gamestate();

	// for player
	int hearts = 3;
	int score = 0;
	int currentBricks = 1; // 40

	// for menu
	TextScreens menus = new TextScreens();

	// for level
	Level level = new Level();

	// for paddle
	Paddle pad = new Paddle();

	// for ball
	Ball ball = new Ball();
	
	// for powerup
	Powerup powerup = null;
	
	// for laser
	// Laser laser = new Laser(pad);
	
	// for particles
	Boom boom = null;

	// for sound
	String[] sounds = {"sound.wav", "miiSound.wav"};
	SoundDriverHo sd = new SoundDriverHo(sounds, this);
	
	public Breakout() {
		gamestate.setState(0);

	}

	public static void main(String[] args) {

		Breakout g1 = new Breakout();
		g1.setSize(785, 750);
		g1.start();

	}

	@Override
	public void update() {
		if (!sd.isPlaying(1)) sd.play(1);
		sd.setVolume(0, (float) -10);
		
		if (GDV5.KeysPressed[KeyEvent.VK_ESCAPE]) reset();

		if (gamestate.getState() == 0) {
			if (GDV5.KeysPressed[KeyEvent.VK_ENTER]) gamestate.setState(1);
		}

		if (gamestate.getState() > 0 && gamestate.getState() < 4) {
			if (this.hearts == 0) gamestate.setState(4);
			if (Brick.s) {
				sd.play(0);
				this.currentBricks --;
				Brick.s = false;
			}
		}

		if (gamestate.getState() == 1) {
			// System.out.println(this.currentBricks);
			pad.move();
			ball.move(pad, level.one, level.placeholder, this);
			
			thing(level.one);
			
			if (this.currentBricks == 0) {
				gamestate.setState(2);
				this.next();
				this.currentBricks = 1; // 24
			}
		}

		if (gamestate.getState() == 2) {
			pad.move();
			ball.move(pad, level.two, level.placeholder, this);
			
			thing(level.two);
			
			if (this.currentBricks == 0) {
				gamestate.setState(3);
				this.next();
				this.currentBricks = 24; // 24
			}
		}

		if (gamestate.getState() == 3) {
			pad.move();
			ball.move(pad, level.three, level.sb, this);
			
			thing(level.three);
			
			level.update();
			if (this.currentBricks == 0) {
				gamestate.setState(4);
				this.next();
			}
		}

		if (boom != null) boom.update();
		if (powerup != null) powerup.update(pad);
	}

	@Override
	public void draw(Graphics2D win) {

		if (gamestate.getState() == 0) menus.drawTitle(win);

		if (gamestate.getState() > 0 && gamestate.getState() < 4) {
			pad.draw(win);
			ball.draw(win);
			menus.drawScore(win, this.score);
			menus.drawLives(win, this.hearts);
		}

		if (gamestate.getState() == 1) {
			level.levelOne(win);
		}

		if (gamestate.getState() == 2) {
			level.levelTwo(win);
		}

		if (gamestate.getState() == 3) {
			level.levelThree(win);
		}

		if (gamestate.getState() == 4) {
			menus.drawGameOver(win, this.score);
		}

		if (Brick.isBoom) {
			boom = new Boom(ball);
			Brick.isBoom = false;
		}
		
		if (boom != null) {
			boom.draw(win);
		}
		
		if (Brick.isPowerup) {
			powerup = new Powerup(ball);
			Brick.isPowerup = false;
		}
		
		if (powerup != null) {
			powerup.draw(win);
		}
	}
	
	public void thing(Brick[] wall) {
		if (powerup != null && powerup.laser != null) {
			powerup.hitBrick(wall, this);
			if (Brick.s) {
				powerup = null;
			} else if (powerup.laser.getMaxY() < 0) {
				powerup = null;
			}
		}
	}
	
	public void next() {
		
		powerup = null;
		
		pad = null;
		pad = new Paddle();

		ball = null;
		ball = new Ball();
		
		// powerup = new Powerup(ball);

	}

	public void reset() {

		gamestate.setState(0);
		this.hearts = 3;
		this.score = 0;

		level = null;
		level = new Level();

		pad = null;
		pad = new Paddle();

		ball = null;
		ball = new Ball();
		
		this.currentBricks = 40;
		

	}

}




