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
			// XXX hier verwenden Sie nun nicht eine lokale Variable sondern ein Feld in der Klasse State01.
			//     Aber da bei jedem Zustandswechsel ein neues State-Objekt erzeugt wird wird die Variable
			//     m immer neu erzeugt.
			m = 10 * m + getNumericValue(ch); 
			// XXX das return null ist auch nicht gut fals dan das Resultat als neuer Zustand verwendet wird.
			//     Falls sie im Zustand S1 bleiben wollen, so geben Sie entweder return new State01() oder
			//     return this; zurück.
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
