package logoInterpreter.commands;

import logoInterpreter.Turtles;

public class MoveCommand extends AbstractCommand {
	private final Turtles turtles;
	private final int amount;

	public MoveCommand(Turtles turtles, int amount) {
		super(true);
		this.turtles = turtles;
		this.amount = amount;
	}

	@Override
	public void execute() {
		turtles.move(amount);
	}

	public String toString() {
		return "Moving " + amount + " steps.";
	}

}
