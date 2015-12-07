package logoInterpreter.commands;

import logoInterpreter.Turtles;

public class PenUpCommand extends AbstractCommand {
	private final Turtles turtles;

	public PenUpCommand(Turtles turtles) {
		super(true);
		this.turtles = turtles;
	}

	@Override
	public void execute() {
		turtles.up();
		System.out.println("Lifting pen up.");
	}

	public String toString() {
		return "Lifting pen down.";
	}

}
