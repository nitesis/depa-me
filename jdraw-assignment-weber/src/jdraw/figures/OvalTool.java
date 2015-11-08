package jdraw.figures;

import jdraw.framework.DrawContext;
import jdraw.framework.Figure;

public class OvalTool extends AbstractDrawTool {

	public OvalTool(DrawContext context) {
		super(context);
	}

	@Override
	protected Figure createFigure(int x, int y) {
		return new OvalFigure(x, y, 0, 0);
	}

	@Override
	protected String getFigureMode() {
		return "Oval Mode";
	}

	@Override
	protected String getImageName() {
		return "oval.png";
	}

	@Override
	public String getName() {
		return "Oval";
	}
}
