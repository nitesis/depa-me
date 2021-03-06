package patterns.composite;

import java.util.LinkedList;
import java.util.List;

public class GroupFigure extends Figure {
	private String name;
	private List<Figure> figures = new LinkedList<Figure>();

	public GroupFigure(String name, Figure... figures) {
		this.name = name;
		for (Figure f : figures) {
			addFigure(f);
		}
	}

	public void addFigure(Figure f) {
		//Exceptions für Baum von oben nach unten durchgehen
		if(f.contained) throw new IllegalArgumentException();
		if(contains(f, this)) throw new IllegalArgumentException();
		
	//	if(contained) throw new IllegalStateException();
		//if(f.contained) throw new IllegalArgumentException();
		figures.add(f);
		f.contained = true;
	}

	public void draw(String prefix) {
		System.out.println(prefix + name);
		for (Figure f : figures) {
			f.draw(prefix + ">>");
		}
	}
	
	// schaut, ob g2 unterhalb von g1 in der Hierarchie liegt
	private boolean contains(Figure g1, GroupFigure g2){
		// schaut, ob Figure gleich GroupFigure ist
		if (g1==g2){
			return true;
		
		// hier wird geschaut für jedes f im Baum, ob g2 unterhalb davon liegt
		}else if(g1 instanceof GroupFigure){
			for(Figure f: ((GroupFigure)g1).figures){
				if(contains(f, g2))
					return true;
			}
		}
		return false;
	}
	
}
