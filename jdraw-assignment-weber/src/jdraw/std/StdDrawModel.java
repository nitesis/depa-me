/*
 * Copyright (c) 2000-2016 Fachhochschule Nordwestschweiz (FHNW)
 * All Rights Reserved. 
 */

package jdraw.std;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.annotation.Nonnull;

import jdraw.framework.DrawCommandHandler;
import jdraw.framework.DrawModel;
import jdraw.framework.DrawModelEvent;
import jdraw.framework.DrawModelEvent.Type;
import jdraw.framework.DrawModelListener;
import jdraw.framework.Figure;
import jdraw.framework.FigureEvent;
import jdraw.framework.FigureListener;

import com.google.common.collect.ImmutableList;

/**
 * Provide a standard behavior for the drawing model. This class initially does
 * not implement the methods in a proper way. It is part of the course
 * assignments to do so.
 * 
 * @author Nicolas Weber 
 *
 */
public class StdDrawModel implements DrawModel {


	private List<Figure> figures = new LinkedList<>();
	private Map<Figure, FigureListener> listenerMap = new HashMap<>();
	private List<DrawModelListener> listeners = new LinkedList<>();

	@Override
	public void addFigure(@Nonnull Figure f) {
		if (!figures.contains(f)) {
			listenerMap.put(f, new FigureListener() {
				@Override
				public void figureChanged(FigureEvent e) {
					updateModelListener(e.getFigure(), Type.FIGURE_CHANGED);

				}
			});
			f.addFigureListener(listenerMap.get(f));
			figures.add(f);
			updateModelListener(f, Type.FIGURE_ADDED);
		}
	}

	@Override
	public Iterable<Figure> getFigures() {
		return figures;
	}

	@Override
	public void removeFigure(@Nonnull Figure f) {
		if (figures.contains(f)) {
			figures.remove(f);
			f.removeFigureListener(listenerMap.get(f));
			listenerMap.remove(f);
			updateModelListener(f, Type.FIGURE_REMOVED);
		}
	}

	@Override
	public void addModelChangeListener(@Nonnull DrawModelListener listener) {
		listeners.add(listener);
	}

	@Override
	public void removeModelChangeListener(@Nonnull DrawModelListener listener) {
			listeners.remove(listener);
	}

	/** The draw command handler. Initialized here with a dummy implementation. */
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
		if ((figures.size() <= index)) {
			throw new IndexOutOfBoundsException();
		}
		if (figures.get(index) == f) {
			return;
		}
		if (!figures.contains(f)) {
			throw new IllegalArgumentException();
		}
		updateIndex(f, index);

		updateModelListener(f, Type.DRAWING_CHANGED);
	}

	private void updateIndex(Figure f, int index) {
		if(figures.contains(f)){
			figures.remove(f);
			figures.add(index, f);
		}
	}

	@Override
	public void removeAllFigures() {
		for (Figure figure : figures) {
			figure.removeFigureListener(listenerMap.get(figure));
			listenerMap.remove(figure);
		}
		this.figures = new LinkedList<Figure>();
		updateModelListener(null, Type.DRAWING_CLEARED);
	}

	private void updateModelListener(Figure figure, Type type) {
		for (DrawModelListener listener : ImmutableList.copyOf(listeners)) {
			listener.modelChanged(new DrawModelEvent(this, figure, type));
		}
	}

}
