package Breakout;

public class Gamestate {
	
	int state;
	boolean settable = true;
	
	public Gamestate() {
		this.state = 0;
		this.settable = true;
	}
	
	public void setState(int a) {
		this.state = a;
	}
	
	public void setSettable() {
		this.settable = !this.settable;
	}
	
	public int getState() {
		return this.state;
	}
	
	public boolean getSettable() {
		return this.settable;
	}

}



