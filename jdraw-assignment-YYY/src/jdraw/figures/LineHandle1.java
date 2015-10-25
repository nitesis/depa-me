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

public class LineHandle1 implements FigureHandle{

	private Figure owner; 
	private Point corner;
	
	// XXX ein Tipp (oder Trick) ist vielleicht der, dass Sie hier den Parameter als vom Typ Figure deklarieren könenn (und auch 
	//     die Variable owner), denn dieser Handle kann ja NUR mit Linien verwendet werden. Dann können Sie auch auf das
	//     Feld owner.line bzw. owner.line.x1/y1/x2/y2 zugreifen, oder sie können auf zusätzliche Methoden zugreifen die sie
	//     in der Klasse Line definieren, z.B. eine Methode getStartPoint() und eine Methode getEndPoint().
	public LineHandle1 (Figure figure) {
		owner = figure;
	}
	
	@Override
	public Figure getOwner() {
		return owner;
	}

	@Override
	// Standardmässig wird Position der oberen linken Ecke zurückgegeben
	// Jetzt soll die Position unten mitte zurückgegeben werden
	public Point getLocation() {
		// XXX hier könnten Sie dann entweder auf getStartPoint() oder getEndPoint() zugreifen.
		Point p;
		p = owner.getBounds().getLocation();
//		p.x = p.x + owner.getBounds().width;
//		p.y = p.y + owner.getBounds().height/2;
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
		// XXX Hier können Sie auf line.getEndPoint() zugreifen, aber sie können auch diese Methode leer lassen und dann im
		//     dragInteraction jeweils auf owner.line.getEndPoint() zugreifen.
		Rectangle r = owner.getBounds();
		// XXX mit dem getBounds() geht es definitiv nicht, da sie so jetzt nicht wissen ob die Line von oben links nach untern rechts oder von oben rechts nach unten links verläuft.
//		Line l = owner.getBounds().
		corner = new Point(r.x + r.width, r.y + r.height);
	}

	@Override
	public void dragInteraction(int x, int y, MouseEvent e, DrawView v) {
//		Rectangle r = owner.getBounds();
		
		owner.setBounds(new Point(x, y), corner);
	}

	@Override
	public void stopInteraction(int x, int y, MouseEvent e, DrawView v) {
		corner = null;
	}

}
