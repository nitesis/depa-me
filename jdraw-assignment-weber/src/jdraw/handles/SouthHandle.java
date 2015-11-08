package jdraw.handles;

import java.awt.Cursor;
import java.awt.Point;
import java.awt.Rectangle;

import jdraw.framework.Figure;

public class SouthHandle extends AbstractHandle {

	public SouthHandle(Figure f) {
		super(f);
	}

	@Override
	public Cursor getCursor() {
		return Cursor.getPredefinedCursor(Cursor.S_RESIZE_CURSOR);
	}
	
	@Override
	protected Point getCurrentPoint() {
		Rectangle r = getOwner().getBounds();
		return new Point(r.x + (r.width / 2), r.y + r.height);
	}

	@Override
	protected Point findDragInteractionOriginPoint(int x, int y) {
		Rectangle r = getOwner().getBounds();
		return new Point(r.x + r.width, y);
	}

	@Override
	protected Point getDragInteractionPoint() {
		Rectangle r = getOwner().getBounds();
		return new Point(r.x, r.y);
	}

	@Override
	protected boolean isShowHandle() {
		return !isWidthLimit();
	}
}
