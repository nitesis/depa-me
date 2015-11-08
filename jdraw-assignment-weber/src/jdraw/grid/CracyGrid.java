package jdraw.grid;

import java.awt.Point;

import jdraw.framework.PointConstrainer;

public class CracyGrid implements PointConstrainer {
	
	int currentValue = 0;

	@Override
	public Point constrainPoint(Point p) {
		return new Point(getRandomAxis(p.x), getRandomAxis(p.y));
	}
	
	private int getRandomAxis(int source){
		int sign = 1;
		if(Math.random()*10 < 5){
			sign = -1;
		}
		currentValue = (int)(Math.random() * 50 * sign);
		return source + currentValue;
	}
	
	

	@Override
	public int getStepX(boolean right) {
		return currentValue;
	}

	@Override
	public int getStepY(boolean down) {
		return currentValue;
	}

	@Override
	public void activate() {
		// NOP
		
	}

	@Override
	public void deactivate() {
		// NOP
		
	}

	@Override
	public void mouseDown() {
		// NOP
		
	}

	@Override
	public void mouseUp() {
		// NOP
		
	}

}
