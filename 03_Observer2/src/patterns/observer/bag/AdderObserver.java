package patterns.observer.bag;

public class AdderObserver implements java.util.Observer {

	@Override
	public void update(java.util.Observable source, Object arg) {
		IntegerBag bag = (IntegerBag) source;

		int sum = 0;
		for (int n : bag.getValues()) {
			sum += n;
		}

		System.out.println("Content has changed: new sum is " + sum);
	}

	
}
