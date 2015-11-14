package jdraw.std;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.List;

import jdraw.framework.FigureHandle;

public abstract class AbstractRectangularFigure extends AbstractFigure {

	private Rectangle rectangle = null;

	protected AbstractRectangularFigure(Point origin) {
		rectangle = new Rectangle(origin);
	}

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
	public List<FigureHandle> getHandles() {
		// TODO Auto-generated method stub
		return null;
	}

}
