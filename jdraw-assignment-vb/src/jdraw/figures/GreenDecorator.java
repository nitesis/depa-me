package jdraw.figures;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.image.ImageObserver;
import java.text.AttributedCharacterIterator;
import java.util.List;

import jdraw.framework.Figure;
import jdraw.framework.FigureHandle;
import jdraw.framework.FigureListener;

public class GreenDecorator implements Figure {
	private  Figure inner;

	public GreenDecorator(Figure inner) {
		this.inner = inner;
	}

	public Figure getInner() {
		return inner;
	}
	
	@Override
	public void addFigureListener(FigureListener listener) {
		inner.addFigureListener(listener);
	}

	@Override
	public Figure clone() {
		return inner.clone();
	}

	@Override
	public boolean contains(int x, int y) {
		return inner.contains(x, y);
	}

	@Override
	public void draw(Graphics g) {
		inner.draw(new GraphicsDecorator(g));
	}

	@Override
	public Rectangle getBounds() {
		return inner.getBounds();
	}

	@Override
	public List<FigureHandle> getHandles() {
		return inner.getHandles();
	}

	@Override
	public void move(int dx, int dy) {
		inner.move(dx, dy);
	}

	@Override
	public void removeFigureListener(FigureListener listener) {
		inner.removeFigureListener(listener);
	}

	@Override
	public void setBounds(Point origin, Point corner) {
		inner.setBounds(origin, corner);
	}


	static class GraphicsDecorator extends Graphics {
		private Graphics inner;

		public GraphicsDecorator(Graphics inner) {
			inner.setColor(Color.GREEN);
			this.inner = inner;
		}

		@Override
		public void setColor(Color c) {
			if (c.equals(Color.white) || c.equals(Color.black)) {
				inner.setColor(c);
			} else {
				inner.setColor(Color.green);
			}
		}

		@Override
		public void clearRect(int x, int y, int width, int height) {
			inner.clearRect(x, y, width, height);
		}

		@Override
		public void clipRect(int x, int y, int width, int height) {
			inner.clipRect(x, y, width, height);
		}

		@Override
		public void copyArea(int x, int y, int width, int height, int dx, int dy) {
			inner.copyArea(x, y, width, height, dx, dy);
		}

		@Override
		public Graphics create() {
			return inner.create();
		}

		@Override
		public Graphics create(int x, int y, int width, int height) {
			return inner.create(x, y, width, height);
		}

		@Override
		public void dispose() {
			inner.dispose();
		}

		@Override
		public void draw3DRect(int x, int y, int width, int height,
				boolean raised) {
			inner.draw3DRect(x, y, width, height, raised);
		}

		@Override
		public void drawArc(int x, int y, int width, int height,
				int startAngle, int arcAngle) {
			inner.drawArc(x, y, width, height, startAngle, arcAngle);
		}

		@Override
		public void drawBytes(byte[] data, int offset, int length, int x, int y) {
			inner.drawBytes(data, offset, length, x, y);
		}

		@Override
		public void drawChars(char[] data, int offset, int length, int x, int y) {
			inner.drawChars(data, offset, length, x, y);
		}

		@Override
		public boolean drawImage(Image img, int x, int y, Color bgcolor,
				ImageObserver observer) {
			return inner.drawImage(img, x, y, bgcolor, observer);
		}

		@Override
		public boolean drawImage(Image img, int x, int y, ImageObserver observer) {
			return inner.drawImage(img, x, y, observer);
		}

		@Override
		public boolean drawImage(Image img, int x, int y, int width,
				int height, Color bgcolor, ImageObserver observer) {
			return inner.drawImage(img, x, y, width, height, bgcolor, observer);
		}

		@Override
		public boolean drawImage(Image img, int x, int y, int width,
				int height, ImageObserver observer) {
			return inner.drawImage(img, x, y, width, height, observer);
		}

		@Override
		public boolean drawImage(Image img, int dx1, int dy1, int dx2, int dy2,
				int sx1, int sy1, int sx2, int sy2, Color bgcolor,
				ImageObserver observer) {
			return inner.drawImage(img, dx1, dy1, dx2, dy2, sx1, sy1, sx2, sy2,
					bgcolor, observer);
		}

		@Override
		public boolean drawImage(Image img, int dx1, int dy1, int dx2, int dy2,
				int sx1, int sy1, int sx2, int sy2, ImageObserver observer) {
			return inner.drawImage(img, dx1, dy1, dx2, dy2, sx1, sy1, sx2, sy2,
					observer);
		}

		@Override
		public void drawLine(int x1, int y1, int x2, int y2) {
			inner.drawLine(x1, y1, x2, y2);
		}

		@Override
		public void drawOval(int x, int y, int width, int height) {
			inner.drawOval(x, y, width, height);
		}

		@Override
		public void drawPolygon(int[] xPoints, int[] yPoints, int nPoints) {
			inner.drawPolygon(xPoints, yPoints, nPoints);
		}

		@Override
		public void drawPolygon(Polygon p) {
			inner.drawPolygon(p);
		}

		@Override
		public void drawPolyline(int[] xPoints, int[] yPoints, int nPoints) {
			inner.drawPolyline(xPoints, yPoints, nPoints);
		}

		@Override
		public void drawRect(int x, int y, int width, int height) {
			inner.drawRect(x, y, width, height);
		}

		@Override
		public void drawRoundRect(int x, int y, int width, int height,
				int arcWidth, int arcHeight) {
			inner.drawRoundRect(x, y, width, height, arcWidth, arcHeight);
		}

		@Override
		public void drawString(AttributedCharacterIterator iterator, int x,
				int y) {
			inner.drawString(iterator, x, y);
		}

		@Override
		public void drawString(String str, int x, int y) {
			inner.drawString(str, x, y);
		}

		@Override
		public boolean equals(Object obj) {
			return inner.equals(obj);
		}

		@Override
		public void fill3DRect(int x, int y, int width, int height,
				boolean raised) {
			inner.fill3DRect(x, y, width, height, raised);
		}

		@Override
		public void fillArc(int x, int y, int width, int height,
				int startAngle, int arcAngle) {
			inner.fillArc(x, y, width, height, startAngle, arcAngle);
		}

		@Override
		public void fillOval(int x, int y, int width, int height) {
			inner.fillOval(x, y, width, height);
		}

		@Override
		public void fillPolygon(int[] xPoints, int[] yPoints, int nPoints) {
			inner.fillPolygon(xPoints, yPoints, nPoints);
		}

		@Override
		public void fillPolygon(Polygon p) {
			inner.fillPolygon(p);
		}

		@Override
		public void fillRect(int x, int y, int width, int height) {
			inner.fillRect(x, y, width, height);
		}

		@Override
		public void fillRoundRect(int x, int y, int width, int height,
				int arcWidth, int arcHeight) {
			inner.fillRoundRect(x, y, width, height, arcWidth, arcHeight);
		}

		@Override
		public void finalize() {
			inner.finalize();
		}

		@Override
		public Shape getClip() {
			return inner.getClip();
		}

		@Override
		public Rectangle getClipBounds() {
			return inner.getClipBounds();
		}

		@Override
		public Rectangle getClipBounds(Rectangle r) {
			return inner.getClipBounds(r);
		}

		@Override
		public Rectangle getClipRect() {
			return inner.getClipRect();
		}

		@Override
		public Color getColor() {
			return inner.getColor();
		}

		@Override
		public Font getFont() {
			return inner.getFont();
		}

		@Override
		public FontMetrics getFontMetrics() {
			return inner.getFontMetrics();
		}

		@Override
		public FontMetrics getFontMetrics(Font f) {
			return inner.getFontMetrics(f);
		}

		@Override
		public int hashCode() {
			return inner.hashCode();
		}

		@Override
		public boolean hitClip(int x, int y, int width, int height) {
			return inner.hitClip(x, y, width, height);
		}

		@Override
		public void setClip(int x, int y, int width, int height) {
			inner.setClip(x, y, width, height);
		}

		@Override
		public void setClip(Shape clip) {
			inner.setClip(clip);
		}

		@Override
		public void setFont(Font font) {
			inner.setFont(font);
		}

		@Override
		public void setPaintMode() {
			inner.setPaintMode();
		}

		@Override
		public void setXORMode(Color c1) {
			inner.setXORMode(c1);
		}

		@Override
		public String toString() {
			return inner.toString();
		}

		@Override
		public void translate(int x, int y) {
			inner.translate(x, y);
		}
	}
}
