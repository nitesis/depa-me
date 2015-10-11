package jdraw.std;

import java.awt.Cursor;

import jdraw.framework.DrawContext;
import jdraw.framework.DrawTool;

public abstract class AbstractFigureTool implements DrawTool {

	private DrawContext context;
	
	public void deactivate() {
		this.context.showStatusText("");
	}
	
	public Cursor getCursor() {
		return Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR);
	}
}
