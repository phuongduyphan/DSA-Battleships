package gameBoard.ship;

import gameBoard.Coordinate;

public class PatrolBoatShip extends Ship {

	public PatrolBoatShip(ShipType type) {
		super(type);
	}
	
	public PatrolBoatShip(Coordinate startCoor, ShipOrientation orientation,ShipType type) {
		super(startCoor, orientation, 2,type);
	}

	@Override
	public void setListOfShipParts() {
		// TODO Auto-generated method stub

	}

}
