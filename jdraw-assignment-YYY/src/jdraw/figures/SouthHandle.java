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

public class SouthHandle implements FigureHandle{

	private Figure owner; 
	private Point corner;
	
	public SouthHandle (Figure figure) {
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
		Point p;
		p = owner.getBounds().getLocation();
		p.x = p.x + owner.getBounds().width/2;
		p.y = p.y + owner.getBounds().height;
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
		return Cursor.getPredefinedCursor(Cursor.S_RESIZE_CURSOR);
	}

	@Override
	public boolean contains(int x, int y) {
		Rectangle rect = new Rectangle(getLocation().x - 3, getLocation().y - 3, 6, 6);
		return rect.contains(x, y);
	}

	@Override
	public void startInteraction(int x, int y, MouseEvent e, DrawView v) {
		Rectangle r = owner.getBounds();
		corner = new Point(r.x + r.width, r.y + r.height);
	}

	@Override
	public void dragInteraction(int x, int y, MouseEvent e, DrawView v) {
		Rectangle r = owner.getBounds();
		// XXX der erste Parameter im setBounds ist falsch. Hier dürfen SIe nicht auf die Bounds der Figur zurückgreifen, denn diese wird ja gerade
		//     verändert. Das geht zwar gut solange der untere Rand nicht über den oberen Rand geschoben wird. Sie müssen Sich also im mouseDown den
		//     Punkt (x,y), also owner.getBounds().getLocation() merken (kopie), wie sie das auch bei den anderen Handles gemacht haben. 
		//     Und das was sie jetzt als corner.x verwenden, das muss natürich auch gespeichert werden, vielleicht in einer int-Variablen.
		//     Diesen Wert könnten Sie aber über das getBounds des Owners abholen, denn diese Koordinate ändert sich ja nie (so haben sie es
		//     im NorthHandle, WestHandle und EastHandle gemacht.
		owner.setBounds(owner.getBounds().getLocation(), new Point(corner.x, y));
	}

	@Override
	public void stopInteraction(int x, int y, MouseEvent e, DrawView v) {
		corner = null;
	}

}
