package gameBoard;

import java.util.ArrayList;

public abstract class Ship {

    private Integer numberOfShipParts;
    private ArrayList<ShipPart> shipParts;

    public abstract ArrayList<Coordinate> getRelativeCoordinates(Coordinate coordinate);
    public void addShipPart(ShipPart o) {
        shipParts.add(o);
    }
}
