package jdraw.figures;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.LinkedList;
import java.util.List;

import javax.annotation.Nonnull;

import jdraw.framework.Figure;
import jdraw.framework.FigureEvent;
import jdraw.framework.FigureHandle;
import jdraw.framework.FigureListener;
import jdraw.handles.EastHandle;
import jdraw.handles.NorthEastHandle;
import jdraw.handles.NorthHandle;
import jdraw.handles.NorthWestHandle;
import jdraw.handles.SouthEastHandle;
import jdraw.handles.SouthHandle;
import jdraw.handles.SouthWestHandle;
import jdraw.handles.WestHandle;

import com.google.common.collect.ImmutableList;

public abstract class AbstractFigure implements Figure {

	private Rectangle rectangle;

	// private List<FigureListener> listeners = new LinkedList<>();
	private List<FigureListener> listeners = new LinkedList<>();
	private final List<FigureHandle> handles;
	private boolean isHandelsInGroupedFigure = false;

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

	protected AbstractFigure(int x, int y, int w, int h) {
		this.rectangle = new Rectangle(x, y, w, h);
		this.handles = createHandles();
	}

	protected AbstractFigure(AbstractFigure figure) {
		this(figure.getBounds().x, figure.getBounds().y, figure.getBounds().width, figure.getBounds().height);
	}

	protected AbstractFigure(Rectangle r) {
		this(r.x, r.y, r.width, r.height);
	}

	protected ImmutableList<FigureHandle> createHandles() {
		return ImmutableList.of(new NorthHandle(this), new EastHandle(this), new SouthHandle(this),
				new WestHandle(this), new NorthWestHandle(this), new NorthEastHandle(this), new SouthWestHandle(this),
				new SouthEastHandle(this));
	}

	/**
	 * Draw the rectangle to the given graphics context.
	 * 
	 * @param g
	 *            the graphics context to use for drawing.
	 */
	@Override
	public void draw(@Nonnull Graphics g) {
		g.setColor(Color.WHITE);
		fillFigure(g);
		g.setColor(Color.BLACK);
		drawFigure(g);
		g.drawString(getString(), getBounds().x + 5, getBounds().y + 20);
	}

	protected String getString() {
		Rectangle r = getBounds();
		return "X:" + r.x + ",Y:" + r.getY() + ",W" + r.getWidth() + ", H:" + r.getHeight();
	}

	protected void fillFigure(Graphics g) {
		// NOP
	}

	protected abstract void drawFigure(Graphics g);

	@Override
	public void setBounds(Point origin, Point corner) {
		Rectangle original = new Rectangle(getShape());
		getShape().setFrameFromDiagonal(origin, corner);
		if (!original.equals(getShape())) {
			updateFigure();
		}
	}

	@Override
	public void move(int dx, int dy) {
		if (dx == 0 && dy == 0) {
			return;
		}
		getShape().setLocation(getShape().x + dx, getShape().y + dy);
		updateFigure();
	}

	protected void updateFigure() {
		for (FigureListener listener : ImmutableList.copyOf(listeners)) {
			listener.figureChanged(new FigureEvent(this));
		}
	}

	@Override
	public boolean contains(int x, int y) {
		return getShape().contains(x, y);
	}

	@Override
	public Rectangle getBounds() {
		return getShape().getBounds();
	}

	/**
	 * Returns a list of 8 handles for this Rectangle.
	 * 
	 * @return all handles that are attached to the targeted figure.
	 * @see jdraw.framework.Figure#getHandles()
	 */
	public List<FigureHandle> getHandles() {
		return this.handles;
	}

	@Override
	public void addFigureListener(@Nonnull FigureListener listener) {
		this.listeners.add(listener);
	}

	@Override
	public void removeFigureListener(@Nonnull FigureListener listener) {
		listeners.remove(listener);
	}

	@Override
	public abstract Figure clone();


	protected Rectangle getShape() {
		return rectangle;
	}

	public boolean isHandelsInGroupedFigure() {
		return isHandelsInGroupedFigure;
	}

	public void setIsHandelsInGroupedFigure(boolean isHandelsHidden) {
		this.isHandelsInGroupedFigure = isHandelsHidden;
	}
}
