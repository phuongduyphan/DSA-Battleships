package gameBoard.ship;

import gameBoard.Coordinate;

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

    public Ship create(Coordinate startCoordinate, int direction, ShipType type) {
        switch (type) {
            case AIRCRAFT_CARRIER:
                return new aircraftCarrierShip(startCoordinate, direction);
            case BATTLESHIP:
                return new battleshipShip(startCoordinate, direction);
            case DESTROYER:
                return new destroyerShip(startCoordinate, direction);
            case SUBMARINE:
                return new submarineShip(startCoordinate, direction);
            case PATROL_BOAT:
                return new patrolBoatShip(startCoordinate, direction);
			default:
			    return null;
        }
    }
}
