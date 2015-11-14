package patterns.state.parser;

public class State00 implements State{

	

	public State parse(char ch){
		if(State.isDigit(ch)) {
			// XXX das Problem ist dass m eine lokale Variable ist und nach dem Aufruf von parse wieder verschwunden ist.
			double m = State.getNumericValue(ch); 
			return new State01(); }
		else if(ch == '.') { 
			return new State02(); }
		else return new StateError();
	}
}
