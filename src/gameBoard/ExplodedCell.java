package gameBoard;

public class ExplodedCell extends Cell {
	
	public ExplodedCell(Coordinate coor) {
		super(coor);
		ship = null;
		canChangeWhenIsShot = false;
		canChangeWhenIsSelected = false;
	}

	@Override
	public void actWhenIsSelected() {
		//TODO GUI
		System.out.println("Cell" + coor + "cannot be selected");
	}

	@Override
	public void actWhenIsShot() {
		//TODO GUI
		System.out.println("Cell" + coor + "cannot be shot");
	}

}
