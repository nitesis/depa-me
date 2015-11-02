/*
 * Copyright (c) 2000-2014 Fachhochschule Nordwestschweiz (FHNW)
 * All Rights Reserved. 
 */

package patterns.clone.figure;

import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Base class for figure implementations. Implements listener management.
 * 
 */
public abstract class Figure {
	private List<FigureListener> listeners = new LinkedList<FigureListener>();

	public void addFigureListener(FigureListener listener) {
		if (!listeners.contains(listener)) {
			listeners.add(listener);
		}
	}

	public void removeFigureListener(FigureListener listener) {
		listeners.remove(listener);
	}

	protected void notifyChange(FigureEvent fe) {
		for (FigureListener fl : new ArrayList<>(listeners)) {
			fl.figureChanged(fe);
		}
	}
	
	public abstract Rectangle getBounds();

}
