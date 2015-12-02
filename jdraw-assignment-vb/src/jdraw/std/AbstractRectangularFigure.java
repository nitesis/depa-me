package jdraw.std;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.List;

import jdraw.framework.FigureHandle;

public abstract class AbstractRectangularFigure extends AbstractFigure {

	private java.awt.Rectangle rectangle = null;

	protected AbstractRectangularFigure(Point origin) {
//		Erzeugt Rechteck der Breite und Höhe = null
		rectangle = new Rectangle(new Point(origin));
		

	}
//	NEU!
//	public AbstractRectangularFigure(int x, int y) {
//		rectangle = new Rectangle(new Point(x, y));
//	}

	@Override
	public abstract void draw(Graphics g);

	@Override
	public void move(int dx, int dy) {
		if (dx != 0 && dy != 0) {
			// Translates this Rectangle the indicated distance, to the right
			// along the X coordinate axis, and downward along the Y coordinate
			// axis.
			rectangle.translate(dx, dy);
			propagateFigureEvent();
		}
	}

	@Override
	public boolean contains(int x, int y) {
		return rectangle.contains(x, y);
	}

	@Override
	public void setBounds(Point origin, Point corner) {
		Rectangle original = new Rectangle(rectangle);
		rectangle.setFrameFromDiagonal(origin, corner);
		// Notification only if there is a change.
		if (!original.equals(rectangle)) {
			propagateFigureEvent();
		}
	}

	@Override
	public Rectangle getBounds() {
		return new Rectangle(rectangle);
	}

	@Override
	public abstract List<FigureHandle> getHandles();

}
