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

	@Override
	public void addFigure(Figure f) {
	
		if (f != null && !figures.contains(f)) {
		f.addFigureListener(this);

		figures.add(f);
		//hier erfährt view, dass figure hinzugefügt wurde
		update(new DrawModelEvent(this, f, DrawModelEvent.Type.FIGURE_ADDED));
		}

	}

	@Override
	public Iterable<Figure> getFigures() {

		//System.out.println("StdDrawModel.getFigures has to be implemented");
		return figures; // Only guarantees, that the application starts -- has
						// to be replaced !!!
	}

	@Override
	public void removeFigure(Figure f) {

		if(figures.remove(f)){
		update(new DrawModelEvent(this, f, DrawModelEvent.Type.FIGURE_REMOVED));
		f.removeFigureListener(this);
		}
	}

	@Override
	public void addModelChangeListener(DrawModelListener listener) {

		listeners.add(listener);
	}

	@Override
	public void removeModelChangeListener(DrawModelListener listener) {

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
	//Methode, die schon vorhandene Elemente in der Liste verschiebt
	public void setFigureIndex(Figure f, int index) {
		//Check, ob der Index existierte und das Element auch schon in der Liste vorhanden ist
		if(index > figures.size() || !figures.contains(f)) throw new IllegalArgumentException();
		// XXX der Test "index > figures.size()" ist zu schwach, denn auch wenn index == figures.size()
		//     muss eine Exception geworfen werden. Der Index kann nur zwischen 0 und size()-1 sein.
		figures.remove(f);
		figures.add(index, f);
		update(new DrawModelEvent(this, f, DrawModelEvent.Type.DRAWING_CHANGED));
		// XXX falls jedoch die Figur bereits an der Position index ist, dann kann man sich die Notifikation sparen
		//     bzw sollte man, um nicht in ein potentielles Zyklenproblem zu geraten.
	}

	@Override
	public void removeAllFigures() {
		
		//Iterator mit Figures
		Iterator<Figure> it = figures.iterator();
		//So lange es ein nächstes Element in der Figurenliste gibt...
		while(it.hasNext()){
			//...weise dieses Element f zu...
			Figure f = it.next();
			//...entferne das Element aus der Liste von Figures...
			it.remove();
			//...löse ein neues Event aus (nämlich dass die Zeichnung gelöscht wurde)...
			update(new DrawModelEvent(this, f, DrawModelEvent.Type.DRAWING_CLEARED));
			// XXX hier erwartet die View (bzw. die Listener) nur eine Meldung "Drawing Cleared", dann
			//     einfach mit null als Figurenparameter im DrawModelEvent.
			//     Sie können daher die Liste auch einfach mit figures.clear() löschen (aber es muss trotzdem
			//     über die Liste iteriert werden damit in allen Figuren der Listener entfernt werden kann.
			
			//...und entferne f aus der Liste der FigureListener
			f.removeFigureListener(this);
		}
	}

	// XXX ich würde diese Methode nicht als public deklarieren, denn sie soll nur intern aufgerufen werden 
	//     wenn sich der Zustand geändert hat => private
	public void update(DrawModelEvent e) {
		// XXX hier sollte sicherheitshalber über eine Kopie der Listener-Liste iteriert werden (wie wir das diese Woche diskutiert haben).
		//     Variante ist die Verwendung einer Collection-Klasse die gleichzeitiges Iterieren und Löschen unterstützt.
		for (DrawModelListener l : listeners) {
			l.modelChanged(e);
		}
	}

	@Override
	public void figureChanged(FigureEvent e) {
	
		//???
		// XXX genau. Damit wird eine Änderung von einer Figur an die im Modell registrierten Listener weitergegeben.
		update(new DrawModelEvent(this, e.getFigure(), DrawModelEvent.Type.FIGURE_CHANGED));
	}

}
