package logoInterpreter.parser;

import java.util.Scanner;

import logoInterpreter.commands.Command;

public class Parser {
	private CommandRegistry registry;

	public Parser(CommandRegistry registry) {
		this.registry = registry;
	}

	public Command parse(Scanner scanner) {
		return registry.getCommand(scanner);
	}
}