package logoInterpreter;

import logoInterpreter.commands.Command;

public class StdHistoryManager implements HistoryManager {
	private final LogoInterpreter interpreter;
	
	public StdHistoryManager(LogoInterpreter interpreter) {
		this.interpreter = interpreter;
	}
	/**
	 * Fügt einen Command in die History ein. Dieser Command wird bereits im 
	 * LogoInterpreter ausgeführt, darf also hier nich nochmals ausgeführt werden.
	 */
	@Override
	public void add(Command command) {
		// TODO Auto-generated method stub

	}

	/**
	 * Leert die History.
	 */
	@Override
	public void clear() {
		// TODO Auto-generated method stub

	}
	/**
	 * Macht einen Schritt in der History rückgängig. Gibt eine Meldung aus, 
	 * falls nichts rückgängig gemacht werden kann.
	 */
	@Override
	public void undo() {
		// TODO Auto-generated method stub

	}

	/**
	 * Stellt einen Schritt in der History wieder her. Gibt eine Meldung aus, 
	 * falls kein Schritt wiederhergestellt werden kann.
	 */
	@Override
	public void redo() {
		// TODO Auto-generated method stub

	}

	/**
	 * Gibt sämtliche bisherige Commands der History zurück. Wird vor allem 
	 * von der repaint()-Methode des LogoInterpreters verwendet.
	 */
	@Override
	public Iterable<Command> getCommands() {
		// TODO Auto-generated method stub
		return null;
	}

}
