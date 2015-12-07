package jdraw.figures;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.util.List;

import com.sun.javafx.geom.Line2D;

import jdraw.framework.DrawView;
import jdraw.framework.Figure;
import jdraw.framework.FigureHandle;
import jdraw.framework.FigureListener;

public class LineHandle2 extends AbstractFigureHandle{

	private Line owner;
	private Line2D line;
	private Point corner;
	
	public LineHandle2 (Line figure) {
		super(figure);
		owner = figure;
		line = owner.getLine();
	}
	
	@Override
	public Figure getOwner() {
		return owner;
	}

	@Override
	// Standardmässig wird Position der oberen linken Ecke zurückgegeben
	// Jetzt soll die Position unten mitte zurückgegeben werden
	public Point getLocation() {
		Point p;
		p = new Point((int) line.x2, (int) line.y2);
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
		return Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR);
	}

	@Override
	public boolean contains(int x, int y) {
		Rectangle rect = new Rectangle(getLocation().x - 3, getLocation().y - 3, 6, 6);
		return rect.contains(x, y);
	}

	@Override
	public void startInteraction(int x, int y, MouseEvent e, DrawView v) {
		corner = new Point((int) line.x1, (int) line.y1);
	}

	@Override
	public void dragInteraction(int x, int y, MouseEvent e, DrawView v) {

		owner.setBounds(corner, new Point(x, y));
	}

	@Override
	public void stopInteraction(int x, int y, MouseEvent e, DrawView v) {
		corner = null;
	}

	@Override
	public void move(int dx, int dy) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setBounds(Point origin, Point corner) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Rectangle getBounds() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<FigureHandle> getHandles() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addFigureListener(FigureListener listener) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeFigureListener(FigureListener listener) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Figure clone() {
		// TODO Auto-generated method stub
		return null;
	}

}
