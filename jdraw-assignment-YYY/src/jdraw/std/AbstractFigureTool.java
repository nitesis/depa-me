package jdraw.std;

import java.awt.Cursor;

import jdraw.framework.DrawContext;
import jdraw.framework.DrawTool;
import jdraw.framework.DrawView;

public abstract class AbstractFigureTool implements DrawTool {

	private DrawContext context;
	private DrawView view;

	public AbstractFigureTool(DrawContext context) {
		this.context = context;
		this.view = context.getView();
	}
	
	public void deactivate() {
		this.context.showStatusText("");
	}
	
	public Cursor getCursor() {
		return Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR);
	}
}
