package patterns.state.parser;

public class State01 implements State{

	private double m;

	public boolean isDigit(char ch) {
		return Character.isDigit(ch);
	}

	public int getNumericValue(char ch) {
		return Character.getNumericValue(ch);
	}

	public State parse(char ch) {
		if(isDigit(ch)) { 
			m = 10 * m + getNumericValue(ch); 
			return null;
			}
		else if(ch == '.') { 
			return new State03(); }
		else if(ch == 'e') { 
			return new State04(); }
		else if(ch == 'E') { 
			return new State04(); }
		else {
			return new StateError();
		}
		
		
	}
	
}
