package Utilities;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

import Test.text;

public class Menu {
	
	Font titleFont = new Font("Helvetica", Font.BOLD, 50);
	Font subFont = new Font("Helvetica", Font.ITALIC, 20);
	Font menuFont = new Font("Helvetica", Font.PLAIN, 25);
	Font insFont = new Font("Helvetica", Font.PLAIN, 15);
	String title;
	String instructions;
	String instructions1;
	String instructions2;
	String instructions3;
	String author = "Game by Jay Ni";
	String replay = "Press Enter to Play Again";
	
	public Menu() {
		
	}
	
	public Menu(String title, String ins, int lives, int points) {
		this.title = title;
		this.instructions = ins;

	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public void setIns(String ins) {
		this.instructions = ins;
	}
	
	public void drawGas(Graphics2D win, int gas) {
		win.setColor(Color.WHITE);
		win.setFont(menuFont);
		String s = "Gas: " + Integer.toString(gas);
		win.drawString(s, 10, 580);
	}
	
	public void drawLives(Graphics2D win, int lives) {
		win.setColor(Color.WHITE);
		win.setFont(menuFont);
		String s = "Lives: " + Integer.toString(lives);
		win.drawString(s, 10, 590);
		// System.out.println("Drawing Score.");
	}
	
	public void drawScore(Graphics2D win, int score) {
		win.setColor(Color.WHITE);
		win.setFont(menuFont);
		String s = "Score: " + Integer.toString(score);
		win.drawString(s, 10, 550);
		// System.out.println("Drawing Score.");
	}
	
	public void drawCenteredString(Graphics2D win, String s, Font f, int y) {
		int w = win.getFontMetrics(f).stringWidth(s);
		int h = win.getFontMetrics(f).getHeight();
		win.setFont(f);
		win.drawString(s, 400 - w/2, y - h/2);
		
	}
	
	public void printSpaceGameTitleScreen(Graphics2D win) {
		win.setColor(Color.WHITE);
		this.drawCenteredString(win, this.title, titleFont, 200);
		this.drawCenteredString(win, this.author, subFont, 220);
		this.drawCenteredString(win, this.instructions, insFont, 280);
		this.drawCenteredString(win, "Use WASD to move, Left and Right arrow keys to turn, Spacebar to fire your laser", insFont, 300);
		this.drawCenteredString(win, "Power ups will appear periodically, reach a high enough point threshold to advance to the last level", insFont, 320);
		this.drawCenteredString(win, "You lose if your gas reaches zero. You will also lose gas by taking damage from enemies", insFont, 340);
		this.drawCenteredString(win, "Good luck, and beware of black holes!", insFont, 380);
		this.drawCenteredString(win, "Press Spacebar to start", insFont, 420);
	}
	
	public void printVictoryScreen(Graphics2D win, int points) {
		win.setColor(Color.WHITE);
		this.drawCenteredString(win, "Victory!", titleFont, 250);
		this.drawCenteredString(win, "Your Score: " + points, insFont, 310);
		this.drawCenteredString(win, replay, insFont, 350);
		
	}
	
	public void printGameOverScreen(Graphics2D win, int points) {
		win.setColor(Color.WHITE);
		this.drawCenteredString(win, "Game Over", titleFont, 250);
		this.drawCenteredString(win, "Your Score: " + points, insFont, 310);
		this.drawCenteredString(win, replay, insFont, 350);
		
	}
	
}
