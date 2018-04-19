package gameBoard.ship;

import UI.Command;
import UI.IClickable;

public enum ShipType implements IClickable {
	AIRCRAFT_CARRIER, DESTROYER, SUBMARINE,BATTLESHIP,PATROL_BOAT;

	@Override
	public void onClick(Command targetCommand) {
		// TODO Auto-generated method stub
		
	}
}
