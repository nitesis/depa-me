package patterns.state.parser;

public class State06 implements State {

	private int exp = 0;
	private Variable v;
	

	public State parse(char ch) {
	if(State.isDigit(ch)) { 
		exp = 10*exp + State.getNumericValue(ch); 
		// XXX hier ist auch wieder das return null; das falsch ist.
		return this;
	}
	else return new StateError();
	
	}
}
