package logoInterpreter.commands;

import logoInterpreter.Turtles;

public class RotateCommand extends AbstractCommand {
	private final Turtles turtles;
	private final int amount;

	public RotateCommand(Turtles turtles, int leftAmount) {
		super(true);
		this.turtles = turtles;
		this.amount = leftAmount;
	}

	@Override
	public void execute() {
		turtles.left(amount);
	}

	public String toString() {
		return "Rotating " + amount + " degrees left.";
	}

}
