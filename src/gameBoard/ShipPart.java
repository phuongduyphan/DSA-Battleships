package gameBoard;

public abstract class ShipPart {
    private Cell cell;
    private Ship ship;
    private ShipPartState state;

    public enum ShipPartState {ENABLED, DISABLED}
}
