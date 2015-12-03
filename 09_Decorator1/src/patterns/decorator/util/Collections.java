package patterns.decorator.util;

import java.util.Collection;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class Collections{

	static class CollectionDecorator implements Collection {
		
		private Collection inner;

		public CollectionDecorator(Collection inner) {
			super();
			this.inner = inner;
		}
		
		public int size() {
			return inner.size();
		}

		public boolean isEmpty() {
			return inner.isEmpty();
		}

		public boolean contains(Object o) {
			return inner.contains(o);
		}

		public IteratorDecorator iterator() {
			try {
				return new IteratorDecorator(inner.iterator());
			}catch (Exception e){}
			throw new UnsupportedOperationException();
		}

		public Object[] toArray() {
			return inner.toArray();
		}

		public Object[] toArray(Object[] a) {
			return inner.toArray(a);
		}

		public boolean add(Object e) {
			throw new UnsupportedOperationException();
		}

		public boolean remove(Object o) {
			throw new UnsupportedOperationException();
		}

		public boolean containsAll(Collection c) {
			return inner.containsAll(c);
		}

		public boolean addAll(Collection c) {
			throw new UnsupportedOperationException();
		}

		public boolean removeAll(Collection c) {
			throw new UnsupportedOperationException();
		}

		

		public boolean retainAll(Collection c) {
			throw new UnsupportedOperationException();
		}

		public void clear() {
			throw new UnsupportedOperationException();
		}

		public boolean equals(Object o) {
			return inner.equals(o);
		}

		public int hashCode() {
			return inner.hashCode();
		}

		
		
		
	}
	
	public static <T> Collection<T> unmodifiableCollection(Collection<T> c) {
		return new CollectionDecorator(c);
	}

	
}
