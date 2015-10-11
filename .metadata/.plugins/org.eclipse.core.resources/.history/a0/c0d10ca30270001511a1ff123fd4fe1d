package patterns.state.parser;

public class State03 implements State {

	private double m = 0, quo = 10;
	private int exp = 0, exp_sign = 1;
	
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
			// XXX hier ist wieder das return null; das falsch ist.
			return null;
		}
		else if(ch == 'e') { 
			return new State04(); 
			}
		else if(ch == 'E') { 
			return new State04(); 
			}
		else return new StateError();
	}

}
