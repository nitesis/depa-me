/*
 * Copyright (c) 2000-2016 Fachhochschule Nordwestschweiz (FHNW)
 * All Rights Reserved. 
 */

package jdraw.figures;

import jdraw.framework.DrawContext;
import jdraw.framework.Figure;

/**
 * This tool defines a mode for drawing rectangles.
 *
 * @see jdraw.framework.Figure
 *
 * @author Christoph Denzler
 * @version 2.1, 27.09.07
 */
public class RectTool extends AbstractDrawTool {

	public RectTool(DrawContext context) {
		super(context);
	}

	@Override
	protected Figure createFigure(int x, int y) {
		return new RectFigure(x, y, 0, 0);
	}

	@Override
	protected String getFigureMode() {
		return "Rectangle Mode";
	}

	@Override
	protected String getImageName() {
		return "rectangle.png";
	}

	@Override
	public String getName() {
		return "Rectangle";
	}

}
