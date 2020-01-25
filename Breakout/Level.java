package Breakout;

import java.awt.Graphics2D;

public class Level {

	// for bricks
	int gray = -1;
	int magenta = 3;
	int red = 2;
	int yellow = 1;
	
	// for switch bricks
	int cyan = 0;
	int green = 1;
	SBrick[] sb = new SBrick[28];
	SBrick[] placeholder = new SBrick[0];
	boolean timer = true;
	int count = 0;
	int target = 100;

	// for walls
	Brick[] one = new Brick[5 * 8];
	Brick[] two = new Brick[7 * 8];
	Brick[] three = new Brick[30];
	
	// brick counter
	// int currentBricks;

	public Level() {

		int count = 0;

		// level 1
		for (int j = 0; j < 8; j++) {
			one[count] = new Brick(j * (Brick.buffer + Brick.width) + Brick.width, 
					Brick.height, magenta);
			count++;
		}

		for (int j = 0; j < 8; j++) {
			one[count] = new Brick(j * (Brick.buffer + Brick.width) + Brick.width, 
					2 * (Brick.buffer + Brick.height) - Brick.buffer, red);
			count++;
		}


		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 8; j++) {
				one[count] = new Brick(j * (Brick.buffer + Brick.width) + Brick.width, 
						i * (Brick.buffer + Brick.height) + Brick.buffer * 2 + Brick.height * 3, yellow);
				count++;
			}
		}


		count = 0;

		// level 2
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 8; j++) {
				two[count] = new Brick(j * (Brick.buffer + Brick.width) + Brick.width, 
						i * (Brick.height + Brick.buffer) + Brick.height, magenta);
				count++;
			}
		}

		for (int j = 0; j < 8; j++) {
			two[count] = new Brick(j * (Brick.buffer + Brick.width) + Brick.width, 
					(Brick.buffer + Brick.height) + Brick.buffer * 1 + Brick.height * 2, gray);
			count++;
		}

		for (int j = 0; j < 8; j++) {
			two[count] = new Brick(j * (Brick.buffer + Brick.width) + Brick.width, 
					(Brick.buffer + Brick.height) + Brick.buffer * 2 + Brick.height * 3, red);
			count++;
		}

		for (int j = 0; j < 8; j++) {
			two[count] = new Brick(j * (Brick.buffer + Brick.width) + Brick.width, 
					(Brick.buffer + Brick.height) + Brick.buffer * 4 + Brick.height * 5, gray);
			count++;
		}

		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 8; j++) {
				two[count] = new Brick(j * (Brick.buffer + Brick.width) + Brick.width, 
						i * (Brick.buffer + Brick.height) + Brick.buffer * 6 + Brick.height * 7, yellow);
				count++;
			}
		}

		two[16].setLives(3);
		two[23].setLives(3);
		two[32].setSize(0, 0);
		two[39].setSize(0, 0);
		two[40].setSize(0, 0);
		two[47].setSize(0, 0);
		two[48].setSize(0, 0);
		two[55].setSize(0, 0);
		
		count = 0;
		
		// TODO level 3
		
		int counT = 0;
		
		for (int j = 0; j < 8; j++) {
			if (j < 4) sb[count] = new SBrick(j * (SBrick.buffer + SBrick.width) + SBrick.width, 
					(SBrick.buffer + SBrick.height), cyan);
			if (j >= 4) sb[count] = new SBrick(j * (SBrick.buffer + SBrick.width) + SBrick.width, 
					(SBrick.buffer + SBrick.height), green);
			// System.out.println(count);
			count++;
		}
		
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 8; j++) {
				if (j == 0 || j == 3) {
					sb[count] = new SBrick(j * (SBrick.buffer + SBrick.width) + SBrick.width, 
							i * (SBrick.buffer + SBrick.height) + 2 * (SBrick.height + SBrick.buffer), cyan);
					count++;
				}
				if (j == 4 || j == 7) {
					sb[count] = new SBrick(j * (SBrick.buffer + SBrick.width) + SBrick.width, 
							i * (SBrick.buffer + SBrick.height) + 2 * (SBrick.height + SBrick.buffer), green);
					// System.out.println(count);
					count++;
				}
			}
		}

		for (int j = 0; j < 8; j++) {
			if (j < 4) sb[count] = new SBrick(j * (SBrick.buffer + SBrick.width) + SBrick.width, 
					(SBrick.buffer + SBrick.height) * 5, cyan);
			if (j >= 4) sb[count] = new SBrick(j * (SBrick.buffer + SBrick.width) + SBrick.width, 
					(SBrick.buffer + SBrick.height) * 5, green);
			// System.out.println(count);
			count++;
		}
		
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 8; j++) {
				if (j == 1 || j == 2 || j == 5 || j == 6) {
					three[counT] = new Brick(j * (Brick.buffer + Brick.width) + Brick.width,  
							(Brick.buffer + Brick.height) + (i + 1) * (Brick.height + Brick.buffer), magenta);
					counT++;
				}
			}
		}
		
		for (int j = 0; j < 8; j++) {
			if (j > 0 && j < 7) {
				three[counT] = new Brick(j * (Brick.buffer + Brick.width) + Brick.width, 
						(Brick.buffer + Brick.height) * 7, gray);
				counT++;
			}
		}
		
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 8; j++) {
				if (j > 0 && j < 7) {
					three[counT] = new Brick(j * (Brick.buffer + Brick.width) + Brick.width, 
							(i + 8) * (Brick.buffer + Brick.height), red);
					counT++;
				}
			}
		}
		

	}
	
	public void update() {
		if (timer) count++;
		if (count == target) {
			for (SBrick sb : sb) {
				sb.swap();
			}
			count = 0;
		}
	}
	
	public void levelOne(Graphics2D win) {

		for (Brick b : one) {
			b.draw(win);
		}
	}

	public void levelTwo(Graphics2D win) {

		for (Brick b : two) {
			b.draw(win);
		}
	}

	public void levelThree(Graphics2D win) {

		for (Brick b : three) {
			b.draw(win);
		}
		
		for (SBrick sb : sb) {
			sb.draw(win);
		}
	}

}






