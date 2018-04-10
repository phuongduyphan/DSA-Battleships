package gameBoard.cell;

import gameBoard.Coordinate;
import gameBoard.cell.Cell;

public class UnoccupiedCell extends Cell {
	public UnoccupiedCell(Coordinate coor) {
		super(coor);
		ship = null;
		canChangeWhenIsShot = false;
		canChangeWhenIsSelected = true;
		setType(CellType.UNOCCUPIED);
		setNotation('O');
	}

	@Override
	public void actWhenIsSelected() {
		//TODO GUI
	    System.out.println("Cell " + coordinate + " is now selected");
	}

	@Override
	public void actWhenIsShot() {
		//TODO GUI
	    setNotation('X');
	    System.out.println("Ship at " + coordinate + " is shot");
	}

}
