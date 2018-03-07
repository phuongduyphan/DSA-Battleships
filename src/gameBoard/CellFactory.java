package gameBoard;

public class CellFactory {

	private static CellFactory instance;

	private CellFactory() {
		
	}
	
	public static CellFactory getInstance() {
		
		if (instance == null)
			instance = new CellFactory();
		
		return instance;
	}
	
	public Cell create(Coordinate coor, CellEnum type) {
		
		switch (type) {
		case SHIP:
			return new ShipCell(coor);
		case EXPLODED:
			return new ExplodedCell(coor);
		case UNOCCUPIED:
			return new UnoccupiedCell(coor);
		}
		
		return null;
	}
}
