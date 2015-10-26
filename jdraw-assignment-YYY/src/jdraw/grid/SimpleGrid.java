package jdraw.grid;

import java.awt.Point;

import jdraw.framework.PointConstrainer;

public class SimpleGrid implements PointConstrainer{

	@Override
	public Point constrainPoint(Point p) {
		System.out.println("SimpleGrid:constrainPoint: " + p); 
		return p;
	}

	@Override
	public int getStepX(boolean right) {
		System.out.println("SimpleGrid:getStepX: " + 1);
		return 1;
	}

	@Override
	public int getStepY(boolean down) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void activate() {
		System.out.println("SimpleGrid:activate()");
	}

	@Override
	public void deactivate() {
		System.out.println("SimpleGrid:deactivate()");
	}

	@Override
	public void mouseDown() {
		System.out.println("SimpleGrid:mouseDown()");
	}

	@Override
	public void mouseUp() {
		System.out.println("SimpleGrid:mouseUp()");
	}

}
