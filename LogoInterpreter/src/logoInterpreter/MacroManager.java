package logoInterpreter;


import logoInterpreter.commands.Command;

public interface MacroManager{
	public boolean isRecordingMacro();
	public void handleCommand(Command command);
	public void startMacro(String name);
	public Command getCommand(String name);
	public void endMacro();
}

