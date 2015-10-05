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
			double m = getNumericValue(ch); 
			return new State01(); }
		else if(ch == '.') { 
			return new State02(); }
		else return new StateError();
	}
}
