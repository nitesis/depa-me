package jdraw.handles;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;

import jdraw.figures.AbstractFigure;
import jdraw.framework.DrawView;
import jdraw.framework.Figure;
import jdraw.framework.FigureGroup;
import jdraw.framework.FigureHandle;

public abstract class AbstractHandle implements FigureHandle {

	private final Figure owner;
	final static int LIMIT = 100;
	private final int handleSize = 6;
	private Point corner;

	public AbstractHandle(Figure f) {
		this.owner = f;
	}

	protected boolean isWidthLimit() {
		return getOwner().getBounds().getWidth() < LIMIT;
	}

	protected boolean isHeighLimit() {
		return getOwner().getBounds().getHeight() < LIMIT;
	}

	@Override
	public Figure getOwner() {
		return this.owner;
	}

	@Override
	public Point getLocation() {
		return new Point(getCurrentPoint());
	}

	@Override
	public void draw(Graphics g) {
		if (isShowHandle() && !((AbstractFigure) owner).isHandelsInGroupedFigure()) {
			Point p = getCurrentPoint();
			g.setColor(Color.WHITE);
			g.drawRect(p.x - (handleSize / 2), p.y - (handleSize / 2), handleSize, handleSize);
			g.setColor(Color.BLACK);
			g.drawRect(p.x - (handleSize / 2), p.y - (handleSize / 2), handleSize, handleSize);
		}
	}

	protected abstract Point getCurrentPoint();

	@Override
	public boolean contains(int x, int y) {
		Point p = getCurrentPoint();
		return isShowHandle() && !((AbstractFigure) owner).isHandelsInGroupedFigure()
				&& new Rectangle(p.x - (handleSize / 2), p.y - (handleSize / 2), handleSize, handleSize).contains(x, y);

	}

	public void startInteraction(int x, int y, MouseEvent e, DrawView v) {
		corner = new Point(getDragInteractionPoint());
	}

	protected abstract Point getDragInteractionPoint();

	@Override
	public final void dragInteraction(int x, int y, MouseEvent e, DrawView v) {
		if (FigureGroup.class.isAssignableFrom(getOwner().getClass())) {
			Point p = getCurrentPoint();
			Point delta = new Point(x - p.x, y - p.y);
			owner.setBounds(delta, corner);
		} else {
			owner.setBounds(findDragInteractionOriginPoint(x, y), corner);
		}
	}

	protected abstract Point findDragInteractionOriginPoint(int x, int y);

	public void stopInteraction(int x, int y, MouseEvent e, DrawView v) {
		corner = null;
	}

	protected boolean isShowHandle() {
		return true;
	}

}
