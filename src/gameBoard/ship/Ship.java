
package gameBoard.ship;

import gameBoard.Coordinate;
import java.util.ArrayList;
import UI.Command;
import UI.IClickable;

public abstract class Ship implements IClickable {
	private Coordinate startCoordinate;
	private ShipOrientation orientation;
	private ArrayList<Coordinate> listOfCoors = new ArrayList<>();
	//TODO verify data type of listOfShipParts
//	private ArrayList<Image> listOfShipParts;
	private int length;
	private ShipType type;
	
	public Ship(Coordinate startCoordinate, ShipOrientation orientation) {
		this.startCoordinate = startCoordinate;
		this.orientation = orientation;
	}	
	
	public Ship(Coordinate startCoordinate, ShipOrientation orientation, int length, ShipType type) {
		this.startCoordinate = startCoordinate;
		this.orientation = orientation;
		this.length = length;
		this.type = type;
		appendCoorToList();
//		setListOfShipParts();
	}

	public void removeFromList(Coordinate coor) {
		
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
		
		Integer startRow = startCoordinate.getRow();
		Integer startCol = startCoordinate.getCol();
		
		switch (orientation) {
		case VERTICAL:
			appendCoorsVertically(startRow, startCol);
			break;
		case HORIZONTAL:
			appendCoorsHorizontally(startRow, startCol);
			break;
		default:
			System.out.println("Wrong orientation");	
		}
		
	}
	
	private void appendCoorsVertically(Integer startRow, Integer startCol) {
		for (int row = startRow; row < startRow + length; row++) {
			listOfCoors.add(new Coordinate(row, startCol));
		}	
	}
	private void appendCoorsHorizontally(Integer startRow, Integer startCol) {
		for (int col = startCol; col < startCol + length; col++) {
		listOfCoors.add(new Coordinate(startRow, col));
	}
	}
	
	@Override
	public void onClick(Command targetCommand) {
//		if(targetCommand instanceof CommandStage2) {
//			CommandStage2 cmd2 = (CommandStage2)targetCommand;
//			cmd2.setShip(this);
//		} else throw new Error("In Ship.java, onClick(), the targetCmd is not the right type of Cmd to be used with Ship");
	}

	public Coordinate getStartCoordinate() {
		return startCoordinate;
	}

	public ShipOrientation getOrientation() {
		return orientation;
	}

	public int getLength() {
		return length;
	}

	public ShipType getType() {
		return type;
	}

}

