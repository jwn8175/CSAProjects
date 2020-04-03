package SnakeGame;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.Random;

public class Food extends Rectangle implements GameObject {
	
	static int size = 40;
	Color foodColor = Color.RED;
	
	public Food(int x, int y) {
		super(x, y, size, size);
	}
	
	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void draw(Graphics2D win) {
		// TODO Auto-generated method stub
		win.setColor(foodColor);
		win.fill(this);
	}

}
