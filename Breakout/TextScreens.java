package Breakout;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

public class TextScreens {
	
	String[] screens = {"title", "game over", "win"};
	// int mode;
	
	Font titleFont = new Font("Helvetica", Font.BOLD, 50);
	Font subFont = new Font("Helvetica", Font.ITALIC, 20);
	Font menuFont = new Font("Helvetica", Font.PLAIN, 25);
	Font insFont = new Font("Helvetica", Font.PLAIN, 15);
	String instructions = "How To Play:";
	String instructions1 = "Use [Left] and [Right] arrow keys to move the paddle";
	String instructions2 = "Use [Up] arrow key to fire powerups";
	String instructions3 = "Three lives, three levels";
		
	public void drawTitle(Graphics2D win) {
		win.setColor(Color.WHITE);
		drawCenteredString(win, "Breakout", titleFont, 200);
		drawCenteredString(win, "By Jay Ni", subFont, 220);
		drawCenteredString(win, "Press [Enter] to start", menuFont, 280);
		drawCenteredString(win, "Press [Esc] at any time to return to the menu", menuFont, 310);
		drawCenteredString(win, instructions, insFont, 390);
		drawCenteredString(win, instructions1, insFont, 420);
		drawCenteredString(win, instructions2, insFont, 450);
		drawCenteredString(win, instructions3, insFont, 480);
	}
	
	public void drawGameOver(Graphics2D win, int score) {
		win.setColor(Color.WHITE);
		drawCenteredString(win, "Game Over!", titleFont, 280);
		drawCenteredString(win, "Press [Esc] to return to the menu", menuFont, 340);
		String s = "Your score: " + Integer.toString(score);
		drawCenteredString(win, s, menuFont, 370);
		
	}
	
	public void drawScore(Graphics2D win, int score) {
		win.setColor(Color.WHITE);
		win.setFont(menuFont);
		String s = "Score: " + Integer.toString(score);
		win.drawString(s, 10, 700);
	}
	
	public void drawLives(Graphics2D win, int lives) {
		win.setColor(Color.WHITE);
		win.setFont(menuFont);
		String s = "Lives Left: " + Integer.toString(lives);
		win.drawString(s, 10, 670);
	}

	public void drawCenteredString(Graphics2D win, String s, Font f, int y) {
		int w = win.getFontMetrics(f).stringWidth(s);
		int h = win.getFontMetrics(f).getHeight();
		win.setFont(f);
		win.drawString(s, 400 - w/2, y - h/2);
	}
	
}



