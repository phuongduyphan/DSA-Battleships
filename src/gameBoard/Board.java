package gameBoard;
import gameBoard.cell.Cell;
import gameBoard.cell.CellFactory;
import gameBoard.cell.CellType;
import gameBoard.ship.Ship;
import gameBoard.ship.ShipCell;
import gameBoard.ship.ShipFactory;
import gameBoard.ship.ShipType;

import java.util.List;

public class Board {
	private Cell grid[][];
	private Integer row, col;
	private List<Ship> listOfShips;
	private CellFactory cellFactory = CellFactory.getInstance();
	private ShipFactory shipFactory = ShipFactory.getInstance();
	
	public Board(Integer row, Integer col) {
		this.row = row;
		this.col = col;
		grid = new Cell[row][col];
	}
	
	public Integer getRow() {
		return row;
	}

	public Integer getCol() {
		return col;
	}

	public void placeShipToBoard(Ship ship) {
		listOfShips.add(ship);
		
		for (Coordinate coor : ship.getListOfCoors()) {
			setCellAsType(coor, CellType.SHIP);
			((ShipCell) getCellAt(coor)).setShip(ship);
		}
	}
	
	public List<Ship> getListOfShips() {
		return listOfShips;
	}


	public void setCellAsType(Coordinate coor, CellType type) {
		Cell cell = getCellAt(coor);
		cell = cellFactory.create(coor, type);
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
	
	public boolean createShip(Coordinate startCoor, int direction, ShipType type) {
		
		Ship ship = shipFactory.create(startCoor, direction, type);
		
		for (Coordinate coor : ship.getListOfCoors()) {
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
}
