package patterns.state.parser;

public class State05 implements State {

	private int exp = 0;

	public State parse(char ch) {
	if(State.isDigit(ch)) { 
		exp = State.getNumericValue(ch); 
		return new State06(); 
		}
	else return new StateError();
	}
}
