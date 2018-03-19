
package gameBoard.ship;
import gameBoard.Coordinate;

import java.awt.Image;
import java.util.ArrayList;

public abstract class Ship {
	protected Coordinate startCoor;
	protected DirectionType direction;
	protected ArrayList<Coordinate> listOfCoors = new ArrayList<>();
	protected int length;
	//TODO verify data type of listOfShipParts
	private ArrayList<Image> listOfShipParts;
	
	public Ship(Coordinate startCoor, DirectionType direction) {
		this.startCoor = startCoor;
		this.direction = direction;
	}
	
	public Ship(Coordinate startCoor, DirectionType direction, int length) {
		this.startCoor = startCoor;
		this.direction = direction;
		this.length = length;
		appendCoorToList();
//		setListOfShipParts();
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
	public void appendCoorToList() {
		Integer startRow = startCoor.getRow();
		Integer startCol = startCoor.getCol();
		if (direction.equals(DirectionType.HORIZONTAL)) {
			for (int col = startCol; col < startCol + length; col++) {
				listOfCoors.add(new Coordinate(startRow, col));
			}
		} else if (direction.equals(DirectionType.VERTICAL)) {
			for (int row = startRow; row < startRow + length; row++) {
				listOfCoors.add(new Coordinate(row, startCol));
			}
			
		}
	}
}

