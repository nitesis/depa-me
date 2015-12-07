package logoInterpreter.commands;

import logoInterpreter.MacroManager;

public class BeginMacroCommand extends AbstractCommand {
	private final MacroManager macroManager;
	private final String macroName;

	public BeginMacroCommand(String macroName, MacroManager macroManager) {
		super(false);
		this.macroManager = macroManager;
		this.macroName = macroName;
	}

	@Override
	public void execute() {
		macroManager.startMacro(macroName);
	}
	
	public String toString() {
		return "Begin macro " + macroName + ".";
	}

}
