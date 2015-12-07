package logoInterpreter.commands;

import logoInterpreter.Turtles;

public class PenDownCommand extends AbstractCommand {
	private final Turtles turtles;

	public PenDownCommand(Turtles turtles) {
		super(true);
		this.turtles = turtles;
	}

	@Override
	public void execute() {
		turtles.down();
	}
	
	public String toString() {
		return "Putting pen down.";
	}

}
