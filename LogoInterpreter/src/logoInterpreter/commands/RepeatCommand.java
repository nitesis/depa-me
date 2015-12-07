package logoInterpreter.commands;

public class RepeatCommand extends AbstractCommand {
	private final int amount;
	private final Command command;

	public RepeatCommand(int amount, Command command) {
		super(true);
		this.amount = amount;
		this.command = command;
	}

	@Override
	public void execute() {
		for (int i = 0; i < amount; i++) {
			command.execute();
		}
	}
	
	public String toString() {
		return "Repeating " + amount + " times " + command;
	}

}
