package gameBoard;

public class UnoccupiedCell extends Cell {

	
	public UnoccupiedCell(Coordinate coor) {
		super(coor);
		ship = null;
		canChangeWhenIsShot = false;
		canChangeWhenIsSelected = true;
	}

	@Override
	public boolean actWhenIsSelected() {
		return canChangeWhenIsSelected;
	}

	@Override
	public boolean actWhenIsShot() {
		//GUI SOMETHING
		return canChangeWhenIsShot;
	}

}
