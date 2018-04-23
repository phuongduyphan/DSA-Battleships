package gameBoard.ship;

import gameBoard.Coordinate;

public class SubmarineShip extends Ship {

	public SubmarineShip(ShipType type) {
		super(type);
	}
	
	public SubmarineShip(Coordinate startCoor, ShipOrientation orientation,ShipType type) {
		super(startCoor, orientation, 3,type);
	}

	@Override
	public void setListOfShipParts() {
		// TODO Auto-generated method stub

	}

}
