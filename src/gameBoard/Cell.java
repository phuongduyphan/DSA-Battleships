<<<<<<< HEAD
=======
package gameBoard;

public abstract class Cell {

	protected Coordinate coor;
	protected Ship ship;
	protected boolean canChangeWhenIsShot;
	protected boolean canChangeWhenIsSelected;
	
	public Cell(Coordinate coor) {
		this.coor = coor;
	}
	
	public Coordinate getCoor() {
		return coor;
	}

	public Ship getShip() {
		return ship;
	}

	public void setShip(Ship ship) {
		this.ship = ship;
	}

	public void setCoor(Coordinate coor) {
		this.coor = coor;
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
>>>>>>> Chau
