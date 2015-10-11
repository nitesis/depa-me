package jdraw.std;

import java.util.LinkedList;
import java.util.List;

import jdraw.framework.Figure;
import jdraw.framework.FigureEvent;
import jdraw.framework.FigureListener;

public abstract class AbstractFigure implements Figure {

	private List<FigureListener> listeners = new LinkedList<>();
	
	public void addFigureListener(FigureListener listener) {
		listeners.add(listener);		
	}

	public void removeFigureListener(FigureListener listener) {
		listeners.remove(listener);		
	}
	
	public Figure clone() { return null; }
	
	//ist jetzt nicht mehr private, sondern public
	public void update(FigureEvent e) {
		
		FigureListener[] copy;
		// ???Warum hier synchronized???
		synchronized(this) { 
			copy = listeners.toArray(new FigureListener[listeners.size()]);
			} 
		for (FigureListener l : copy) { 
			l.figureChanged(e); 
		}

	}
}
