package patterns.state.parser;

public class State02 implements State{

	double m = 0, quo = 10; 
	
	public boolean isDigit(char ch) {
		return Character.isDigit(ch);
	}

	public int getNumericValue(char ch) {
		return Character.getNumericValue(ch);
	}
	
	public State parse(char ch) {
		if(isDigit(ch)) { 
			m = m + getNumericValue(ch)/quo; 
			quo = quo*10; 
			return new State03(); } 
		else return new StateError();
		
	}

}
