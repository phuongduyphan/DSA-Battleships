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

    public Ship create(Coordinate startCoordinate, ShipOrientation orientation, ShipType type) {
        switch (type) {
            case AIRCRAFT_CARRIER:
                return new AircraftCarrierShip(startCoordinate, orientation);
            case BATTLESHIP:
                return new BattleshipShip(startCoordinate, orientation);
            case DESTROYER:
                return new DestroyerShip(startCoordinate, orientation);
            case SUBMARINE:
                return new SubmarineShip(startCoordinate, orientation);
            case PATROL_BOAT:
                return new PatrolBoatShip(startCoordinate, orientation);
			default:
			    return null;
        }
    }
}
