package patterns.state.parser;

public class StateError implements State{

	// XXX da ich die Methode State parse(char ch) neu in das Interface aufgenommen habe muss diese Methode hier auch implementiert werden.
	//     Die einfachste Implementierung ist, dass sie einfach im Fehlerzustand bleiben.
	@Override
	public State parse(char ch) {
		return this;
	}

}
