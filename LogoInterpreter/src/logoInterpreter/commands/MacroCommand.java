package logoInterpreter.commands;

import java.util.LinkedList;

public class MacroCommand extends AbstractCommand {
	private final String name;
	private final LinkedList<Command> commands = new LinkedList<>();

	public MacroCommand(String name) {
		super(true);
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	public void add(Command command) {
		commands.add(command);
	}
	
	@Override
	public void execute() {
		for (Command command : commands)
			command.execute();
	}
	
	public String toString() {
		return "Macro " + name + ".";
	}

}
