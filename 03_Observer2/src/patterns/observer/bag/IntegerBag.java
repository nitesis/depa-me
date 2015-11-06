package patterns.observer.bag;

import java.util.ArrayList;
import java.util.List;

public class IntegerBag extends java.util.Observable {
	private List<Integer> list = new ArrayList<Integer>();

	public void addValue(int value) {
		list.add(value);
		// NEU wegen java.util.Observable -> Explizit
		setChanged();
		notifyObservers();
	}

	public void removeValue(int value) {
		list.remove((Object) value);
		// NEU wegen java.util.Observable -> Explizit
		setChanged();
		notifyObservers();
	}

	public Integer[] getValues() {
		return list.toArray(new Integer[list.size()]);
	}

}
