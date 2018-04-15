package gameBoard.ship;

import gameBoard.Coordinate;

public class DestroyerShip extends Ship {

	public DestroyerShip(Coordinate startCoor, ShipOrientation orientation,ShipType type) {
		super(startCoor, orientation, 3,type);
	}

	@Override
	public void setListOfShipParts() {
		// TODO Auto-generated method stub

	}

}
