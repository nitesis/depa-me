package logoInterpreter.commands;

public class NotFoundCommand extends AbstractCommand {
	private final String commandName;

	public NotFoundCommand(String commandName) {
		super(false);
		this.commandName = commandName;
	}

	public void execute() {
		// do nothing
	}
	
	public String toString() {
		return "Command " + commandName + " unknown.";
	}
}