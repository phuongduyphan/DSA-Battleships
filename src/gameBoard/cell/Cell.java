package gameBoard.cell;

import gameBoard.Coordinate;
import gameBoard.ship.Ship;

public abstract class Cell {

	protected Coordinate coordinate;
	protected Ship ship;
	protected boolean canChangeWhenIsShot;
	protected boolean canChangeWhenIsSelected;
	
	public Cell(Coordinate coordinate) {
		this.coordinate = coordinate;
	}
	
	public Coordinate getCoordinate() {
		return coordinate;
	}

	public Ship getShip() {
		return ship;
	}

	public void setShip(Ship ship) {
		this.ship = ship;
	}

	public void setCoordinate(Coordinate coordinate) {
		this.coordinate = coordinate;
	}

	
	public boolean getCanChangeWhenIsShot() {
		return canChangeWhenIsShot;
	}

	public boolean getCanChangeWhenIsSelected() {
		return canChangeWhenIsSelected;
	}

	public abstract void actWhenIsSelected();
	public abstract void actWhenIsShot();
	
}
