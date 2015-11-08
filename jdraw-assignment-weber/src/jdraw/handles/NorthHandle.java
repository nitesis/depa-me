package jdraw.handles;

import java.awt.Cursor;
import java.awt.Point;
import java.awt.Rectangle;

import jdraw.framework.Figure;

public class NorthHandle extends AbstractHandle {

	public NorthHandle(Figure f) {
		super(f);
	}

	@Override
	public Cursor getCursor() {
		return Cursor.getPredefinedCursor(Cursor.N_RESIZE_CURSOR);
	}

	@Override
	protected Point getCurrentPoint() {
		Rectangle r = getOwner().getBounds();
		return new Point(r.x + (r.width / 2), r.y);
	}
	
	@Override
	protected Point findDragInteractionOriginPoint(int x, int y) {
		Rectangle r = getOwner().getBounds();
		return new Point(r.x + r.width, y);
	}

	@Override
	protected Point getDragInteractionPoint() {
		Rectangle r = getOwner().getBounds();
		return new Point(r.x, r.y + r.height);
	}

	@Override
	protected boolean isShowHandle() {
		return !isWidthLimit();
	}
}
