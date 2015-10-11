package patterns.state.parser;

public class State00 implements State{

	public boolean isDigit(char ch) {
		return Character.isDigit(ch);
	}

	public int getNumericValue(char ch) {
		return Character.getNumericValue(ch);
	}

	public State parse(char ch){
		if(isDigit(ch)) {
			// XXX das Problem ist dass m eine lokale Variable ist und nach dem Aufruf von parse wieder verschwunden ist.
			double m = getNumericValue(ch); 
			return new State01(); }
		else if(ch == '.') { 
			return new State02(); }
		else return new StateError();
	}
}
