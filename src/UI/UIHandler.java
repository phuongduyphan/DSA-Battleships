package UI;

import java.util.ArrayList;

import gameBoard.cell.Cell;

public abstract class UIHandler {
	protected Command cmd;
	protected UI currentUI;
	
	public abstract void enableInput();
	public abstract void display(Command cmd,ArrayList<Cell> listOfExplosion);
	public abstract void updateCommand(IClickable i);
	
	public void setCmd(Command cmd) {
		this.cmd = cmd;
	}
}
