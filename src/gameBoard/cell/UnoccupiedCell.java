package gameBoard.cell;

import java.util.logging.Level;

import gameBoard.Coordinate;
import gameBoard.cell.Cell;
import log.Log;

public class UnoccupiedCell extends Cell {
	public UnoccupiedCell(Coordinate coor) {
		super(coor);
		ship = null;
		canChangeWhenIsShot = true;
		canChangeWhenIsSelected = true;
		setType(CellType.UNOCCUPIED);
		setNotation('O');
	}

	@Override
	public void actWhenIsSelected() {
		//TODO GUI
	    Log.logger.log(Level.INFO,"Cell " + coordinate + " is now selected");
	}

	@Override
	public void actWhenIsShot() {
		//TODO GUI
	    Log.logger.log(Level.INFO,"Ship at " + coordinate + " is shot");
	}

}
