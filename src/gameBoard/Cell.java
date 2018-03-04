package gameBoard;

import gui.IClickable;

public class Cell implements IClickable{
    private Coordinate coordinate;
    private ShipPart shipPart;

    public Cell(Coordinate coordinate, ShipPart shipPart) {
        this.coordinate = coordinate;
        this.shipPart = shipPart;
    }

    @Override
    public void onClick() {
        // TODO: Implement
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public ShipPart getShipPart() {
        return shipPart;
    }
}
