package logoInterpreter;

import java.awt.Color;
import java.util.Scanner;

import logoInterpreter.commands.BeginMacroCommand;
import logoInterpreter.commands.ClearScreenCommand;
import logoInterpreter.commands.Command;
import logoInterpreter.commands.EndMacroCommand;
import logoInterpreter.commands.ExitCommand;
import logoInterpreter.commands.MoveCommand;
import logoInterpreter.commands.NotFoundCommand;
import logoInterpreter.commands.PenDownCommand;
import logoInterpreter.commands.PenUpCommand;
import logoInterpreter.commands.RedoCommand;
import logoInterpreter.commands.RepeatCommand;
import logoInterpreter.commands.RotateCommand;
import logoInterpreter.commands.UndoCommand;
import logoInterpreter.parser.CommandRegistry;
import logoInterpreter.parser.Parser;

public class LogoInterpreter {
	private Turtles turtles;

	private HistoryManager historyManager;

	private MacroManager macroManager;

	public HistoryManager getHistoryManager() {
		return historyManager;
	}

	private Parser parser;

	public LogoInterpreter() {
		turtles = new Turtles();
		historyManager = new StdHistoryManager(this);
		macroManager = new StdMacroManager(this);
		System.out.println("Starting interpreter...");
	}

	public static void main(final String[] args) {
		new LogoInterpreter().startParsing();
	}

	private boolean running;

	public void stop() {
		running = false;
	}

	public void repaint() {
		resetTurtle();
		turtles.setColor(Color.BLACK);;
		for(Command c : historyManager.getCommands()) {
			c.execute();
		}
	}
	
	public void setColor(Color c) {
		turtles.setColor(c);
	}
	
	public void startParsing() {
		turtles.show();

		initializeParser();
		resetTurtle();
		Scanner scanner = new Scanner(System.in);
		running = true;
		while (running) {
			Command command = parser.parse(scanner);
			if (macroManager.isRecordingMacro()) {
				if(command.isTurtleCommand()) {
					macroManager.handleCommand(command);
				} else if(command instanceof EndMacroCommand) {
					command.execute();
				} else {
					System.out.println("Can not use command in macro!");
				}
			} else {
				if (command.isTurtleCommand()) {
					historyManager.add(command);
				}
				System.out.println("" + command);
				command.execute();
			}
		}
		scanner.close();
		turtles.quit();
	}

	private void initializeParser() {
		CommandRegistry commandRegistry = new CommandRegistry();
		commandRegistry.registerCommand("backward", scanner -> {
			int backward = scanner.nextInt();
			return new MoveCommand(turtles, -backward);
		});
		commandRegistry.registerCommand("forward", scanner -> {
			int forward = scanner.nextInt();
			return new MoveCommand(turtles, forward);
		});
		commandRegistry.registerCommand("left", scanner -> {
			int left = scanner.nextInt();
			return new RotateCommand(turtles, left);
		});
		commandRegistry.registerCommand("right", scanner -> {
			int right = scanner.nextInt();
			return new RotateCommand(turtles, -right);
		});
		commandRegistry.registerCommand("exit", scanner -> {
			return new ExitCommand(this);
		});
		commandRegistry.registerCommand("clearscreen", scanner -> {
			return new ClearScreenCommand(this);
		});
		commandRegistry.registerCommand("penup", scannner -> {
			return new PenUpCommand(turtles);
		});
		commandRegistry.registerCommand("pendown", scannner -> {
			return new PenDownCommand(turtles);
		});
		commandRegistry.registerCommand("repeat", scanner -> {
			int amount = scanner.nextInt();
			return new RepeatCommand(amount, parser.parse(scanner));
		});
		commandRegistry.registerCommand("undo", scanner -> {
			return new UndoCommand(historyManager);
		});
		commandRegistry.registerCommand("redo", scanner -> {
			return new RedoCommand(historyManager);
		});
		commandRegistry.registerCommand("macrorecord", scanner -> {
			String name = scanner.next();
			return new BeginMacroCommand(name, macroManager);
		});
		commandRegistry.registerCommand("macrosave", scanner -> {
			return new EndMacroCommand(macroManager);
		});
		commandRegistry.registerCommand("macrorun", scanner -> {
			String name = scanner.next();
			try {
				return macroManager.getCommand(name);
			} catch (Exception e) {
				e.printStackTrace();
				// return relatively gracefully
				return new NotFoundCommand("");
			}
		});

		// todo: implement undo, redo, macros
		parser = new Parser(commandRegistry);
	}

	public void resetTurtle() {
		turtles.moveTo(200, 200);
		turtles.clear();
		turtles.setDirection(90);
		turtles.down();
	}
}
