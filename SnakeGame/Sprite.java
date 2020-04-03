package SnakeGame;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class Sprite implements GameObject {
	
	BufferedImage[] slides;
	int position = 0;
	public int x, y;
	Timer time;
	
	public Sprite(BufferedImage image, int rows, int cols, double delay, int x, int y) {
		
		time = new Timer(delay);
		time.start();
		slides = new BufferedImage[rows * cols];
		
		this.x = x;
		this.y = y;
		int width = image.getWidth() / cols;
		int height = image.getHeight() / rows;
		
		int count = 0;
		
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				BufferedImage subImage = image.getSubimage(j * width, i * height, width, height);
				this.slides[count] = subImage;
				count++;
			}
		}
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		if (time.update()) {
			this.position++;
			this.position %= this.slides.length;
		}
	}

	@Override
	public void draw(Graphics2D win) {
		// TODO Auto-generated method stub
		win.drawImage(this.slides[this.position], null, this.x, this.y);
	}
	
	public int getX() {
		return this.x;
	}
	
	public int getY() {
		return this.y;
	}
	
}
