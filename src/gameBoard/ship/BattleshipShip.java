package gameBoard.ship;

import gameBoard.Coordinate;

public class BattleshipShip extends Ship {
	
	public BattleshipShip(ShipType type) {
		super(type);
	}
	
	public BattleshipShip(Coordinate startCoor, ShipOrientation orientation,ShipType type) {
		super(startCoor, orientation, 3,type);		
	}

	@Override
	public void setListOfShipParts() {
		// TODO Auto-generated method stub

	}


}
