package patterns.state.parser;

public class State04 implements State{

	private int exp = 0, exp_sign = 1;

	public State parse(char ch) {
		if(ch == '+') return new State05();
		else if(ch == '-') { 
			exp_sign = -1; 
			return new State05(); }
		else if(State.isDigit(ch)) { 
			exp = State.getNumericValue(ch); 
			return new State06(); }
		else return new StateError();
	}
}
