package gameBoard.player;

import java.util.ArrayList;
import java.util.Random;

import UI.consoleUI.Command;
import UI.consoleUI.CommandStage3;
import UI.consoleUI.ConsoleInputHandler;
import gameBoard.Coordinate;
import gameBoard.GameHandler;
import gameBoard.cell.CellType;
import gameBoard.weapon.Weapon;

public class EasyMode extends Strategy{
	public Player pickOpponent() {
		Random rand = new Random();
		System.out.print(super.getBot().getListOfOpponents().size());
		int index = rand.nextInt(super.getBot().getListOfOpponents().size());
		return super.getBot().getListOfOpponents().get(index);
	}
	
	public Coordinate pickCoordinate(Player opponent) {
		ArrayList<Coordinate> canShoot = new ArrayList<>();
		
		for (int i = 0; i < opponent.getBoard().getNumberOfRows(); i++) {
			for (int j=0; j< opponent.getBoard().getNumberOfColumns(); j++) {
				Coordinate coor = new Coordinate(i,j);
				if (opponent.getBoard().getCellAt(coor).getType() == CellType.UNOCCUPIED) {
					canShoot.add(coor);
				}
			}
		}
		
		Random rand = new Random();
		int index = rand.nextInt(canShoot.size());
		return canShoot.get(index);
	}
	
	public Weapon pickWeapon() {
		Random rand = new Random();
		int index = rand.nextInt(super.getBot().getListOfWeapon().size());
		return super.getBot().getListOfWeapon().get(index);
	}
	
	public void runMode() {
		Player opponent = pickOpponent();
		System.out.print(opponent);
		Coordinate coor = pickCoordinate(opponent);
		System.out.print(coor);
		Weapon weapon = pickWeapon();
		System.out.print(weapon);
		
		ConsoleInputHandler.getInstance().setCmd(new CommandStage3());
		ConsoleInputHandler.getInstance().updateCommand(3, opponent);
		ConsoleInputHandler.getInstance().updateCommand(3, opponent.getBoard().getCellAt(coor));
		ConsoleInputHandler.getInstance().updateCommand(3, weapon);
		GameHandler.getInstance().input(ConsoleInputHandler.getInstance().getCmd());
	}
}

