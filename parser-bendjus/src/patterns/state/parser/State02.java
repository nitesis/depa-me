package patterns.state.parser;

public class State02 implements State{

	double m = 0, quo = 10; 
	
	public State parse(char ch) {
		if(State.isDigit(ch)) { 
			m = m + State.getNumericValue(ch)/quo; 
			quo = quo*10; 
			return new State03(); } 
		else return new StateError();
		
	}

}
