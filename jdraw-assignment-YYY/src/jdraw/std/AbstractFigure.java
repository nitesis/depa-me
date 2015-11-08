package jdraw.std;

import java.util.LinkedList;
import java.util.List;
import java.util.Observable;

import jdraw.framework.Figure;
import jdraw.framework.FigureEvent;
import jdraw.framework.FigureListener;

public abstract class AbstractFigure extends Observable implements Figure {

	private List<FigureListener> listeners = new LinkedList<>();
	
	public void addFigureListener(FigureListener listener) {
		listeners.add(listener);		
	}

	public void removeFigureListener(FigureListener listener) {
		listeners.remove(listener);		
	}
	
	public Figure clone() { return null; }
	
	//ist jetzt nicht mehr private, sondern public
	// besser notifyListener
	public void notifyListener(FigureEvent e) {
		
		FigureListener[] copy;
		// ???Warum hier synchronized???
		synchronized(this) { 
			copy = listeners.toArray(new FigureListener[listeners.size()]);
			} 
		for (FigureListener l : copy) { 
			//ist analog zu update() im ObserverPattern
			l.figureChanged(e); 
		}

	}
}
