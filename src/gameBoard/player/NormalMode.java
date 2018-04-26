package gameBoard.player;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.logging.Level;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter.DEFAULT;

import UI.Command;
import UI.CommandStage3;
import gameBoard.Board;
import gameBoard.Configurations;
import gameBoard.Coordinate;
import gameBoard.cell.Cell;
import gameBoard.cell.CellType;
import gameBoard.ship.Ship;
import gameBoard.ship.ShipFactory;
import gameBoard.ship.ShipOrientation;
import gameBoard.ship.ShipType;
import gameBoard.weapon.Weapon;
import gameBoard.weapon.WeaponFactory;
import gameBoard.weapon.WeaponType;
import gameStage.Stage3;
import log.Log;

public class NormalMode extends Strategy {
	private boolean huntingMode;
	private ArrayList<Ship> listOfRemainingShips;
	private int[][] flagBoard;
	private int[][] stateBoard;
	private int numberOfHuntingMode;

	public void createHuman(HumanPlayer player) {
		player.setBoard(new Board(8, 8));
		player.getBoard().setPlayer(player);

		ArrayList<Weapon> listWeaponOfHuman = new ArrayList<>();
		listWeaponOfHuman.add(WeaponFactory.getInstance().create(WeaponType.BULLET_SHOT,
				Configurations.numberOfColumns * Configurations.numberOfRows));

		player.setListOfWeapon(listWeaponOfHuman);
	}

	public void create() {
		super.getBot().setBoard(new Board(8, 8));
		super.getBot().getBoard().setPlayer(super.getBot());
		ArrayList<Weapon> listWeaponOfBot = new ArrayList<>();
		listWeaponOfBot.add(WeaponFactory.getInstance().create(WeaponType.BULLET_SHOT,
				Configurations.numberOfColumns * Configurations.numberOfRows));
		super.getBot().setListOfWeapon(listWeaponOfBot);

		placeShip();
		super.getBot().getBoard().displayBoard();
		huntingMode = true;
		flagBoard = new int[Configurations.numberOfRows][Configurations.numberOfColumns];
		stateBoard = new int[Configurations.numberOfRows][Configurations.numberOfColumns];
		listOfRemainingShips = new ArrayList<>();
		listOfRemainingShips.add(ShipFactory.getInstance().create(ShipType.AIRCRAFT_CARRIER));
		listOfRemainingShips.add(ShipFactory.getInstance().create(ShipType.BATTLESHIP));
		listOfRemainingShips.add(ShipFactory.getInstance().create(ShipType.DESTROYER));
		listOfRemainingShips.add(ShipFactory.getInstance().create(ShipType.SUBMARINE));
		listOfRemainingShips.add(ShipFactory.getInstance().create(ShipType.PATROL_BOAT));
		numberOfHuntingMode = 0;
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
		return Configurations.listOfPlayer.get(0);
	}

	public Coordinate pickCoordinate() {
		ArrayList<Coordinate> listOfPotentialCoor = new ArrayList<>();
		if (huntingMode) {
			numberOfHuntingMode++;
			if (numberOfHuntingMode <= 3) {
				pickRandomCoordinate(listOfPotentialCoor);
			} else {
				setFlagBoard();
				pickPriorityCoordinate(listOfPotentialCoor);
			}
		} else {
			boolean[][] visitBoard = new boolean[Configurations.numberOfRows][Configurations.numberOfColumns];
			int shootLength = -1;
			shootLength = searchHorizontalDirection(listOfPotentialCoor, visitBoard, shootLength);
			shootLength = searchVerticalDirection(listOfPotentialCoor, visitBoard, shootLength);
		}
		return listOfPotentialCoor.get(getRandomNumber(listOfPotentialCoor.size()));
	}

	private int searchVerticalDirection(ArrayList<Coordinate> listOfPotentialCoor, boolean[][] visitBoard,
			int shootLength) {
		initializeVisitBoard(visitBoard);
		for (int i = 0; i < Configurations.numberOfRows; i++) {
			for (int j = 0; j < Configurations.numberOfColumns; j++) {
				int length = 0;
				for (int k = i; k < Configurations.numberOfRows; k++) {
					if (stateBoard[k][j] != 2 || visitBoard[k][j])
						break;
					else {
						length++;
						visitBoard[k][j] = true;
					}
				}
				if (length > 0 && length < getMaxLengthOfShips()) {
					int expandLength = 0;
					for (int k = i - 1; k >= 0; k--) {
						if (stateBoard[k][j] != 0 && stateBoard[k][j] != 2)
							break;
						else
							expandLength++;
					}
					for (int k = i + length; k < Configurations.numberOfRows; k++) {
						if (stateBoard[k][j] != 0 && stateBoard[k][j] != 2)
							break;
						else
							expandLength++;
					}
					if (length + expandLength >= getMinLengthOfShips() && length >= shootLength) {

						if (checkRange(new Coordinate(i - 1, j)) && stateBoard[i - 1][j] == 0) {
							if (length > shootLength)
								listOfPotentialCoor.clear();
							shootLength = length;
							listOfPotentialCoor.add(new Coordinate(i - 1, j));
						}
						if (checkRange(new Coordinate(i + length, j)) && stateBoard[i + length][j] == 0) {
							if (length > shootLength)
								listOfPotentialCoor.clear();
							shootLength = length;
							listOfPotentialCoor.add(new Coordinate(i + length, j));
						}
					}
				}
			}
		}
		return shootLength;
	}

	private int searchHorizontalDirection(ArrayList<Coordinate> listOfPotentialCoor, boolean[][] visitBoard,
			int shootLength) {
		initializeVisitBoard(visitBoard);
		for (int i = 0; i < Configurations.numberOfRows; i++) {
			for (int j = 0; j < Configurations.numberOfColumns; j++) {
				int length = 0;
				for (int k = j; k < Configurations.numberOfColumns; k++) {
					if (stateBoard[i][k] != 2 || visitBoard[i][k])
						break;
					else {
						length++;
						visitBoard[i][k] = true;
					}
				}
				if (length > 0 && length < getMaxLengthOfShips()) {
					int expandLength = 0;
					for (int k = j - 1; k >= 0; k--) {
						if (stateBoard[i][k] != 0 && stateBoard[i][k] != 2)
							break;
						else
							expandLength++;
					}
					for (int k = j + length; k < Configurations.numberOfColumns; k++) {
						if (stateBoard[i][k] != 0 && stateBoard[i][k] != 2)
							break;
						else
							expandLength++;
					}
					if (length + expandLength >= getMinLengthOfShips() && length >= shootLength) {
						if (checkRange(new Coordinate(i, j - 1)) && stateBoard[i][j - 1] == 0) {
							if (length > shootLength)
								listOfPotentialCoor.clear();
							shootLength = length;
							listOfPotentialCoor.add(new Coordinate(i, j - 1));
						}
						if (checkRange(new Coordinate(i, j + length)) && stateBoard[i][j + length] == 0) {
							if (length > shootLength)
								listOfPotentialCoor.clear();
							shootLength = length;
							listOfPotentialCoor.add(new Coordinate(i, j + length));
						}
					}
				}
			}
		}
		return shootLength;
	}

	private void pickPriorityCoordinate(ArrayList<Coordinate> listOfPotentialCoor) {
		int maxFlagCoor = -1;

		for (int i = 0; i < Configurations.numberOfRows; i++) {
			for (int j = 0; j < Configurations.numberOfColumns; j++) {
				if (flagBoard[i][j] > maxFlagCoor) {
					maxFlagCoor = flagBoard[i][j];
				}
			}
		}
		ArrayList<Coordinate> listTemp = new ArrayList<>();
		int maxDist = -1;
		for (int i = 0; i < Configurations.numberOfRows; i++) {
			for (int j = 0; j < Configurations.numberOfColumns; j++) {
				if (flagBoard[i][j] == maxFlagCoor)
					listTemp.add(new Coordinate(i, j));
			}
		}
		for (int i = 0; i < listTemp.size(); i++) {
			int currentMinDist = findMinimumDistance(listTemp.get(i));
			if (currentMinDist >= maxDist) {
				if (currentMinDist > maxDist)
					listOfPotentialCoor.clear();
				maxDist = currentMinDist;
				listOfPotentialCoor.add(listTemp.get(i));
			}
		}
	}

	private void pickRandomCoordinate(ArrayList<Coordinate> listOfPotentialCoor) {
		for (int i = 0; i < Configurations.numberOfRows; i++) {
			for (int j = 0; j < Configurations.numberOfColumns; j++) {
				if (stateBoard[i][j] == 0)
					listOfPotentialCoor.add(new Coordinate(i, j));
			}
		}
	}

	public void initializeVisitBoard(boolean[][] visitBoard) {
		for (int i = 0; i < Configurations.numberOfRows; i++) {
			for (int j = 0; j < Configurations.numberOfColumns; j++) {
				visitBoard[i][j] = false;
			}
		}
	}

	public boolean checkRange(Coordinate coor) {
		return coor.getRow() < Configurations.numberOfRows && coor.getCol() < Configurations.numberOfColumns
				&& coor.getRow() >= 0 && coor.getCol() >= 0;
	}

	public void setFlagBoard() {
		int maxLength = getMaxLengthOfShips();
		for (int i = 0; i < Configurations.numberOfRows; i++) {
			for (int j = 0; j < Configurations.numberOfColumns; j++) {
				flagBoard[i][j] = 0;
			}
		}

		for (int i = 0; i < Configurations.numberOfRows; i++) {
			for (int j = 0; j < Configurations.numberOfColumns; j++) {
				for (int orientation = 0; orientation < 4; orientation++) {
					if (checkValidFlag(i, j, orientation, maxLength) && stateBoard[i][j] == 0) {
						flagBoard[i][j]++;
					}
				}
			}
		}
		displayBoard(flagBoard);
	}

	public int getMaxLengthOfShips() {
		int res = -1;
		for (int i = 0; i < listOfRemainingShips.size(); i++) {
			if (listOfRemainingShips.get(i).getLength() > res)
				res = listOfRemainingShips.get(i).getLength();
		}
		return res;
	}

	public int getMinLengthOfShips() {
		int res = Integer.MAX_VALUE;
		for (int i = 0; i < listOfRemainingShips.size(); i++) {
			if (listOfRemainingShips.get(i).getLength() < res)
				res = listOfRemainingShips.get(i).getLength();
		}
		return res;
	}

	public boolean checkValidFlag(int row, int col, int orientation, int length) {
		switch (orientation) {
		case 0:
			if (super.getBot().getBoard().checkRange(new Coordinate(row, col + length - 1))) {
				for (int i = col + 1; i < col + length; i++) {
					if (stateBoard[row][i] != 0)
						return false;
				}
				return true;
			}
			return false;
		case 1:
			if (super.getBot().getBoard().checkRange(new Coordinate(row + length - 1, col))) {
				for (int i = row + 1; i < row + length; i++) {
					if (stateBoard[i][col] != 0)
						return false;
				}
				return true;
			}
			return false;
		case 2:
			if (super.getBot().getBoard().checkRange(new Coordinate(row, col - length + 1))) {
				for (int i = col - 1; i > col - length; i--) {
					if (stateBoard[row][i] != 0)
						return false;
				}
				return true;
			}
			return false;
		case 3:
			if (super.getBot().getBoard().checkRange(new Coordinate(row - length + 1, col))) {
				for (int i = row - 1; i > row - length; i--) {
					if (stateBoard[i][col] != 0)
						return false;
				}
				return true;
			}
			return false;
		default:
			return false;
		}
		
	}

	public int findMinimumDistance(Coordinate coor) {
		int[] hDir = { 0, 1, 0, -1 };
		int[] vDir = { 1, 0, -1, 0 };
		boolean[][] visitBoard = new boolean[Configurations.numberOfRows][Configurations.numberOfColumns];
		initializeVisitBoard(visitBoard);
		Queue<Coordinate> que = new LinkedList<>();
		Queue<Integer> dist = new LinkedList<>();
		que.add(coor);
		dist.add(0);
		visitBoard[coor.getRow()][coor.getCol()] = true;

		while (que.peek() != null) {
			int curRow = que.peek().getRow();
			int curCol = que.peek().getCol();
			int curDist = dist.peek();
			que.remove();
			dist.remove();

			for (int i = 0; i <= 3; i++) {
				int row = curRow + hDir[i];
				int col = curCol + vDir[i];
				if (checkRange(new Coordinate(row, col)) && !visitBoard[row][col]) {
					if (stateBoard[row][col] != 0)
						return curDist + 1;
					visitBoard[row][col] = true;
					que.add(new Coordinate(row, col));
					dist.add(curDist + 1);
				}
			}
		}
		return Integer.MAX_VALUE;
	}

	public Weapon pickWeapon() {
		return super.getBot().getListOfWeapon().get(getRandomNumber(super.getBot().getListOfWeapon().size()));
	}

	public void runMode() {
		displayBoard(stateBoard);
		super.setOpponent(pickOpponent());
		super.setShootCoor(pickCoordinate());
		super.setWeapon(pickWeapon());

		CommandStage3 cmd = new CommandStage3();
		cmd.setTargetPlayer(super.getOpponent());
		cmd.setCell(super.getOpponent().getBoard().getCellAt(super.getShootCoor()));
		cmd.setWeapon(super.getWeapon());
		Stage3.getInstance().processInput(cmd);
	}

	// 0: not shot
	// 1: exploded
	// 2: ship exploded
	public void update(ArrayList<Cell> listOfDestroyedCells, ArrayList<Ship> listOfDestroyedShips) {
		for (Cell cell : listOfDestroyedCells) {
			if (cell.getType().equals(CellType.SHIP)) {
				stateBoard[cell.getCoordinate().getRow()][cell.getCoordinate().getCol()] = 2;
			} else {
				if (stateBoard[cell.getCoordinate().getRow()][cell.getCoordinate().getCol()] != 2)
					stateBoard[cell.getCoordinate().getRow()][cell.getCoordinate().getCol()] = 1;
			}
		}

		for (Ship ship : listOfDestroyedShips) {
			for (Ship remainingShip : listOfRemainingShips) {
				if (ship.getType().equals(remainingShip.getType())) {
					listOfRemainingShips.remove(remainingShip);
					break;
				}
			}
			for (Coordinate coor : ship.getListOfFixedCoors()) {
				stateBoard[coor.getRow()][coor.getCol()] = 1;
			}
		}
		displayBoard(stateBoard);
		updateHuntingMode();
	}

	public void updateHuntingMode() {
		for (int i = 0; i < Configurations.numberOfRows; i++) {
			for (int j = 0; j < Configurations.numberOfColumns; j++) {
				if (stateBoard[i][j] == 2) {
					huntingMode = false;
					return;
				}
			}
		}
		huntingMode = true;
	}

	public void displayBoard(int[][] board) {
		String msg = "\n";
		for (int i = 0; i < Configurations.numberOfRows; i++) {
			for (int j = 0; j < Configurations.numberOfColumns; j++) {
				msg += board[i][j] + " ";
			}
			msg += "\n";
		}
		Log.logger.log(Level.INFO, msg);
	}

	public void setHuntingMode(boolean huntingMode) {
		this.huntingMode = huntingMode;
	}

	@Override
	public void onClick(Command targetCommand) {
		// TODO Auto-generated method stub

	}

	public int[][] getStateBoard() {
		return stateBoard;
	}
}
