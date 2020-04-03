package SnakeGame;

public class Timer {
	
	int tick;
	double delay;
	public boolean isCounting = false;
	
	public Timer(double delay) {
		this.delay = delay;
	}
	
	public void start() {
		this.isCounting = true;
	}
	
	public void stop() {
		this.isCounting = false;
	}
	
	public void restart() {
		this.tick = 0;
		this.start();
	}
	
	public boolean update() {
		if (this.isCounting) {
			if (this.tick >= this.delay * GameObject.FPS) {
				this.tick = 0;
				return true;
			} else {
				this.tick++;
			}
		}
		return false;
	}
	
}
