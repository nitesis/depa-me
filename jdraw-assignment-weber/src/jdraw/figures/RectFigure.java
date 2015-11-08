/*
 * Copyright (c) 2000-2016 Fachhochschule Nordwestschweiz (FHNW)
 * All Rights Reserved. 
 */

package jdraw.figures;

import java.awt.Graphics;

import jdraw.framework.Figure;

/**
 * Represents rectangles in JDraw.
 * 
 * @author Christoph Denzler
 *
 */
public class RectFigure extends AbstractFigure {

	public RectFigure(int x, int y, int w, int h) {
		super(x, y, w, h);
	}
	
	private RectFigure(RectFigure figure) {
		super(figure);
	}

	@Override
	protected void fillFigure(Graphics g) {
		g.fillRect(getShape().x, getShape().y, getShape().width,
				getShape().height);

	}

	@Override
	protected void drawFigure(Graphics g) {
		g.drawRect(getShape().x, getShape().y, getShape().width,
				getShape().height);
	}

	@Override
	public Figure clone() {
		return new RectFigure(this);
	}
}
