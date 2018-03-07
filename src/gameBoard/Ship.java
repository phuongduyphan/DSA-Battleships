
package gameBoard;
import java.awt.Image;
import java.util.ArrayList;

public abstract class Ship {
	private Coordinate startCoor;
	private int direction;
	private ArrayList<Coordinate> listOfCoors = new ArrayList<>();
	//TODO verify data type of listOfShipParts
	private ArrayList<Image> listOfShipParts;
	
	public Ship(Coordinate startCoor, int direction) {
		this.startCoor = startCoor;
		this.direction = direction;
		appendCoorToList();
	}	
	
	public void damage(Coordinate coor) {
		
		int indexToRemove = listOfCoors.indexOf(coor);
		
		listOfCoors.remove(indexToRemove);
//		listOfShipParts.remove(indexToRemove);
		
		//TODO GUI
	}
	
	public ArrayList<Coordinate> getListOfCoors() {
		return listOfCoors;
	}

	public abstract void setListOfShipParts();
	public abstract void appendCoorToList();
}

