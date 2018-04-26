package gameBoard.ship;

import java.util.logging.Level;

import gameBoard.Coordinate;
import gameBoard.cell.Cell;
import gameBoard.cell.CellType;
import log.Log;

public class ShipCell extends Cell {
	
	public ShipCell(Coordinate coordinate) {
		super(coordinate);
		canChangeWhenIsShot = true;
		canChangeWhenIsSelected = false;
		setType(CellType.SHIP);
		setNotation('S');
	}
	
	public ShipCell(Coordinate coordinate, Ship ship) {
		this(coordinate);
		this.ship = ship; 
	}

	@Override
	public void actWhenIsSelected() {
		//TODO GUI
		Log.logger.log(Level.INFO,"Ship has already placed on cell" + coordinate);
	}

	@Override
	public void actWhenIsShot() {
		//TODO GUI
		ship.removeFromList(coordinate);
	}

	public Ship getShip() {
		return ship;
	}

	public void setShip(Ship ship) {
		this.ship = ship;
	}
	
	
	
}
