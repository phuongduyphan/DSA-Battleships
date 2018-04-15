package gameBoard.ship;

import gameBoard.Coordinate;

public class BattleshipShip extends Ship {
	
	public BattleshipShip(Coordinate startCoor, ShipOrientation orientation,ShipType type) {
		super(startCoor, orientation, 4,type);		
	}

	@Override
	public void setListOfShipParts() {
		// TODO Auto-generated method stub

	}


}
