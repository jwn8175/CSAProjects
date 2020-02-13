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
	
	public void drawCenteredString(Graphics2D win, String s, Font f, int y) {
		int w = win.getFontMetrics(f).stringWidth(s);
		int h = win.getFontMetrics(f).getHeight();
		win.setFont(f);
		win.drawString(s, 400 - w/2, y - h/2);
		
	}
	
	public void printTitleScreen(Graphics2D win) {
		win.setColor(Color.WHITE);
		this.drawCenteredString(win, this.title, titleFont, 200);
		this.drawCenteredString(win, this.author, subFont, 220);
		this.drawCenteredString(win, this.instructions, insFont, 280);
		
	}
	
	public void printEndScreen(Graphics2D win, int points) {
		win.setColor(Color.WHITE);
		this.drawCenteredString(win, "Game Over", titleFont, 250);
		this.drawCenteredString(win, "Your Score: " + points, insFont, 310);
		this.drawCenteredString(win, replay, insFont, 350);
		
	}
	
}
