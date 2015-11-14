package patterns.state.parser;

public class State03 implements State {

	private double m = 0, quo = 10;
	private int exp = 0, exp_sign = 1;
	
	public State parse(char ch) {
		if(State.isDigit(ch)) { 
			m = m + State.getNumericValue(ch)/quo; 
			quo = quo*10; 
			// XXX hier ist wieder das return null; das falsch ist.
			return this;
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
