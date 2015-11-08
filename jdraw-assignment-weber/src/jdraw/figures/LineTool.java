package jdraw.figures;

import jdraw.framework.DrawContext;
import jdraw.framework.Figure;

public class LineTool extends AbstractDrawTool {

	public LineTool(DrawContext context) {
		super(context);
	}
	
	@Override
	protected Figure createFigure(int x, int y) {
		return new LineFigure(x, y, 0, 0);
	}

	@Override
	protected String getFigureMode() {
		return "Line Mode";
	}

	@Override
	protected String getImageName() {
		return "line.png";
	}

	@Override
	public String getName() {
		return "Line";
	}

}
