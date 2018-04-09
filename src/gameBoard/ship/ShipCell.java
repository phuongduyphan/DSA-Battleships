package gameBoard.ship;

import gameBoard.Coordinate;
import gameBoard.cell.Cell;
import gameBoard.cell.CellType;

public class ShipCell extends Cell {
	
	public ShipCell(Coordinate coordinate, CellType type) {
		super(coordinate);
		canChangeWhenIsShot = true;
		canChangeWhenIsSelected = false;
		this.type = type;
	}
	
	public ShipCell(Coordinate coordinate, Ship ship, CellType type) {
		this(coordinate,type);
		this.ship = ship; 
	}

	@Override
	public void actWhenIsSelected() {
		//TODO GUI
		System.out.println("Ship has already placed on cell" + coordinate);
	}

	@Override
	public void actWhenIsShot() {
		//TODO GUI
		ship.damage(coordinate);
	}

	public Ship getShip() {
		return ship;
	}

	public void setShip(Ship ship) {
		this.ship = ship;
	}
	
	
	
}
