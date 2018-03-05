package gameBoard;

public class CellFactory {


	public CellFactory() {
	}
	
	public Cell create(Coordinate coor, String type) {
		
		if (type == "SHIP")
			return new ShipCell(coor);
		else if (type == "UNOCCUPIED")
			return new UnoccupiedCell(coor);
		else if (type == "EXPLODED")
			return new ExplodedCell(coor);
		
		
		return null;
	}
}
