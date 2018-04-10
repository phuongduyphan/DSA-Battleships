package gameBoard.cell;

import gameBoard.Coordinate;
import gameBoard.ship.ShipCell;

public class CellFactory {

    private static CellFactory instance;

    private CellFactory() {

    }

    public static CellFactory getInstance() {

        if (instance == null)
            instance = new CellFactory();

        return instance;
    }

    public Cell create(Coordinate coordinate, CellType type) {
        switch (type) {
            case SHIP:
                return new ShipCell(coordinate);
            case EXPLODED:
                return new ExplodedCell(coordinate);
            case UNOCCUPIED:
                return new UnoccupiedCell(coordinate);
            default:
                return null;
        }
    }
}
