package gameBoard;

public class ExplodedCell extends Cell {
	
	public ExplodedCell(Coordinate coor) {
		super(coor);
		ship = null;
		canChangeWhenIsShot = false;
		canChangeWhenIsSelected = false;
	}

	@Override
	public boolean actWhenIsSelected() {
		System.out.println("Cell" + coor + "cannot be selected");
		return canChangeWhenIsSelected;
	}

	@Override
	public boolean actWhenIsShot() {
		System.out.println("Cell" + coor + "cannot be shot");
		return canChangeWhenIsShot;
	}

}
