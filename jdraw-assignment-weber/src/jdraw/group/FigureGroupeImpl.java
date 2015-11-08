package jdraw.group;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import jdraw.figures.AbstractFigure;
import jdraw.framework.Figure;
import jdraw.framework.FigureGroup;

public class FigureGroupeImpl extends AbstractFigure implements FigureGroup {

	private List<Figure> figures = new LinkedList<>();


	public FigureGroupeImpl(List<Figure> selectedFigures) {
		super(setRectangleSize(selectedFigures));
		this.figures = selectedFigures;
	}
	
	private FigureGroupeImpl(FigureGroupeImpl figure) {
		super(figure);
		this.figures = cloneFigureParts(figure.getFigureParts());
	}
	
	private List<Figure> cloneFigureParts(Iterable<Figure> figures){
		List<Figure> clones = new LinkedList<>();
		for(Figure f: figures){
			clones.add(f.clone());
		}
		return clones;
	}

	private static Rectangle setRectangleSize(List<Figure> figureList) {
		if (figureList.size() < 2) {
			throw new IllegalArgumentException();
		}
		Rectangle r = figureList.get(0).getBounds();
		for (Figure f : figureList) {
			r.add(f.getBounds());
		}
		return r;
	}

	@Override
	public Iterable<Figure> getFigureParts() {
		return Collections.unmodifiableList(figures);
//		return figures;
	}

	@Override
	protected void drawFigure(Graphics g) {
		for (Figure f : figures) {
			f.draw(g);
		}
	}

	@Override
	public void setBounds(Point origin, Point corner) {
		move(origin.x, origin.y);
	}

	@Override
	public void move(int dx, int dy) {
		for (Figure f : figures) {
			f.move(dx, dy);
		}
		super.move(dx, dy);
	}

	@Override
	public boolean contains(int x, int y) {
		boolean result = false;
		for (Figure f : figures) {
			if (f.contains(x, y)) {
				result = true;
			}
		}
		return result;
	}

	@Override
	public void draw(Graphics g) {
		for (Figure f : figures) {
			f.draw(g);
		}
		g.drawString(getString(), getBounds().x, getBounds().y);
	}

	@Override
	public Figure clone() {
		return new FigureGroupeImpl(this);
	}
}
