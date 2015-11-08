package jdraw.handles;

import java.awt.Cursor;
import java.awt.Point;
import java.awt.Rectangle;

import jdraw.framework.Figure;

public class NorthEastHandle extends AbstractHandle {

	public NorthEastHandle(Figure f) {
		super(f);
	}

	@Override
	public Cursor getCursor() {
		return Cursor.getPredefinedCursor(Cursor.NE_RESIZE_CURSOR);
	}

	@Override
	protected Point getCurrentPoint() {
		Rectangle r = getOwner().getBounds();
		return new Point(r.x + r.width, r.y);
	}

	@Override
	protected Point getDragInteractionPoint() {
		Rectangle r = getOwner().getBounds();
		return new Point(r.x, r.y + r.height);
	}

	@Override
	protected Point findDragInteractionOriginPoint(int x, int y) {
		return new Point(x, y);
	}

}
