package patterns.composite;


public class Test1 {
	public static void main(String[] args) {
		Figure f1 = new RectangleFigure("f1");
		Figure f2 = new RectangleFigure("f2");
		Figure f3 = new OvalFigure("f3");
		GroupFigure g1 = new GroupFigure("g1", f1, f2);
		
		GroupFigure g2 = new GroupFigure("g2", f3, f1);
		g1.draw("");
		g2.draw("");
	}
}
