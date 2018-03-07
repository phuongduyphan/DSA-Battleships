package gameBoard;

public class ShipFactory {
	private static ShipFactory instance;

	private ShipFactory() {

	}

	public static ShipFactory getInstance() {
		if (instance == null) {
			instance = new ShipFactory();
		}
		return instance;
	}

	public Ship create(Coordinate startCoor, int direction, ShipType type) {
		switch (type) {
		case AIRCRAFT_CARRIER:
			return new aircraftCarrierShip(startCoor, direction);
		case BATTLESHIP:
			return new battleshipShip(startCoor, direction);
		case DESTROYER:
			return new destroyerShip(startCoor, direction);
		case SUBMARINE:
			return new submarineShip(startCoor, direction);
		case PATROL_BOAT:
			return new patrolBoatShip(startCoor, direction);
		}
		return null;
	}
}
