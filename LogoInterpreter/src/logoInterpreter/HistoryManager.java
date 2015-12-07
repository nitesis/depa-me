package logoInterpreter;

import logoInterpreter.commands.Command;

public interface HistoryManager {
	public void add(Command command);
	public void clear();
	public void undo();
	public void redo();
	public Iterable<Command> getCommands();
}
