package gameBoard.player;

import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;

import UI.Command;
import UI.CommandStage3;
import gameBoard.Board;
import gameBoard.Configurations;
import gameBoard.Coordinate;
import gameBoard.cell.Cell;
import gameBoard.cell.CellType;
import gameBoard.ship.Ship;
import gameBoard.ship.ShipOrientation;
import gameBoard.ship.ShipType;
import gameBoard.weapon.Weapon;
import gameBoard.weapon.WeaponFactory;
import gameBoard.weapon.WeaponType;
import gameStage.Stage3;
import log.Log;

public class EasyMode extends Strategy {
	
	public void createHuman(HumanPlayer player) {
		player.setBoard(new Board(8,8));
		player.getBoard().setPlayer(player);
		
		ArrayList<Weapon> listWeaponOfHuman = new ArrayList<>();
		listWeaponOfHuman.add(WeaponFactory.getInstance().create(WeaponType.BULLET_SHOT,
				Configurations.numberOfColumns * Configurations.numberOfRows));
		listWeaponOfHuman.add(WeaponFactory.getInstance().create(WeaponType.ROCKET, 2));
		listWeaponOfHuman.add(WeaponFactory.getInstance().create(WeaponType.HORIZONTAL_BOMBING, 1));
		listWeaponOfHuman.add(WeaponFactory.getInstance().create(WeaponType.VERTICAL_BOMBING, 1));
		 
		player.setListOfWeapon(listWeaponOfHuman);
	}
	
	public void create() {
		super.getBot().setBoard(new Board(8, 8));
		super.getBot().getBoard().setPlayer(super.getBot());
		ArrayList<Weapon> listWeaponOfBot = new ArrayList<>();
		listWeaponOfBot.add(WeaponFactory.getInstance().create(WeaponType.BULLET_SHOT,
				Configurations.numberOfColumns * Configurations.numberOfRows));
		listWeaponOfBot.add(WeaponFactory.getInstance().create(WeaponType.HORIZONTAL_BOMBING, 1));
		listWeaponOfBot.add(WeaponFactory.getInstance().create(WeaponType.VERTICAL_BOMBING, 1));
		listWeaponOfBot.add(WeaponFactory.getInstance().create(WeaponType.ROCKET, 1));
		super.getBot().setListOfWeapon(listWeaponOfBot);

		placeShip();
		super.getBot().getBoard().displayBoard();
	}

	public void placeShip() {
		ArrayList<Coordinate> listOfAvailableCells = new ArrayList<>();
		ArrayList<ShipType> listOfShip = new ArrayList<>();
		listOfShip = initializeShip();

		while (listOfShip.size() != 0) {
			listOfAvailableCells = getListOfAvailableCells();
			int index = getRandomNumber(listOfAvailableCells.size());

			Coordinate coor = listOfAvailableCells.get(index);
			ShipType type = listOfShip.get(getRandomNumber(listOfShip.size()));
			ShipOrientation orientation;

			int orientTmp = getRandomNumber(2);
			if (orientTmp == 0) {
				orientation = ShipOrientation.HORIZONTAL;
			} else
				orientation = ShipOrientation.VERTICAL;

			if (super.getBot().getBoard().createShip(coor, orientation, type)) {
				listOfShip.remove(type);
			} else {
				if (orientation.equals(ShipOrientation.HORIZONTAL))
					orientation = ShipOrientation.VERTICAL;
				else
					orientation = ShipOrientation.HORIZONTAL;
				if (super.getBot().getBoard().createShip(coor, orientation, type)) {
					listOfShip.remove(type);
				}
			}
		}
	}

	public ArrayList<ShipType> initializeShip() {
		ArrayList<ShipType> listOfShip = new ArrayList<>();
		listOfShip.add(ShipType.AIRCRAFT_CARRIER);
		listOfShip.add(ShipType.BATTLESHIP);
		listOfShip.add(ShipType.DESTROYER);
		listOfShip.add(ShipType.SUBMARINE);
		listOfShip.add(ShipType.PATROL_BOAT);
		return listOfShip;
	}

	public ArrayList<Coordinate> getListOfAvailableCells() {
		ArrayList<Coordinate> listOfAvailableCells = new ArrayList<>();
		for (int i = 0; i < super.getBot().getBoard().getNumberOfRows(); i++) {
			for (int j = 0; j < super.getBot().getBoard().getNumberOfColumns(); j++) {
				if (super.getBot().getBoard().getCellAt(new Coordinate(i, j)).getType().equals(CellType.UNOCCUPIED)) {
					listOfAvailableCells.add(new Coordinate(i, j));
				}
			}
		}
		return listOfAvailableCells;
	}

	public int getRandomNumber(int x) {
		Random rand = new Random();
		return rand.nextInt(x);
	}

	public Player pickOpponent() {
		Random rand = new Random();
		int index = rand.nextInt(super.getBot().getListOfOpponents().size());
		return super.getBot().getListOfOpponents().get(index);
	}

	public Coordinate pickCoordinate() {
		super.getOpponent().getBoard().displayBoard();
		ArrayList<Coordinate> canShoot = new ArrayList<>();

		for (int i = 0; i < super.getOpponent().getBoard().getNumberOfRows(); i++) {
			for (int j = 0; j < super.getOpponent().getBoard().getNumberOfColumns(); j++) {
				Coordinate coor = new Coordinate(i, j);
				if (super.getOpponent().getBoard().getCellAt(coor).getType() != CellType.EXPLODED) {
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
		super.setOpponent(pickOpponent());
		super.setShootCoor(pickCoordinate());
		super.setWeapon(pickWeapon());

		CommandStage3 cmd = new CommandStage3();
		cmd.setTargetPlayer(super.getOpponent());
		cmd.setCell(super.getOpponent().getBoard().getCellAt(super.getShootCoor()));
		cmd.setWeapon(super.getWeapon());
		Stage3.getInstance().processInput(cmd);
	}

	public void update(ArrayList<Cell> listOfDestroyedCells, ArrayList<Ship> listOfDestroyedShips) {

	}

	@Override
	public void onClick(Command targetCommand) {
		// TODO Auto-generated method stub

	}
}
