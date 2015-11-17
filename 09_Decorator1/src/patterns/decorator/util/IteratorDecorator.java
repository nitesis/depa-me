package patterns.decorator.util;

import java.util.Iterator;
import java.util.function.Consumer;

public class IteratorDecorator implements Iterator {
	private Iterator inner;
	
	
	
	public IteratorDecorator(Iterator inner) {
		super();
		this.inner = inner;
	}

	public boolean hasNext() {
		return inner.hasNext();
	}

	public Object next() {
		return inner.next();
	}

	public void remove() {
		throw new UnsupportedOperationException();
	}

	public void forEachRemaining(Consumer action) {
		inner.forEachRemaining(action);
	}

	
	
}