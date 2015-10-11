package patterns.state.parser;

public class State06 implements State {

	private int exp = 0;
	
	public boolean isDigit(char ch) {
		return Character.isDigit(ch);
	}

	public int getNumericValue(char ch) {
		return Character.getNumericValue(ch);
	}
	
	public State parse(char ch) {
	if(isDigit(ch)) { 
		exp = 10*exp + getNumericValue(ch); 
		// XXX hier ist auch wieder das return null; das falsch ist.
		return null;
	}
	else return new StateError();
	
	}
}
