package gameBoard;
import java.util.List;
import java.util.Observable;

public class Board extends Observable {
	private Cell grid[][];
	private Integer row, col;
	private List<Ship> listOfShips;
	private CellFactory cellFactory = new CellFactory();
	
	public Board(Integer row, Integer col) {
		this.row = row;
		this.col = col;
		grid = new Cell[row][col];
	}
	
	public void boardChanged() {
		setChanged();
		notifyObservers();
	}
	
	public void placeShip(Ship ship) {
		listOfShips.add(ship);
		
		for (Coordinate coor : ship.getListOfCoors()) {
			setCellAsType(coor, "SHIP");
			((ShipCell) getCellAt(coor)).setShip(ship);
		}
	}
	
	public void setCellAsType(Coordinate coor, String type) {
		Cell cell = getCellAt(coor);
		cell = cellFactory.create(coor, type);
		boardChanged();
	}
	
//	public void setExplodedCell(Coordinate coor) {
//		grid[coor.getRow()][coor.getCol()] = new ExplodedCell(coor);
//		boardChanged();
//	}
//	
//	public void setShipCell(Coordinate coor, Ship ship) {
//		grid[coor.getRow()][coor.getCol()] = new ShipCell(coor, ship);
//		boardChanged();
//	}
//	
//	public void setShipCell(List<Coordinate> listOfCoors, Ship ship) {
//		for (Coordinate coor : listOfCoors)
//			setShipCell(coor, ship);
//	}
	
	public Cell getCellAt(Coordinate coor) {
		return grid[coor.getRow()][coor.getCol()];
	}
	
	public boolean createShip(Coordinate startCoor, String type) {
		
		Ship ship = ShipFactory.create(startCoor, type);
		
		for (Coordinate coor : ship.getListOfCoors()) {
			boolean canChangeWhenIsSelected = getCellAt(coor).actWhenIsSelected();
			if (!canChangeWhenIsSelected) {
				System.out.println("Cannot place ship here");
				ship = null;
				return false;
			}
		}
		
		placeShip(ship);
		return true;
	}
}
