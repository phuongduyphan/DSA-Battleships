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
	public void actWhenIsSelected() {
		//TODO GUI
		System.out.println("Ship has already placed on cell" + coor);
	}

	@Override
	public void actWhenIsShot() {
		//TODO GUI
		ship.damage(coor);
	}

	public Ship getShip() {
		return ship;
	}

	public void setShip(Ship ship) {
		this.ship = ship;
	}
	
	
	
}
