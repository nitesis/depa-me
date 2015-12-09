package jdraw.figures;

import java.awt.Cursor;
import java.awt.Point;
import java.awt.event.MouseEvent;

import jdraw.framework.DrawView;
import jdraw.framework.Figure;
import jdraw.framework.FigureHandle;

public abstract class AbstractFigureHandle implements FigureHandle {

	Figure owner;
	
	public AbstractFigureHandle (Figure figure) {
		owner = figure;
	}
	public Figure getOwner() {
		return owner;
	}

	public Point getLocation() {
//		Was muss ich hier genau woher holen?
		return null;
	}

	public Cursor getCursor() {
//		Was muss ich hier genau woher holen?
		return null;
	}

//	Diese Klassen habe ich abstract gemacht, weil sie für jede Figur anders sind
	public abstract void startInteraction(int x, int y, MouseEvent e, DrawView v);

	public abstract void dragInteraction(int x, int y, MouseEvent e, DrawView v);

	public abstract void stopInteraction(int x, int y, MouseEvent e, DrawView v);
	
	public Figure clone() {
		return owner.clone();
	}

}
