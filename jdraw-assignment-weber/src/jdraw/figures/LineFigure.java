package jdraw.figures;

import java.awt.Graphics;

import com.google.common.collect.ImmutableList;

import jdraw.framework.Figure;
import jdraw.framework.FigureHandle;

public class LineFigure extends AbstractFigure {

	private int xAnchor = getShape().x;
	private int yAnchor = getShape().y;

	protected LineFigure(int x, int y, int w, int h) {
		super(x, y, w, h);
	}

	private LineFigure(LineFigure figure) {
		super(figure);
	}

	@Override
	protected ImmutableList<FigureHandle> createHandles() {
		return ImmutableList.of();
	}

	@Override
	protected void drawFigure(Graphics g) {
		g.drawLine(getX1(), getY1(), getX2(), getY2());
	}

	private int getX1() {
		return isXDecreasing() ? getShape().x + getShape().width : getShape().x;
	}

	private int getX2() {
		return isXDecreasing() ? getShape().x : getShape().x + getShape().width;
	}

	private int getY1() {
		return isYDecreasing() ? getShape().y + getShape().height : getShape().y;
	}

	private int getY2() {
		return isYDecreasing() ? getShape().y : getShape().y + getShape().height;
	}

	public boolean isYDecreasing() {
		return yAnchor > getShape().y;
	}

	public boolean isXDecreasing() {
		return xAnchor > getShape().x;
	}

	@Override
	public void move(int dx, int dy) {
		xAnchor = getShape().x + dx;
		yAnchor = getShape().y + dy;
		super.move(dx, dy);
	}

	@Override
	public Figure clone() {
		return new LineFigure(this);
	}
}
