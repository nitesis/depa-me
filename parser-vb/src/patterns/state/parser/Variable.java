package patterns.state.parser;

public class Variable {

	private double m = 0, quo = 10;
	private int exp = 0, exp_sign = 1;
	
	public Variable (double m, double quo, int exp, int exp_sign) {
		this.m = m;
		this.quo = quo;
		this.exp = exp;
		this.exp_sign = exp_sign;
	}
	
	public double getM(){
		return m;
	}
	
	public double getQuo(){
		return quo;
	}
	
	public int getExp(){
		return exp;
	}
	
	public int getExpSign(){
		return exp_sign;
	}
}
