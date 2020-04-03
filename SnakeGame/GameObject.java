package SnakeGame;

import java.awt.Graphics2D;

public interface GameObject {
	
	public static int width = 800, height = 600, FPS = 60;
	
	public void update();
	public void draw(Graphics2D win);
}
