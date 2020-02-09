package Utilities;

public class Gamestate {
	
	private int state;
	// private int maxState;
	private boolean settable = true;
	
	public Gamestate() {
		this.state = 0;
		// this.maxState = max;
		this.settable = true;
	}
	
	public void setState(int a) {
		this.state = a;
	}
	
	public void setSettable(boolean b) {
		this.settable = b;
	}
	
	public int getState() {
		return this.state;
	}
	
	public boolean getSettable() {
		return this.settable;
	}

}



