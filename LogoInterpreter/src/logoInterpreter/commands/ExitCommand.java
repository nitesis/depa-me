package logoInterpreter.commands;

import logoInterpreter.LogoInterpreter;

public class ExitCommand extends AbstractCommand {
	private final LogoInterpreter interpreter;

	public ExitCommand(LogoInterpreter interpreter) {
		super(false);
		this.interpreter = interpreter;
	}

	@Override
	public void execute() {
		interpreter.stop();
	}
	
	public String toString() {
		return "Exiting.";
	}

}
