package jdraw.figures;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.geom.Line2D;
import java.util.LinkedList;
import java.util.List;

import jdraw.framework.Figure;
import jdraw.framework.FigureEvent;
import jdraw.framework.FigureHandle;
import jdraw.framework.FigureListener;

public class Line implements Figure {

	/**
	 * Use the java.awt.Line2D in order to save/reuse code.
	 */
	private java.awt.geom.Line2D line;
	private List<FigureListener> listeners = new LinkedList<>();
	
	public Line (double x1, double y1, double x2, double y2) {
		line = new java.awt.geom.Line2D.Double (x1, y1, x2, y2);	
	}
	
	/**
	 * Draw the line to the given graphics context.
	 * @param g the graphics context to use for drawing.
	 */
	@Override
	public void draw(Graphics g) {
		g.setColor(Color.BLACK);
		//Ist das hier eine gute Idee mit dem Casten?
		g.drawLine((int)line.getX1(), (int)line.getY1(), (int)line.getX2(), (int)line.getY2());
		
	}

	@Override
	public void move(int dx, int dy) {
		if(dx != 0 || dy != 0) {
			line.setLine(line.getX1() + dx, line.getY1() + dy, line.getX2() + dx, line.getY2() + dy);
			// TODO notification of change
			update(new FigureEvent(this));
			}	
		
	}

	@Override
	public boolean contains(int x, int y) {
		return line.contains(x, y);
	}

	@Override
	public void setBounds(Point origin, Point corner) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Rectangle getBounds() {
		return line.getBounds();
	}

	@Override
	public List<FigureHandle> getHandles() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addFigureListener(FigureListener listener) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeFigureListener(FigureListener listener) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Figure clone() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public void update(FigureEvent e) {
		for (FigureListener l : listeners) {
			l.figureChanged(e);
		}
	}

}
