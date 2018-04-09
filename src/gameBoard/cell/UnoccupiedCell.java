package gameBoard.cell;

import gameBoard.Coordinate;
import gameBoard.cell.Cell;

public class UnoccupiedCell extends Cell {
	public UnoccupiedCell(Coordinate coor, CellType type) {
		super(coor);
		ship = null;
		canChangeWhenIsShot = false;
		canChangeWhenIsSelected = true;
		this.type = type;
	}

	@Override
	public void actWhenIsSelected() {
		//TODO GUI
	}

	@Override
	public void actWhenIsShot() {
		//TODO GUI
	}

}
