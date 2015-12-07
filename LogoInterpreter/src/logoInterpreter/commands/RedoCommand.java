package logoInterpreter.commands;

import logoInterpreter.HistoryManager;

public class RedoCommand extends AbstractCommand {
	private final HistoryManager historyManager;

	public RedoCommand(HistoryManager historyManager) {
		super(false);
		this.historyManager = historyManager;
	}

	@Override
	public void execute() {
		historyManager.redo();
	}

	public String toString() {
		return "Redoing command...";
	}
}
