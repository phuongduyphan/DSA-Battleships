package gameBoard;
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
	
	
	public void placeShipToBoard(Ship ship) {
		listOfShips.add(ship);
		
		for (Coordinate coor : ship.getListOfCoors()) {
			setCellAsType(coor, CellEnum.SHIP);
			((ShipCell) getCellAt(coor)).setShip(ship);
		}
	}
	
	public void setCellAsType(Coordinate coor, CellEnum type) {
		Cell cell = getCellAt(coor);
		cell = cellFactory.create(coor, type);
	}
	
//	public void setExplodedCell(Coordinate coor) {
//		grid[coor.getRow()][coor.getCol()] = new ExplodedCell(coor);
//	}
//	
//	public void setShipCell(Coordinate coor, Ship ship) {
//		grid[coor.getRow()][coor.getCol()] = new ShipCell(coor, ship);
//	}
//	
//	public void setShipCell(List<Coordinate> listOfCoors, Ship ship) {
//		for (Coordinate coor : listOfCoors)
//			setShipCell(coor, ship);
//	}
	
	public Cell getCellAt(Coordinate coor) {
		return grid[coor.getRow()][coor.getCol()];
	}
	
	public boolean createShip(Coordinate startCoor, int direction, ShipEnum type) {
		
		Ship ship = ShipFactory.create(startCoor, direction, type);
		
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
