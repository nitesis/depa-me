package patterns.factory.spring;

public class A {
	
	public A() {
		System.out.println("A() called");
	}

	private B b;

	public B getB() {
		return b;
	}

	public void setB(B b) {
		System.out.println("A.setB called");
		this.b = b;
	}
	
	private String value;

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}
