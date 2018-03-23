package gameBoard;
import gameBoard.cell.Cell;
import gameBoard.cell.CellFactory;
import gameBoard.cell.CellType;
import gameBoard.cell.ExplodedCell;
import gameBoard.cell.UnoccupiedCell;
import gameBoard.ship.Ship;
import gameBoard.ship.ShipCell;
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
		Cell shotCell = getCellAt(coor);
		shotCell.actWhenIsShot();
	
		if (shotCell.getCanChangeWhenIsShot()) {
			setCellAsType(coor, CellType.EXPLODED);
		}
	}
	
//	public void setExplodedCell(Coordinate coordinate) {
//		grid[coordinate.getRow()][coordinate.getCol()] = new ExplodedCell(coordinate);
//	}
//	
//	public void setShipCell(Coordinate coordinate, Ship ship) {
//		grid[coordinate.getRow()][coordinate.getCol()] = new ShipCell(coordinate, ship);
//	}
//	
//	public void setShipCell(List<Coordinate> listOfCoors, Ship ship) {
//		for (Coordinate coordinate : listOfCoors)
//			setShipCell(coordinate, ship);
//	}
	
	public Cell getCellAt(Coordinate coor) {
		return grid[coor.getRow()][coor.getCol()];
	}
	
	private boolean checkRange(Coordinate coor) {
		
		return coor.getRow() < numberOfRows && coor.getCol() < numberOfColumns
				&& coor.getRow() >= 0 && coor.getCol() >= 0;
	}
	
	public boolean createShip(Coordinate startCoor, ShipOrientation orientation, ShipType type) {
		
		Ship ship = shipFactory.create(startCoor, orientation, type);
		
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
		
		placeShipToBoard(ship);
		return true;
	}

	public void displayBoard() {
    	for (int i = 0; i < numberOfRows; i++) {
    		for (int j = 0; j < numberOfColumns; j++) {
    			Cell cell = getCellAt(new Coordinate(i, j));
    			
    			if (cell instanceof ShipCell)
    				System.out.print("S ");
    			else if (cell instanceof ExplodedCell)
    				System.out.print("X ");
    			else if (cell instanceof UnoccupiedCell)
    				System.out.print("O ");
    		}
    		System.out.println("");
    	}
	}
}