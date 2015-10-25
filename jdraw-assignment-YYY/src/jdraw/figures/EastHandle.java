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

public class EastHandle implements FigureHandle{

	// XXX genereller Kommentar: Ihre Handle-Klassen ähneln einander, daher könnte man hier gut eine abstrakte Basiskasse einziehen.
	private Figure owner; 
	private Point corner;
	
	public EastHandle (Figure figure) {
		owner = figure;
	}
	
	@Override
	public Figure getOwner() {
		return owner;
	}

	@Override
	// Standardmässig wird Position der oberen linken Ecke zurückgegeben
	// Jetzt soll die Position unten mitte zurückgegeben werden
	// XXX was heisst "standardmässig"? Da es keine abstrakte Basisklasse gibt, gibt es auch keinen "Standard".
	public Point getLocation() {
		Point p;
		p = owner.getBounds().getLocation();
		p.x = p.x + owner.getBounds().width;
		p.y = p.y + owner.getBounds().height/2;
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
	public Cursor getCursor() {
		return Cursor.getPredefinedCursor(Cursor.E_RESIZE_CURSOR);
	}

	@Override
	public boolean contains(int x, int y) {
		Rectangle rect = new Rectangle(getLocation().x - 3, getLocation().y - 3, 6, 6);
		return rect.contains(x, y);
	}

	@Override
	public void startInteraction(int x, int y, MouseEvent e, DrawView v) {
		Rectangle r = owner.getBounds();
		
		corner = new Point(r.x, r.y);
	}

	@Override
	public void dragInteraction(int x, int y, MouseEvent e, DrawView v) {
		Rectangle r = owner.getBounds();
		
		owner.setBounds(corner, new Point(x, r.y + r.height));
	}

	@Override
	public void stopInteraction(int x, int y, MouseEvent e, DrawView v) {
		corner = null;
	}

}
