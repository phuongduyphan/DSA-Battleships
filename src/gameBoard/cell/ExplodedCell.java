package gameBoard.cell;

import gameBoard.Coordinate;
import gameBoard.cell.Cell;

public class ExplodedCell extends Cell {
	
	public ExplodedCell(Coordinate coordinate) {
		super(coordinate);
		ship = null;
		canChangeWhenIsShot = false;
		canChangeWhenIsSelected = false;
		setType(CellType.EXPLODED);
		setNotation('X');
	}

	@Override
	public void actWhenIsSelected() {
		//TODO GUI
		System.out.println("Cell" + coordinate + "cannot be selected");
	}

	@Override
	public void actWhenIsShot() {
		//TODO GUI
		System.out.println("Cell" + coordinate + "cannot be shot");
	}

}
