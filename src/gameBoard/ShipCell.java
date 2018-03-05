package gameBoard;

public class ShipCell extends Cell {
	
	public ShipCell(Coordinate coor) {
		super(coor);
		canChangeWhenIsShot = true;
		canChangeWhenIsSelected = false;
	}
	
	public ShipCell(Coordinate coor, Ship ship) {
		this(coor);
		this.ship = ship; 
	}

	@Override
	public boolean actWhenIsSelected() {
		System.out.println("Ship has already placed on cell" + coor);
		return canChangeWhenIsSelected;
	}

	@Override
	public boolean actWhenIsShot() {
		ship.damage(coor);
		
		return canChangeWhenIsShot;
	}

	public Ship getShip() {
		return ship;
	}

	public void setShip(Ship ship) {
		this.ship = ship;
	}
	
	
	
}
