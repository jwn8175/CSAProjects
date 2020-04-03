package SnakeGame;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Random;

import Utilities.GDV5;

public class SnakeGame extends GDV5 implements GameObject {
	
	static ArrayList<GameObject> items;
	static boolean isFood = false;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SnakeGame s1 = new SnakeGame();
		s1.start();
	}
	
	public SnakeGame() {
		super(GameObject.FPS);
		this.setBackground(Color.GREEN.darker());
		items = new ArrayList<GameObject>();
		Snake snake = new Snake();
		items.add(snake);
		// System.out.println(items.indexOf(snake));
	}
	
	@Override
	public void update() {
		// TODO Auto-generated method stub
		if (!isFood) {
			this.makeFood();
		}
		for (GameObject g : items) {
			g.update();
		}
	}

	@Override
	public void draw(Graphics2D win) {
		// TODO Auto-generated method stub
		this.drawGrid(win);
		for (int i = 1; i < items.size(); i++) {
			items.get(i).draw(win);
		}
		items.get(0).draw(win);
	}
	
	public void drawGrid(Graphics2D win) {
		win.setColor(Color.GRAY);
		for (int i = 40; i < GameObject.width; i += 40) {
			win.drawLine(i, 0, i, 600);
		}
		for (int i = 0; i < GameObject.height; i += 40) {
			win.drawLine(0, i, 800, i);
		}
	}
	
	public void makeFood() {
		Random rand = new Random();
		Point point = new Point(rand.nextInt(20) * 40, rand.nextInt(15) * 40);
		Snake tempS = (Snake) items.get(0);
		for (Rectangle rect : tempS.body) {
			if (rect.contains(point)) {
				makeFood();
			} else {
				isFood = true;
				items.add(new Food(point.x, point.y));
			}
		}
		
	}

}
