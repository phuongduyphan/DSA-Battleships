package gameBoard.ship;

import gameBoard.Coordinate;

public class AircraftCarrierShip extends Ship {
	
	public AircraftCarrierShip(ShipType type) {
		super(type,5);
	}
	
	public AircraftCarrierShip(Coordinate startCoor, ShipOrientation orientation,ShipType type) {
		super(startCoor, orientation, 5,type);
	}

	@Override
	public void setListOfShipParts() {
		// TODO Auto-generated method stub

	}

}
