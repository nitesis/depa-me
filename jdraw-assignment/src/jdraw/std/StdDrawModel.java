/*
 * Copyright (c) 2000-2016 Fachhochschule Nordwestschweiz (FHNW)
 * All Rights Reserved. 
 */

package jdraw.std;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import jdraw.framework.DrawCommandHandler;
import jdraw.framework.DrawModel;
import jdraw.framework.DrawModelEvent;
import jdraw.framework.DrawModelListener;
import jdraw.framework.Figure;
import jdraw.framework.FigureEvent;
import jdraw.framework.FigureListener;

/**
 * Provide a standard behavior for the drawing model. This class initially does
 * not implement the methods in a proper way. It is part of the course
 * assignments to do so.
 * 
 * @author TODO add your name here
 *
 */
public class StdDrawModel implements DrawModel, FigureListener {

	private List<DrawModelListener> listeners = new LinkedList<>();
	private List<Figure> figures = new LinkedList<>();

	// // Event handling for green slider
	// greenSlider.addChangeListener(new ChangeListener() {
	//
	// public void stateChanged(ChangeEvent e) {
	//
	// int green = greenSlider.getValue();
	//
	// setColor(new Color(color.getRed(), green, color.getBlue()));
	//
	// }
	// });
	//
	// listeners.add(new ColorListener() {
	//
	// @Override
	// public void colorChanged(Color c) {
	// greenSlider.setValue(c.getGreen());
	// }
	// });

	@Override
	public void addFigure(Figure f) {
		// TODO to be implemented
		if (f != null && !figures.contains(f)) {
		f.addFigureListener(this);

		figures.add(f);
		//hier erfährt view, dass figure hinzugefügt wurde
		update(new DrawModelEvent(this, f, DrawModelEvent.Type.FIGURE_ADDED));
		}
		//System.out.println("StdDrawModel.addFigure has to be implemented");
		
	}

	@Override
	public Iterable<Figure> getFigures() {
		// TODO to be implemented
		System.out.println("StdDrawModel.getFigures has to be implemented");
		return figures; // Only guarantees, that the application starts -- has
						// to be replaced !!!
	}

	@Override
	public void removeFigure(Figure f) {
		// TODO to be implemented
		// System.out.println("StdDrawModel.removeFigure has to be
		// implemented");
		
		if(figures.remove(f)){
		update(new DrawModelEvent(this, f, DrawModelEvent.Type.FIGURE_REMOVED));
		f.removeFigureListener(this);
		}
	}

	@Override
	public void addModelChangeListener(DrawModelListener listener) {
		// TODO to be implemented
		// System.out.println("StdDrawModel.addModelChangeListener has to be
		// implemented");
		listeners.add(listener);
	}

	@Override
	public void removeModelChangeListener(DrawModelListener listener) {
		// TODO to be implemented
		// System.out.println("StdDrawModel.removeModelChangeListener has to be
		// implemented");
		listeners.remove(listener);
	}

	/**
	 * The draw command handler. Initialized here with a dummy implementation.
	 */
	// TODO initialize with your implementation of the undo/redo-assignment.
	private DrawCommandHandler handler = new EmptyDrawCommandHandler();

	/**
	 * Retrieve the draw command handler in use.
	 * 
	 * @return the draw command handler.
	 */
	public DrawCommandHandler getDrawCommandHandler() {
		return handler;
	}

	@Override
	public void setFigureIndex(Figure f, int index) {
		// TODO to be implemented
		System.out.println("StdDrawModel.setFigureIndex has to be implemented");
	}

	@Override
	public void removeAllFigures() {
		// TODO to be implemented
		
		//Iterator aus Figuren
		Iterator<Figure> it = figures.iterator();
		//So lange es ein nächstes Element in der Figurenliste gibt...
		while(it.hasNext()){
			//...weise dieses Element f zu...
			Figure f = it.next();
			//...entferne das Element aus der Liste von Figuren...
			it.remove();
			//...löse ein neus Event aus (nämlich dass die Zeichnung gelöscht wurde)...
			update(new DrawModelEvent(this, f, DrawModelEvent.Type.DRAWING_CLEARED));
			//...und entferne f aus der Liste der FigreListener
			f.removeFigureListener(this);
		}
	}

	public void update(DrawModelEvent e) {
		for (DrawModelListener l : listeners) {
			l.modelChanged(e);
		}
	}

	@Override
	public void figureChanged(FigureEvent e) {
		// TODO Auto-generated method stub
		//???
		update(new DrawModelEvent(this, e.getFigure(), DrawModelEvent.Type.FIGURE_CHANGED));
	}

}
