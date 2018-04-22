package UI;

import gameBoard.cell.Cell;
import gameBoard.ship.ShipOrientation;
import gameBoard.ship.ShipType;
import gameStage.Stage2;

public class CommandStage2 extends Command {
	private ShipType shipType;
	private Cell cell;
	private ShipOrientation orientation;

	@Override
	public boolean isCompleted() {
		return (shipType != null && cell != null && orientation != null);
	}

	@Override
	public void onFinished() {
		// Todo
		((UIHandlerStage2) Stage2.getInstance().getUIHandler()).placeShip();
	}

	public ShipType getShipType() {
		return shipType;
	}

	public void setShipType(ShipType shipType) {
		this.shipType = shipType;
	}

	public Cell getCell() {
		return cell;
	}

	public void setCell(Cell cell) {
		this.cell = cell;
	}

	public ShipOrientation getOrientation() {
		return orientation;
	}

	public void setOrientation(ShipOrientation orientation) {
		this.orientation = orientation;
	}

}
