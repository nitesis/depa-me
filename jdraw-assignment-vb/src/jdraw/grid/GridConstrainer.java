package jdraw.grid;

import java.awt.Point;

import jdraw.framework.PointConstrainer;

public class GridConstrainer implements PointConstrainer{
	
	private int stepX, stepY;

	public GridConstrainer(int sx, int sy) {
	      this.stepX = Math.max(1, sx);
	      this.stepY = Math.max(1, sy);
	   }
	@Override
	public Point constrainPoint(Point p) {
		int x = ((p.x+stepX/2) / stepX) * stepX; 
		int y = ((p.y+stepY/2) / stepY) * stepY; 
		return new Point(x, y);
		//System.out.println("SimpleGrid:constrainPoint: " + p); 
	}

	//wird hier nicht gebraucht
	@Override
	public int getStepX(boolean right) {
		//System.out.println("SimpleGrid:getStepX: " + 1);
		return stepX;
	}

	//wird hier nicht gebraucht
	@Override
	public int getStepY(boolean down) {
		// TODO Auto-generated method stub
		return stepY;
	}

	@Override
	public void activate() {
		System.out.println("SimpleGrid " + getStepX(true) + " :activate()");
	}

	@Override
	public void deactivate() {
		System.out.println("SimpleGrid " + getStepX(true) + " :deactivate()");
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
