package logoInterpreter.commands;

import logoInterpreter.MacroManager;

public class EndMacroCommand extends AbstractCommand {
	private final MacroManager macroManager;

	public EndMacroCommand(MacroManager macroManager) {
		super(false);
		this.macroManager = macroManager;
	}

	@Override
	public void execute() {
		macroManager.endMacro();
	}
	
	public String toString() {
		return "Ending macro recording.";
	}
}
