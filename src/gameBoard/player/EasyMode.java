package gameBoard.player;

import gameBoard.Coordinate;
import gameBoard.GameHandler;
import gameBoard.weapon.Weapon;
import gui.Command;
import gui.CommandStage3;
import gui.ConsoleInputHandler;

public class EasyMode implements Strategy{
	public Player pickOpponent() {
		
	}
	
	public Coordinate pickCoordinate() {
		
	}
	
	public Weapon pickWeapon() {
		
	}
	
	public void runMode() {
		Player opponent = pickOpponent();
		Coordinate coor = pickCoordinate();
		Weapon weapon = pickWeapon();
		
		ConsoleInputHandler.getInstance().setCmd(new CommandStage3());
		ConsoleInputHandler.getInstance().updateCommand(3, opponent);
		ConsoleInputHandler.getInstance().updateCommand(3, opponent.getBoard().getCellAt(coor));
		ConsoleInputHandler.getInstance().updateCommand(3, weapon);
		GameHandler.getInstance().input(ConsoleInputHandler.getInstance().getCmd());
	}
}

