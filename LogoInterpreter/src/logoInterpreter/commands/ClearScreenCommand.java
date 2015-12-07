package logoInterpreter.commands;

import logoInterpreter.LogoInterpreter;

public class ClearScreenCommand extends AbstractCommand {
	private final LogoInterpreter interpreter;

	public ClearScreenCommand(LogoInterpreter interpreter) {
		super(true);
		this.interpreter = interpreter;
	}

	@Override
	public void execute() {
		interpreter.resetTurtle();
		interpreter.getHistoryManager().clear();
	}
	
	public String toString() {
		return "Resetting graphics.";
	}

}
