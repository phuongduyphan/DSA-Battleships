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
                return new AircraftCarrierShip(startCoordinate, direction);
            case BATTLESHIP:
                return new BattleshipShip(startCoordinate, direction);
            case DESTROYER:
                return new DestroyerShip(startCoordinate, direction);
            case SUBMARINE:
                return new SubmarineShip(startCoordinate, direction);
            case PATROL_BOAT:
                return new PatrolBoatShip(startCoordinate, direction);
			default:
			    return null;
        }
    }
}
