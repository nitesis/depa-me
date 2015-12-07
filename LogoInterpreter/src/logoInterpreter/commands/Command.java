package logoInterpreter.commands;

public interface Command extends Cloneable {
	void execute();

	boolean isTurtleCommand();
}