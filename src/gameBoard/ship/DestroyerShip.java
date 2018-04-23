package gameBoard.ship;

import gameBoard.Coordinate;

public class DestroyerShip extends Ship {

	public DestroyerShip(ShipType type) {
		super(type);
	}
	
	public DestroyerShip(Coordinate startCoor, ShipOrientation orientation,ShipType type) {
		super(startCoor, orientation, 4,type);
	}

	@Override
	public void setListOfShipParts() {
		// TODO Auto-generated method stub

	}

}
