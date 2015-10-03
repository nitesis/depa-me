/*
 * Copyright (c) 2000-2016 Fachhochschule Nordwestschweiz (FHNW)
 * All Rights Reserved. 
 */

package jdraw.figures;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.util.LinkedList;
import java.util.List;


import jdraw.framework.Figure;
import jdraw.framework.FigureEvent;
import jdraw.framework.FigureHandle;
import jdraw.framework.FigureListener;

/**
 * Represents rectangles in JDraw.
 * 
 * @author Christoph Denzler
 *
 */
public class Oval implements Figure{
	/**
	 * Use the java.awt.Rectangle in order to save/reuse code.
	 */
	private java.awt.geom.Ellipse2D oval;
	private List<FigureListener> listeners = new LinkedList<>();
	
	/**
	 * Create a new rectangle of the given dimension.
	 * @param x the x-coordinate of the upper left corner of the rectangle
	 * @param y the y-coordinate of the upper left corner of the rectangle
	 * @param w the rectangle's width
	 * @param h the rectangle's height
	 */
	public Oval(int x, int y, int w, int h) {
		oval = new java.awt.geom.Ellipse2D.Double(x, y, w, h);
	}

	/**
	 * Draw the rectangle to the given graphics context.
	 * @param g the graphics context to use for drawing.
	 */
	public void draw(Graphics g) {
		g.setColor(Color.GRAY);
		g.fillOval((int)oval.getX(), (int)oval.getY(), 
				(int)oval.getWidth(), (int)oval.getHeight());
		g.setColor(Color.PINK);
		g.drawOval((int)oval.getX(), (int)oval.getY(), 
				(int)oval.getWidth(), (int)oval.getHeight());
	}
	
	@Override
	public void setBounds(Point origin, Point corner) {
		oval.setFrameFromDiagonal(origin, corner);
		// XXX Notifikation eingentlich nur falls sich die Figur geändert hat.
		update(new FigureEvent(this));
	}

	@Override
	public void move(int dx, int dy) {
//		if(dx != 0 || dy != 0) {
//		oval.set.setLocation((int)oval.getX() + dx, (int)oval.getY() + dy);
//		
//		update(new FigureEvent(this));
//		}		
	}

	@Override
	public boolean contains(int x, int y) {
		return oval.contains(x, y);
	}

	@Override
	public Rectangle getBounds() {
		return oval.getBounds();
	}

	/**
	 * Returns a list of 8 handles for this Rectangle.
	 * @return all handles that are attached to the targeted figure.
	 * @see jdraw.framework.Figure#getHandles()
	 */	
	public List<FigureHandle> getHandles() {
		return null;
	}

	@Override
	public void addFigureListener(FigureListener listener) {
		listeners.add(listener);
	}

	@Override
	public void removeFigureListener(FigureListener listener) {
		listeners.remove(listener);
	}

	@Override
	public Figure clone() {
		return null;
	}
	
	// XXX ich würde diese Methode nicht als public deklarieren, denn sie soll nur intern aufgerufen werden 
	//     wenn sich der Zustand geändert hat => private
	private void update(FigureEvent e) {
		// XXX auch hier, iteriert werden sollte über eine Kopie der Listener.
		FigureListener[] copy;
		// ???Warum hier synchronized???
		synchronized(this) { 
			copy = listeners.toArray(new FigureListener[listeners.size()]);
			} 
		for (FigureListener l : copy) { 
			l.figureChanged(e); 
		}
		// old version
//		for (FigureListener l : listeners) {
//			l.figureChanged(e);
//		}
	}

	
}