package jdraw.grid;

import java.awt.Point;

import jdraw.framework.DrawModelEvent;
import jdraw.framework.DrawModelListener;
import jdraw.framework.DrawView;
import jdraw.framework.Figure;
import jdraw.framework.FigureHandle;
import jdraw.framework.PointConstrainer;

public class SnapGridHandler implements PointConstrainer{

	private static final int SNAP = 15;
	private DrawView view;
	private DrawModelListener listener; 
	private Figure figure;
	
//	public SnapGridHandler (DrawView view) {
//		this.view = view;
//	}
	
	public SnapGridHandler(DrawView view) {
		this.view = view;
		listener = new DrawModelListener() {

			public void modelChanged(DrawModelEvent e) {
				if (e.getType() == DrawModelEvent.Type.FIGURE_ADDED) {
					figure = e.getFigure();
				}
			}
		};
		view.getModel().addModelChangeListener(listener);
	}
	@Override
	public Point constrainPoint(Point p) {
		for (Figure f : view.getModel().getFigures()) {
			if (!view.getSelection().contains(f) && f != figure)
				for (FigureHandle h : f.getHandles()) {
					Point pos = h.getLocation();
					if (nearBy(p, pos)) {
						return pos;
					}
				}
		}
		return p;
	}

	private boolean nearBy(Point p, Point pos) {
		return p.distance(pos) < SNAP;
	}

	@Override
	public int getStepX(boolean right) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getStepY(boolean down) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void activate() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deactivate() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseDown() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseUp() {
		// TODO Auto-generated method stub
		
	}

}
