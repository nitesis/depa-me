package logoInterpreter;

import logoInterpreter.commands.Command;

public class StdMacroManager implements MacroManager {
	private final LogoInterpreter interpreter;

	public StdMacroManager(LogoInterpreter interpreter) {
		this.interpreter = interpreter;
	}
	/** 
	 * Gibt an, ob gerade ein Makro aufgezeichnet wird.
	 */
	@Override
	public boolean isRecordingMacro() {
		// TODO Auto-generated method stub
		return false;
	}
	/**
	 * Zeichnet ein Command auf. Der LogoInterpreter stellt dabei sicher, 
	 * dass nur Commands in den MacroManager kommen, welche auf der Schildkröte 
	 * ausgeführt werden können.  Ebenfalls wird vom LogoInterpreter sichergestellt, 
	 * dass diese Methode nur aufgerufen wird, falls ein Makro aufgezeichnet wird.
	 * 
	 */
	@Override
	public void handleCommand(Command command) {
		// TODO Auto-generated method stub

	}
	/**
	 * Beginnt mit der Aufzeichnung eines neuen Makros. Nach Beendigung des Makros 
	 * sollte der Zustand vor der Aufzeichnung des Makros wiederhergestellt werden.
	 */
	@Override
	public void startMacro(String name) {
		// TODO Auto-generated method stub

	}
	/**
	 * Gibt das Makro mit dem Namen name zurück. Falls das Makro nicht 
	 * existiert, wird ein NotFoundCommand zurückgegeben.
	 */
	@Override
	public Command getCommand(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Speichert und beendet die Aufzeichnung des aktuellen Makros.
	 */
	@Override
	public void endMacro() {
		// TODO Auto-generated method stub

	}

}
