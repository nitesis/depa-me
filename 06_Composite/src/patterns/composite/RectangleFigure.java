package patterns.composite;

public class RectangleFigure extends Figure {
	private String name;

	public RectangleFigure(String name) {
		this.name = name;
	}

	@Override
	public void draw(String prefix) {
		System.out.println(prefix + name);
	}
}
