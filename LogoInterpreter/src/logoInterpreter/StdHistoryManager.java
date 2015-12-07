package logoInterpreter;

import java.util.Iterator;
import java.util.LinkedList;

import logoInterpreter.commands.Command;

public class StdHistoryManager implements HistoryManager {
	private final LogoInterpreter interpreter;
	
	public LinkedList<Command> commandList = new LinkedList<Command>();
	public int indexCommand = 0;
	
	public StdHistoryManager(LogoInterpreter interpreter) {
		this.interpreter = interpreter;
	}
	/**
	 * Fügt einen Command in die History ein. Dieser Command wird bereits im 
	 * LogoInterpreter ausgeführt, darf also hier nicht nochmals ausgeführt werden.
	 */
	@Override
	public void add(Command command) {
		// TODO Auto-generated method stub
		commandList.add(command);
		indexCommand++;
	}

	/**
	 * Leert die History.
	 */
	@Override
	public void clear() {
		// TODO Auto-generated method stub
		Iterator<Command> it = commandList.iterator();
		while(it.hasNext()) {
			it.remove();
			it.next();
		}

	}
	/**
	 * Macht einen Schritt in der History rückgängig. Gibt eine Meldung aus, 
	 * falls nichts rückgängig gemacht werden kann.
	 */
	@Override
	public void undo() {
		// TODO Auto-generated method stub
		if(commandList.getLast() != null) {
			Command undo = commandList.getLast();
			undo.execute();
			indexCommand--;
			
			}else{
				System.out.println("Undo nicht möglich.");
			}
	}

	/**
	 * Stellt einen Schritt in der History wieder her. Gibt eine Meldung aus, 
	 * falls kein Schritt wiederhergestellt werden kann.
	 */
	@Override
	public void redo() {
		// TODO Auto-generated method stub
		Command redo = commandList.get(indexCommand++);
		if(redo != null) {
			redo.execute();
		}else{
			System.out.println("Redo nicht möglich.");
		}

	}

	/**
	 * Gibt sämtliche bisherige Commands der History zurück. Wird vor allem 
	 * von der repaint()-Methode des LogoInterpreters verwendet.
	 */
	@Override
	public Iterable<Command> getCommands() {
		// TODO Auto-generated method stub
		return commandList;
	}

}
