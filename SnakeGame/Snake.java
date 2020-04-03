package SnakeGame;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import Utilities.GDV5;

public class Snake implements GameObject {
	
	Rectangle head;
	ArrayList<Rectangle> body = new ArrayList<Rectangle>();
	Color snakeColor = Color.BLUE.brighter();
	Timer timer;
	int direction; // up is 0 right is 1 down is 2 left is 3
	int speed = 40; // snake is moving at constant speed
	int dy, dx; // should be 1 or -1 depending on what direction the snake is going
	
	public Snake() {
		head = new Rectangle(360, 280, 40, 40);
		body.add(head);
		this.timer = new Timer(.25);
		this.timer.start();
		this.direction = -1;

	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		// dx = 0;
		// dy = 0;
		this.controls();
		
		if (this.timer.update()) {
			// System.out.println(this.timer.update());
			this.head.setLocation((int) (head.getX() + dx), (int) (head.getY() + dy));
		}
		
	}

	@Override
	public void draw(Graphics2D win) {
		// TODO Auto-generated method stub
		win.setColor(this.snakeColor);
		win.fill(head);
	}
	
	public void controls() {
		// up is 0 right is 1 down is 2 left is 3
		if (GDV5.KeysTyped[KeyEvent.VK_UP] && direction != 2) {
			dy = speed * -1;
			dx = 0;
			direction = 0;
			System.out.println("Up");
		}
		if (GDV5.KeysTyped[KeyEvent.VK_DOWN] && direction != 0) {
			dy = speed;
			dx = 0;
			direction = 2;
			System.out.println("Down");
		}
		if (GDV5.KeysTyped[KeyEvent.VK_RIGHT] && direction != 3) {
			dy = 0;
			dx = speed;
			direction = 1;
			System.out.println("Right");
		}
		if (GDV5.KeysTyped[KeyEvent.VK_LEFT] && direction != 1) {
			dy = 0;
			dx = speed * -1;
			direction = 3;
			System.out.println("Left");
		}
		GDV5.KeysTyped[KeyEvent.VK_UP] = false;
		GDV5.KeysTyped[KeyEvent.VK_DOWN] = false;
		GDV5.KeysTyped[KeyEvent.VK_RIGHT] = false;
		GDV5.KeysTyped[KeyEvent.VK_LEFT] = false;
	}
	
}
