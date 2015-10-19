package patterns.composite;


public class Test2 {
	public static void main(String[] args) {
		Figure f1 = new RectangleFigure("f1");
		Figure f2 = new RectangleFigure("f2");
		Figure f3 = new OvalFigure("f3");
		
		GroupFigure g1 = new GroupFigure("g1", f1, f2);
		GroupFigure g2 = new GroupFigure("g2", g1, f3);
		
		g1.addFigure(g2);

		g2.draw("");
	}
}
