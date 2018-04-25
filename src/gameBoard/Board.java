package gameBoard;

import gameBoard.cell.Cell;
import gameBoard.cell.CellFactory;
import gameBoard.cell.CellType;
import gameBoard.player.Player;
import gameBoard.ship.Ship;
import gameBoard.ship.ShipFactory;
import gameBoard.ship.ShipOrientation;
import gameBoard.ship.ShipType;

import java.util.ArrayList;
import java.util.List;

public class Board {
	private Cell grid[][];
	private Integer numberOfRows, numberOfColumns;
	private List<Ship> listOfShips = new ArrayList<>();
	private CellFactory cellFactory = CellFactory.getInstance();
	private ShipFactory shipFactory = ShipFactory.getInstance();
	private ArrayList<Cell> listOfTargetableCells = new ArrayList<>();
	private ArrayList<Ship> listOfDestroyedShips = new ArrayList<>();
	private ArrayList<Cell> listOfDestroyedCells = new ArrayList<>();
	private Player player;

	public Board(Integer row, Integer col) {
		this.numberOfRows = row;
		this.numberOfColumns = col;
		grid = new Cell[row][col];

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				Coordinate coor = new Coordinate(i, j);
				setCellAsType(coor, CellType.UNOCCUPIED);
			}
		}
	}

	public Integer getNumberOfRows() {
		return numberOfRows;
	}

	public Integer getNumberOfColumns() {
		return numberOfColumns;
	}

	public void placeShipToBoard(Ship ship) {
		listOfShips.add(ship);

		for (Coordinate coor : ship.getListOfCoors()) {
			setCellAsType(coor, CellType.SHIP);
			getCellAt(coor).setShip(ship);
		}
	}

	public List<Ship> getListOfShips() {
		return listOfShips;
	}

	public void setCellAsType(Coordinate coor, CellType type) {
		grid[coor.getRow()][coor.getCol()] = (Cell) cellFactory.create(coor, type);
	}

	public void shootAt(Coordinate coor) {
		if (checkRange(coor) && getCellAt(coor).getType() != CellType.EXPLODED)
		    listOfTargetableCells.add(getCellAt(coor));
//		if (checkRange(coor)) {
//			Cell shotCell = getCellAt(coor);
//			shotCell.actWhenIsShot();
//
//			if (shotCell.getCanChangeWhenIsShot()) {
//				Ship ship = shotCell.getShip();
//				if (ship.getListOfCoors().isEmpty())
//					listOfShips.remove(ship);
//
//				setCellAsType(coor, CellType.EXPLODED);
//			}
//		} else {
//			System.out.println("Cannot Shoot - Boundary exceeded " + coor);
//		}
	    
	    if (checkRange(coor)) {
	    	listOfDestroyedCells.add(getCellAt(coor));
	        Cell targetCell = getCellAt(coor);
	        targetCell.actWhenIsShot();
	        
	        if (targetCell.getCanChangeWhenIsShot()) {
	            
	            if (targetCell.getType().equals(CellType.SHIP)) {
	                Ship ship = targetCell.getShip();
	                if (ship.getListOfCoors().isEmpty()) {
	                	listOfDestroyedShips.add(ship);
	                    listOfShips.remove(ship);
	                }
	            }
	            
	            setCellAsType(coor, CellType.EXPLODED);
	        }
	        
	    }
	    
	}

	// public void setExplodedCell(Coordinate coordinate) {
	// grid[coordinate.getRow()][coordinate.getCol()] = new
	// ExplodedCell(coordinate);
	// }
	//
	// public void setShipCell(Coordinate coordinate, Ship ship) {
	// grid[coordinate.getRow()][coordinate.getCol()] = new ShipCell(coordinate,
	// ship);
	// }
	//
	// public void setShipCell(List<Coordinate> listOfCoors, Ship ship) {
	// for (Coordinate coordinate : listOfCoors)
	// setShipCell(coordinate, ship);
	// }

	public Cell getCellAt(Coordinate coor) {
		return grid[coor.getRow()][coor.getCol()];
	}

	public boolean checkRange(Coordinate coor) {

		return coor.getRow() < numberOfRows && coor.getCol() < numberOfColumns && coor.getRow() >= 0
				&& coor.getCol() >= 0;
	}

	public boolean createShip(Coordinate startCoor, ShipOrientation orientation, ShipType type) {

		Ship ship = shipFactory.create(startCoor, orientation, type);

		if (canPlaceShip(startCoor, orientation, ship)) placeShipToBoard(ship);
		else return false;
		
		return true;
	}
	
	public boolean canPlaceShip(Coordinate startCoor, ShipOrientation orientation, Ship ship) {
		for (Coordinate coor : ship.getListOfCoors()) {

			if (!checkRange(coor)) {
				System.out.println("Boundary exceeded: " + startCoor);
				ship = null;
				return false;
			}

			Cell cell = getCellAt(coor);
			cell.actWhenIsSelected();

			if (!cell.getCanChangeWhenIsSelected()) {
				System.out.println("Cannot place ship here");
				ship = null;
				return false;
			}

		}
		return true;
	}

	public void displayBoard() {
	    System.out.println("");
		for (int i = 0; i < numberOfRows; i++) {
			for (int j = 0; j < numberOfColumns; j++) {
				Cell cell = getCellAt(new Coordinate(i, j));
//				System.out.print(cell.getType() + " ");
				cell.display();

				// if (cell instanceof ShipCell)
				// System.out.print("S ");
				// else if (cell instanceof ExplodedCell)
				// System.out.print("X ");
				// else if (cell instanceof UnoccupiedCell)
				// System.out.print("O ");
			}
			System.out.println("");
		}
	}

	public ArrayList<Cell> getListOfTargetableCells() {
		return listOfTargetableCells;
	}

	public void clearListOfTargetableCells() {
		listOfTargetableCells.clear();
	}

	public ArrayList<Ship> getListOfDestroyedShips() {
		return listOfDestroyedShips;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public ArrayList<Cell> getListOfDestroyedCells() {
		return listOfDestroyedCells;
	}
	
	public void clearListOfDestroyedCells() {
		listOfDestroyedCells.clear();
	}
	
	public void clearListOfDestroyedShips() {
		listOfDestroyedShips.clear();
	}
}