package patterns.state.parser;

public class StateError implements State{

	@Override
	public boolean isDigit(char ch) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getNumericValue(char ch) {
		// TODO Auto-generated method stub
		return 0;
	}

}
