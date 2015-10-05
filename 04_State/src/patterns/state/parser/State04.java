package patterns.state.parser;

public class State04 implements State{

	private int exp = 0, exp_sign = 1;
	
	public boolean isDigit(char ch) {
		return Character.isDigit(ch);
	}

	public int getNumericValue(char ch) {
		return Character.getNumericValue(ch);
	}
	
	public State parse(char ch) {
		if(ch == '+') return new State05();
		else if(ch == '-') { 
			exp_sign = -1; 
			return new State05(); }
		else if(isDigit(ch)) { 
			exp = getNumericValue(ch); 
			return new State06(); }
		else return new StateError();
	}
}
