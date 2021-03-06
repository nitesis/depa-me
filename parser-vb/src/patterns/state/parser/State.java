package patterns.state.parser;

public interface State {

	// XXX die folgenden beiden Methoden isDigit und getNumericValue sind eigentlich nur Hilfsmethoden
	//     die nicht vom Zustand abhängen, diese müssten nicht im State-Interface definiert werden
	//     bzw. könnten (zumindest seit Java8) auch als statische Methoden im Interface definiert werden.
	//     Man erkennt dies daran, dass diese Methoden in ALLEN Implementierungen dieses State-Interfaces
	//     identisch sind! 
	static boolean isDigit(char ch) {
		return Character.isDigit(ch);
	}
	static int getNumericValue(char ch) {
		return Character.getNumericValue(ch);
	}
	
	// XXX was hier jetzt noch fehlt ist die eigentliche Methode (oder die Methoden) die auf dem aktuellen
	//     State-Objekt aufgerufen werden und die sich dann zustandsspezifisch verhalten. Diese Methode
	//     ist aber in den eigentlichen Unterklassen implementiert. Ich habe Sie hier eingefügt.
	public State parse(char ch);

}
