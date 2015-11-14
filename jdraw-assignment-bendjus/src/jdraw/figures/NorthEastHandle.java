package jdraw.figures;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;

import jdraw.framework.DrawView;
import jdraw.framework.Figure;
import jdraw.framework.FigureHandle;

public class NorthEastHandle implements FigureHandle{

	private Figure owner; 
	private Point corner;
	
	public NorthEastHandle (Figure figure) {
		owner = figure;
	}
	
	@Override
	public Figure getOwner() {
		return owner;
	}

	@Override
	public Point getLocation() {
		Point p;
		p = owner.getBounds().getLocation();
		p.x = p.x + owner.getBounds().width;
		return p;
	}

	@Override
	public void draw(Graphics g) {
		Point loc = getLocation();
		g.setColor(Color.WHITE); 
		g.fillRect(loc.x - 3, loc.y - 3, 6, 6); 
		g.setColor(Color.BLACK); 
		g.drawRect(loc.x - 3, loc.y - 3, 6, 6);
	}

	@Override
	// definiert das Aussehen des Cursors wenn die Figur mit diesem Handle verändert wird
	public Cursor getCursor() {
		return Cursor.getPredefinedCursor(Cursor.NE_RESIZE_CURSOR);
	}

	@Override
	// gibt an, ob sich die Position (x,y) innerhalb des Handles befindet
	public boolean contains(int x, int y) {
		Rectangle rect = new Rectangle(getLocation().x - 3, getLocation().y - 3, 6, 6);
		return rect.contains(x, y);
	}

	// Handler merkt sich bei Aufruf von startInteraction die Position der gegenüberliegenden
	// (also der unteren linken) Ecke der Figur
	@Override
	public void startInteraction(int x, int y, MouseEvent e, DrawView v) {
		Rectangle r = owner.getBounds();
		corner = new Point(r.x, r.y + r.height);
	}

	// Ändert die Position des Handles
	@Override
	public void dragInteraction(int x, int y, MouseEvent e, DrawView v) {
		Rectangle r = owner.getBounds();
		// Der Punkt p1 nimmt vom Punkt unten links die x-Koordinate, von der Maus die y-Koordinate 
		Point p1 = new Point(corner.x, y);
		Point p2 = new Point(x, corner.y);
		
		owner.setBounds(p1, p2);
	}

	@Override
	public void stopInteraction(int x, int y, MouseEvent e, DrawView v) {
		corner = null;
	}

}
