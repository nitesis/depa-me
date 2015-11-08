package jdraw.handles;

import java.awt.Cursor;
import java.awt.Point;
import java.awt.Rectangle;

import jdraw.framework.Figure;

public class EastHandle extends AbstractHandle {

	public EastHandle(Figure f) {
		super(f);
	}

	@Override
	public Cursor getCursor() {
		return Cursor.getPredefinedCursor(Cursor.E_RESIZE_CURSOR);
	}

	@Override
	protected Point getCurrentPoint() {
		Rectangle r = getOwner().getBounds();
		return new Point(r.x + r.width, r.y + (r.height / 2));
	}

	@Override
	protected Point findDragInteractionOriginPoint(int x, int y) {
		Rectangle r = getOwner().getBounds();
		return new Point(x, r.y + r.height);
	}
	
	@Override
	protected Point getDragInteractionPoint() {
		Rectangle r = getOwner().getBounds();
		return new Point(r.x,r.y) ;
	}

	@Override
	protected boolean isShowHandle() {
		return !isHeighLimit();
	}



}
