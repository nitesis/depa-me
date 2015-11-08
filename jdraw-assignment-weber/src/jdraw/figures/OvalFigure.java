package jdraw.figures;

import java.awt.Graphics;

import jdraw.framework.Figure;

public class OvalFigure extends AbstractFigure {

	public OvalFigure(int x, int y, int w, int h) {
		super(x, y, w, h);
	}
	
	private OvalFigure(OvalFigure figure) {
		super(figure);
	}

	@Override
	protected void fillFigure(Graphics g) {
		g.fillOval(getShape().x, getShape().y, getShape().width,
				getShape().height);
	}

	@Override
	protected void drawFigure(Graphics g) {
		g.drawOval(getShape().x, getShape().y, getShape().width,
				getShape().height);
	}

	@Override
	public Figure clone() {
		return new OvalFigure(this);
	}

}
