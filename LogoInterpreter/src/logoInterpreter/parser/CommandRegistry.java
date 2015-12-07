package logoInterpreter.parser;

import java.util.HashMap;
import java.util.Scanner;

import logoInterpreter.commands.Command;
import logoInterpreter.commands.CommandFactory;
import logoInterpreter.commands.NotFoundCommand;

public class CommandRegistry {
	private HashMap<String, CommandFactory> commandFactoryByName = new HashMap<>();

	public void registerCommand(String name, CommandFactory factory) {
		commandFactoryByName.put(name, factory);
	}

	public Command getCommand(Scanner scanner) {
		String name = scanner.next();
		CommandFactory factory = commandFactoryByName.get(name);
		if (factory == null)
			return new NotFoundCommand(name);
		return factory.createCommand(scanner);
	}
}
