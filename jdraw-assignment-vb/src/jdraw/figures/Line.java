package jdraw.figures;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import com.sun.javafx.geom.Line2D;
import java.util.LinkedList;
import java.util.List;

import jdraw.framework.Figure;
import jdraw.framework.FigureEvent;
import jdraw.framework.FigureHandle;
import jdraw.framework.FigureListener;
import jdraw.std.AbstractFigure;

public class Line extends AbstractFigure implements Figure {

	/**
	 * Use the java.awt.Line2D in order to save/reuse code.
	 */
	//private java.awt.geom.Line2D line;
	private Line2D line;
	private List<FigureListener> listeners = new LinkedList<>();
	
	public Line (int x1, int y1, int x2, int y2) {
		line = new Line2D (x1, y1, x2, y2);	
	}
	
	public Line2D getLine() {
		return line;
	}
	/**
	 * Draw the line to the given graphics context.
	 * @param g the graphics context to use for drawing.
	 */
	@Override
	public void draw(Graphics g) {
		g.setColor(Color.PINK);
		//Ist das hier eine gute Idee mit dem Casten?
		// YYY ja, das ist kein Problem. Es wird zwar von den Methoden getX1(), getY1() etc ein double zurückgegeen, 
		//     aber es ist die double-Repräsentation einer Ganzzahl. Konvertieren in einen int mit einem Cast geht
		//     ohne Probleme.
		g.drawLine((int)line.x1, (int)line.y1, (int)line.x2, (int)line.y2);
		
		// YYY Variante:
//		Graphics2D g2 = (Graphics2D)g;
//		g2.draw(line);;
	}

	@Override
	public void move(int dx, int dy) {
		if(dx != 0 || dy != 0) {
			line.setLine(line.x1 + dx, line.y1 + dy, line.x2 + dx, line.y2 + dy);
			propagateFigureEvent();
//			notifyListener(new FigureEvent(this));
			}	
		
	}

	@Override
	public boolean contains(int x, int y) {
		
		return line.ptLineDist(x, y) < 5;
	}

	@Override
	// Erstellt eine Linie anhand zweier gegebener Punkte
	public void setBounds(Point origin, Point corner) {
		line.setLine(origin.x, origin.y, corner.x, corner.y);
		propagateFigureEvent();
//		notifyListener(new FigureEvent(this));
	}

	@Override
	// Erstellt ein Rechteck, dass die Linie umschliesst
	// Setzt die Bounds meiner Figure nachdem die Maus gezogen wurde 
	public Rectangle getBounds() {
		//return line.getBounds();
		Point p1 = new Point((int)line.x1,(int)line.y1);
		Point p2 = new Point((int)line.x2,(int)line.y2);
		Rectangle rec = new Rectangle();
		rec.setFrameFromDiagonal(p1, p2);
		return rec.getBounds();
	}

	@Override
	public List<FigureHandle> getHandles() {
		List<FigureHandle> handles = new LinkedList<>(); 
		handles.add((FigureHandle) new LineHandle1(this));
		handles.add((FigureHandle) new LineHandle2(this));
		return handles;
	}

//	@Override
//	public void addFigureListener(FigureListener listener) {
//		listeners.add(listener);
//		
//	}
//
//	@Override
//	public void removeFigureListener(FigureListener listener) {
//		listeners.remove(listener);
//		
//	}

	@Override
	public Figure clone() {
		// TODO Auto-generated method stub
		return null;
	}
	
//	private void update(FigureEvent e) {
//		
//		FigureListener[] copy;
//		// ???Warum hier synchronized???
//		synchronized(this) { 
//			copy = listeners.toArray(new FigureListener[listeners.size()]);
//			} 
//		for (FigureListener l : copy) { 
//			l.figureChanged(e); 
//		}
//
//	}

}
