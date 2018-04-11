package gui;

import gameBoard.Coordinate;
import gameBoard.cell.Cell;
import gameBoard.ship.Ship;
import gameBoard.ship.ShipOrientation;

public class CommandStage2 extends Command {
    private Ship ship;
    private Cell cell;

    @Override
    public boolean isCompleted() {
        if (ship != null && cell != null) return true;
        return false;
    }

    @Override
    public void onFinished() {
        // Todo
    }

    public Ship getShip() { return ship; }

    public void setShip(Ship ship) { this.ship = ship; }

    public Cell getCell() { return cell; }

    public void setCell(Cell cell) { this.cell = cell; }
}
