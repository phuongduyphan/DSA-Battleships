package gameBoard.player;

import java.util.ArrayList;
import java.util.Random;

import UI.Command;
import UI.CommandStage3;
import gameBoard.Board;
import gameBoard.Configurations;
import gameBoard.Coordinate;
import gameBoard.cell.CellType;
import gameBoard.ship.ShipOrientation;
import gameBoard.ship.ShipType;
import gameBoard.weapon.Weapon;
import gameBoard.weapon.WeaponFactory;
import gameBoard.weapon.WeaponType;
import gameStage.Stage3;

public class EasyMode extends Strategy{
	
	public void create() {
		super.getBot().setBoard(new Board(8,8));
		super.getBot().getBoard().createShip(new Coordinate(3, 3), ShipOrientation.VERTICAL, ShipType.PATROL_BOAT);
		ArrayList<Weapon> listWeaponOfBot = new ArrayList<>();
		listWeaponOfBot.add(WeaponFactory.getInstance().create(WeaponType.BULLET_SHOT,
				Configurations.numberOfColumns * Configurations.numberOfRows));
		listWeaponOfBot.add(WeaponFactory.getInstance().create(WeaponType.HORIZONTAL_BOMBING, 100));
		super.getBot().setListOfWeapon(listWeaponOfBot);
	}
	
	public Player pickOpponent() {
		Random rand = new Random();
		System.out.print(super.getBot().getListOfOpponents().size());
		int index = rand.nextInt(super.getBot().getListOfOpponents().size());
		return super.getBot().getListOfOpponents().get(index);
	}
	
	public Coordinate pickCoordinate(Player opponent) {
		opponent.getBoard().displayBoard();
		ArrayList<Coordinate> canShoot = new ArrayList<>();
		
		for (int i = 0; i < opponent.getBoard().getNumberOfRows(); i++) {
			for (int j=0; j< opponent.getBoard().getNumberOfColumns(); j++) {
				Coordinate coor = new Coordinate(i,j);
				if (opponent.getBoard().getCellAt(coor).getType() != CellType.EXPLODED) {
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
		System.out.print(opponent.getBoard().getCellAt(coor));
		Weapon weapon = pickWeapon();
		System.out.print(weapon);
		
		CommandStage3 cmd = new CommandStage3();
		cmd.setTargetPlayer(opponent);
		cmd.setCell(opponent.getBoard().getCellAt(coor));
		cmd.setWeapon(weapon);
		Stage3.getInstance().processInput(cmd);
	}

	@Override
	public void onClick(Command targetCommand) {
		// TODO Auto-generated method stub
		
	}
}

