/*
 * Copyright (c) 2000-2016 Fachhochschule Nordwestschweiz (FHNW)
 * All Rights Reserved. 
 */

package jdraw.figures;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.LinkedList;
import java.util.List;


import jdraw.framework.Figure;
import jdraw.framework.FigureEvent;
import jdraw.framework.FigureHandle;
import jdraw.framework.FigureListener;
import jdraw.std.AbstractFigure;
import jdraw.std.AbstractRectangularFigure;

/**
 * Represents rectangles in JDraw.
 * 
 * @author Christoph Denzler
 *
 */
public class Rect extends AbstractRectangularFigure implements Figure{
	
//	protected Rect(Point origin) {
//		super(origin);
//		// TODO Auto-generated constructor stub
//	}

	/**
	 * Use the java.awt.Rectangle in order to save/reuse code.
	 */
//	private java.awt.Rectangle rectangle;
	private List<FigureListener> listeners = new LinkedList<>();
	
	/**
	 * Create a new rectangle of the given dimension.
	 * @param x the x-coordinate of the upper left corner of the rectangle
	 * @param y the y-coordinate of the upper left corner of the rectangle
	 * @param w the rectangle's width
	 * @param h the rectangle's height
	 */
	public Rect(int x, int y) {
		this(x, y, 0, 0);
	}
	/**
	 * Create a new rectangle of the given dimension.
	 * @param x the x-coordinate of the upper left corner of the rectangle
	 * @param y the y-coordinate of the upper left corner of the rectangle
	 * @param w the rectangle's width
	 * @param h the rectangle's height
	 */
	public Rect(int x, int y, int w, int h) {
		super(new Point(x, y));
		this.setBounds(new Point(x, y), new Point(x + w, y + h));
	}

	/**
	 * Draw the rectangle to the given graphics context.
	 * @param g the graphics context to use for drawing.
	 */
	public void draw(Graphics g) {
		Rectangle r = getBounds(); 
		g.setColor(Color.black); 
		g.drawRect(r.x, r.y, r.width, r.height);
	}
	
//	@Override
//	public void setBounds(Point origin, Point corner) {
//		rectangle.setFrameFromDiagonal(origin, corner);
//		// XXX Notifikation eingentlich nur falls sich die Figur geändert hat.
//		notifyListener(new FigureEvent(this));
//	}
//
//	@Override
//	public void move(int dx, int dy) {
//		if(dx != 0 || dy != 0) {
//		rectangle.setLocation(rectangle.x + dx, rectangle.y + dy);
//		
//		notifyListener(new FigureEvent(this));
//		}		
//	}
//
//	@Override
//	public boolean contains(int x, int y) {
//		return rectangle.contains(x, y);
//	}
//
//	@Override
//	public Rectangle getBounds() {
//		return rectangle.getBounds();
//	}

	/**
	 * Returns a list of 8 handles for this Rectangle.
	 * @return all handles that are attached to the targeted figure.
	 * @see jdraw.framework.Figure#getHandles()
	 */	
	public List<FigureHandle> getHandles() {
		List<FigureHandle> handles = new LinkedList<>(); 
		handles.add(new NorthWestHandle(this));
		handles.add(new NorthHandle(this));
		handles.add(new NorthEastHandle(this));
		handles.add(new SouthHandle(this));
		handles.add(new WestHandle(this));
		handles.add(new EastHandle(this));
		return handles;
	}

//	@Override
//	public void addFigureListener(FigureListener listener) {
//		listeners.add(listener);
//	}
//
//	@Override
//	public void removeFigureListener(FigureListener listener) {
//		listeners.remove(listener);
//	}

	@Override
	public Figure clone() {
		return null;
	}
	
//	// XXX ich würde diese Methode nicht als public deklarieren, denn sie soll nur intern aufgerufen werden 
//	//     wenn sich der Zustand geändert hat => private
//	private void update(FigureEvent e) {
//		// XXX auch hier, iteriert werden sollte über eine Kopie der Listener.
//		FigureListener[] copy;
//		// ???Warum hier synchronized???
//		synchronized(this) { 
//			copy = listeners.toArray(new FigureListener[listeners.size()]);
//			} 
//		for (FigureListener l : copy) { 
//			l.figureChanged(e); 
//		}
		// old version
//		for (FigureListener l : listeners) {
//			l.figureChanged(e);
//		}
//	}

}
