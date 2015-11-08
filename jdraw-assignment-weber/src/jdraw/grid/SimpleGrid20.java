package jdraw.grid;

import java.awt.Point;

import jdraw.framework.PointConstrainer;

public class SimpleGrid20 implements PointConstrainer {

	private final int grid = 20;
	
	@Override
	public Point constrainPoint(Point p) {
		return new Point(findConstraintAxisValue(p.x), findConstraintAxisValue(p.y));
	}
	
	private int findConstraintAxisValue(int source){
		return ((source + grid/2)/grid) * grid;
	}

	@Override
	public int getStepX(boolean right) {
		return grid;
	}

	@Override
	public int getStepY(boolean down) {
		return grid;
	}

	@Override
	public void activate() {
		//NOP
	}

	@Override
	public void deactivate() {
		// NOP
		
	}

	@Override
	public void mouseDown() {
		
	}

	@Override
	public void mouseUp() {
		
	}

}
