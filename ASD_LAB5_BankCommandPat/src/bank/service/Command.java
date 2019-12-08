package bank.service;

import java.util.ArrayList;
import java.util.Collection;


public class Command {

	private Collection<ICommand> commandlist = new ArrayList<ICommand>();
	private Collection<ICommand> undolist = new ArrayList<ICommand>();

	public void undo(){	
		if (commandlist.size()>0){
		ICommand commandObject = (ICommand)((ArrayList<ICommand>)commandlist).get(commandlist.size()-1);
		((ArrayList<ICommand>)commandlist).remove(commandObject);
		commandObject.undo();
		undolist.add(commandObject);
		}
	}

	public void redo(){
		if (undolist.size()>0){
		ICommand commandObject = (ICommand)((ArrayList<ICommand>)undolist).get(undolist.size()-1);
		commandObject.execute();
		((ArrayList<ICommand>)undolist).remove(commandObject);
		commandlist.add(commandObject);
		}
	}

	public void addCommand(ICommand commandObject){
		commandlist.add(commandObject);
	}

}