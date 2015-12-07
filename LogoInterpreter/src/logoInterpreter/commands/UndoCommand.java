package logoInterpreter.commands;

import logoInterpreter.HistoryManager;

public class UndoCommand extends AbstractCommand {
	private final HistoryManager historyManager;

	public UndoCommand(HistoryManager historyManager) {
		super(false);
		this.historyManager = historyManager;
	}

	@Override
	public void execute() {
		historyManager.undo();
	}
	
	public String toString() {
		return "Undoing command...";
	}

}
