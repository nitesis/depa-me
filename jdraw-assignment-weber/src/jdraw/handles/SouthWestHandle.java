package jdraw.handles;

import java.awt.Cursor;
import java.awt.Point;
import java.awt.Rectangle;

import jdraw.framework.Figure;

public class SouthWestHandle extends AbstractHandle {

	public SouthWestHandle(Figure f) {
		super(f);
	}

	@Override
	public Cursor getCursor() {
		return Cursor.getPredefinedCursor(Cursor.SW_RESIZE_CURSOR);
	}

	@Override
	protected Point getCurrentPoint() {
		Rectangle r = getOwner().getBounds();
		return new Point(r.x, r.y + r.height);
	}

	@Override
	protected Point getDragInteractionPoint() {
		Rectangle r = getOwner().getBounds();
		return new Point(r.x + r.width, r.y);
	}

	@Override
	protected Point findDragInteractionOriginPoint(int x, int y) {
		return new Point(x, y);
	}

}
