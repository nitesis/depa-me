import java.util.Collection;
import java.util.Iterator;

public abstract class AbstractCollection<E> implements Collection<E> {

	
	@Override
	public int size() {
		int s = 0;
		for (E e : this) {
			s++;
		}
		return s;
	}
	
	@Override
	public boolean add(E e) {
		int size = size();
		size++;
		return contains(e);
	}
	
	@Override
	public boolean isEmpty() {
		return size() == 0;
	}
	
	public boolean contains(Object o) {
		Iterator<E> it = this.iterator();
		while (!(it.next().equals(o)) && it.hasNext()){
			it.next();
		}
		return it.next().equals(o);
	}
	
	@Override
	public Iterator<E> iterator() {
		return null;
	}
}
