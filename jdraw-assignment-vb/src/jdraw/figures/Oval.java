/*
 * Copyright (c) 2000-2016 Fachhochschule Nordwestschweiz (FHNW)
 * All Rights Reserved. 
 */

package jdraw.figures;

import java.awt.Color;
import java.awt.Event;
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
public class Oval extends AbstractRectangularFigure {
	/**
	 * Use the java.awt.Rectangle in order to save/reuse code.
	 */
//	private java.awt.geom.Ellipse2D oval;
	private List<FigureListener> listeners = new LinkedList<>();

	/**
	 * Create a new rectangle of the given dimension.
	 * 
	 * @param x
	 *            the x-coordinate of the upper left corner of the rectangle
	 * @param y
	 *            the y-coordinate of the upper left corner of the rectangle
	 * @param w
	 *            the rectangle's width
	 * @param h
	 *            the rectangle's height
	 */
	public Oval(int x, int y, int w, int h) {
		super(new Point(x, y));
	}

	/**
	 * Draw the rectangle to the given graphics context.
	 * 
	 * @param g
	 *            the graphics context to use for drawing.
	 */
	public void draw(Graphics g) {
		Rectangle bounds = g.getClipBounds();
		g.setColor(Color.GRAY);
		g.fillOval((int) bounds.getX(), (int) bounds.getY(), (int) bounds.getWidth(), (int) bounds.getHeight());
		g.setColor(Color.PINK);
		g.drawOval((int) bounds.getX(), (int) bounds.getY(), (int) bounds.getWidth(), (int) bounds.getHeight());
	}

//	@Override
//	public void setBounds(Point origin, Point corner) {
//
//		oval.setFrameFromDiagonal(origin, corner);
//		// XXX Notifikation eingentlich nur falls sich die Figur geändert hat.
//		notifyListener(new FigureEvent(this));
//	}
//
//	@Override
//	public void move(int dx, int dy) {
//		if (dx != 0 || dy != 0) {
//			oval.setFrameFromDiagonal(oval.getX() + dx, oval.getY() + dy, oval.getX() + oval.getWidth() + dx,
//					oval.getY() + oval.getHeight() + dy);
//
//			notifyListener(new FigureEvent(this));
//		}
//	}
//
//	@Override
//	public boolean contains(int x, int y) {
//		return oval.contains(x, y);
//	}
//
//	@Override
//	public Rectangle getBounds() {
//		Rectangle rec = new Rectangle((int) oval.getX(), (int) oval.getY(), (int) oval.getWidth(),
//				(int) oval.getHeight());
//		return rec.getBounds();
//		// return oval.getBounds();
//	}

	/**
	 * Returns a list of 8 handles for this Rectangle.
	 * 
	 * @return all handles that are attached to the targeted figure.
	 * @see jdraw.framework.Figure#getHandles()
	 */
	public List<FigureHandle> getHandles() {
		List<FigureHandle> handles = new LinkedList<>(); 
		handles.add(new NorthHandle(this));
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

	// XXX ich würde diese Methode nicht als public deklarieren, denn sie soll
	// nur intern aufgerufen werden
	// wenn sich der Zustand geändert hat => private
//	private void update(FigureEvent e) {
//		// XXX auch hier, iteriert werden sollte über eine Kopie der Listener.
//		FigureListener[] copy;
//		// ???Warum hier synchronized???
//		// YYY das ist Code den sie so vielleicht auch der Klasse
//		// java.util.Observable übernommen haben.
//		// Das synchronized ist da damit das Kopieren auch funktioniert wenn die
//		// Methode update aus
//		// mehreren Threads aufgerufen wird. synchronizes stellt sicher, dass
//		// mehrere THreads sich
//		// koordinieren. Für unseren Kurs können SIe das aber auch weglassen.
//		synchronized (this) {
//			copy = listeners.toArray(new FigureListener[listeners.size()]);
//		}
//		for (FigureListener l : copy) {
//			l.figureChanged(e);
//		}
//		// old version
//		// for (FigureListener l : listeners) {
//		// l.figureChanged(e);
//		// }
//	}

}
