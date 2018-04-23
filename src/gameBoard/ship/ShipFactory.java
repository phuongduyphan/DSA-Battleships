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
                return new AircraftCarrierShip(startCoordinate, orientation,ShipType.AIRCRAFT_CARRIER);
            case BATTLESHIP:
                return new BattleshipShip(startCoordinate, orientation,ShipType.BATTLESHIP);
            case DESTROYER:
                return new DestroyerShip(startCoordinate, orientation,ShipType.DESTROYER);
            case SUBMARINE:
                return new SubmarineShip(startCoordinate, orientation,ShipType.SUBMARINE);
            case PATROL_BOAT:
                return new PatrolBoatShip(startCoordinate, orientation,ShipType.PATROL_BOAT);
			default:
			    return null;
        }
    }
    
    public Ship create(ShipType type) {
        switch (type) {
            case AIRCRAFT_CARRIER:
                return new AircraftCarrierShip(ShipType.AIRCRAFT_CARRIER);
            case BATTLESHIP:
                return new BattleshipShip(ShipType.BATTLESHIP);
            case DESTROYER:
                return new DestroyerShip(ShipType.DESTROYER);
            case SUBMARINE:
                return new SubmarineShip(ShipType.SUBMARINE);
            case PATROL_BOAT:
                return new PatrolBoatShip(ShipType.PATROL_BOAT);
			default:
			    return null;
        }
    }
}
