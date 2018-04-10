package gameBoard.ship;

import gameBoard.Coordinate;
import gameBoard.cell.Cell;
import gameBoard.cell.CellType;

public class ShipCell extends Cell {
	
	public ShipCell(Coordinate coordinate) {
		super(coordinate);
		canChangeWhenIsShot = true;
		canChangeWhenIsSelected = false;
		setType(CellType.SHIP);
	}
	
	public ShipCell(Coordinate coordinate, Ship ship) {
		this(coordinate);
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
