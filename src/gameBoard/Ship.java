package gameBoard;
import java.util.ArrayList;

public abstract class Ship {
	private Coordinate startCoor;
	private ArrayList<Coordinate> listOfCoors = new ArrayList<>();
	
	public Ship(Coordinate startCoor) {
		this.startCoor = startCoor;
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
