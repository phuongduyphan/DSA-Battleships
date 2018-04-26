package gameBoard.cell;

import java.util.logging.Level;

import gameBoard.Coordinate;
import gameBoard.cell.Cell;
import log.Log;

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
		Log.logger.log(Level.INFO,"Cell" + coordinate + "cannot be selected");
	}

	@Override
	public void actWhenIsShot() {
		//TODO GUI
		Log.logger.log(Level.INFO,"Cell" + coordinate + "cannot be shot");
	}

}
