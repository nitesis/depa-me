package jdraw.handles;

import java.awt.Cursor;
import java.awt.Point;
import java.awt.Rectangle;

import jdraw.framework.Figure;

public class NorthWestHandle extends AbstractHandle {

	public NorthWestHandle(Figure f) {
		super(f);
	}
	
	@Override
	protected Point getCurrentPoint() {
		return new Point(getOwner().getBounds().x, getOwner().getBounds().y);
	}

	@Override
	public Cursor getCursor() {
		return Cursor.getPredefinedCursor(Cursor.NW_RESIZE_CURSOR);
	}

	@Override
	protected Point getDragInteractionPoint() {
		Rectangle r = getOwner().getBounds();
		return new Point(r.x + r.width, r.y + r.height);
	}

	@Override
	protected Point findDragInteractionOriginPoint(int x, int y) {
		return new Point(x, y);
	}
}
