package gameBoard;
import java.util.ArrayList;

public abstract class Ship {
	private Coordinate startCoor;
	private int direction;
	private ArrayList<Coordinate> listOfCoors = new ArrayList<>();
	//TODO verify data type of listOfShipParts
	private ArrayList<Image> listOfShipParts = new ArrayList<>();
	
	public Ship(Coordinate startCoor, int direction) {
		this.startCoor = startCoor;
		this.direction = direction;
		appendCoorToList();
	}	
	
	public void damage(Coordinate coor) {
		listOfCoors.remove(coor);
		//GUI SOMETHING
	}
	
	public ArrayList<Coordinate> getListOfCoors() {
		return listOfCoors;
	}

	public abstract void appendCoorToList();
}
