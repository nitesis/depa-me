package logoInterpreter.commands;

public abstract class AbstractCommand implements Command {
	private final boolean isTurtleCommand;

	public AbstractCommand(boolean supportsUndoRedo) {
		this.isTurtleCommand = supportsUndoRedo;
	}

	@Override
	public final boolean isTurtleCommand() {
		return isTurtleCommand;
	}

}
