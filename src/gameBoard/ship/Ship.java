
package gameBoard.ship;
import gameBoard.Coordinate;
import gui.Command;
import gui.CommandStage2;
import gui.IClickable;
import java.util.ArrayList;

public abstract class Ship implements IClickable {
	private Coordinate startCoordinate;
	private ShipOrientation orientation;
	private ArrayList<Coordinate> listOfCoors = new ArrayList<>();
	//TODO verify data type of listOfShipParts
//	private ArrayList<Image> listOfShipParts;
	private int length;
	
	public Ship(Coordinate startCoordinate, ShipOrientation orientation) {
		this.startCoordinate = startCoordinate;
		this.orientation = orientation;
	}	
	
	public Ship(Coordinate startCoordinate, ShipOrientation orientation, int length) {
		this.startCoordinate = startCoordinate;
		this.orientation = orientation;
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
		
		Integer startRow = startCoordinate.getRow();
		Integer startCol = startCoordinate.getCol();
		
		switch (orientation) {
		case NORTH:
			appendCoorsInNorthDirection(startRow, startCol);
			break;
		case SOUTH:
			appendCoorsInSouthDirection(startRow, startCol);
			break;
		case EAST:
			appendCoorsInEastDirection(startRow, startCol);
			break;
		case WEST:
			appendCoorsInWestDirection(startRow, startCol);
			break;
		default:
			System.out.println("Wrong orientation");	
		}
		
	}
	
	private void appendCoorsInNorthDirection(Integer startRow, Integer startCol) {
		for (int row = startRow; row < startRow + length; row++) {
			listOfCoors.add(new Coordinate(row, startCol));
		}	
	}
	
	private void appendCoorsInSouthDirection(Integer startRow, Integer startCol) {
		for (int row = startRow; row > startRow - length; row--) {
			listOfCoors.add(new Coordinate(row, startCol));
		}
	}
	
	private void appendCoorsInEastDirection(Integer startRow, Integer startCol) {
		for (int col = startCol; col < startCol + length; col++) {
		listOfCoors.add(new Coordinate(startRow, col));
	}
	}
	
	private void appendCoorsInWestDirection(Integer startRow, Integer startCol) {
		for (int col = startCol; col > startCol - length; col--) {
		listOfCoors.add(new Coordinate(startRow, col));
	}
	}
	
	@Override
	public void onClick(Command targetCommand) {
		if(targetCommand instanceof CommandStage2) {
			CommandStage2 cmd2 = (CommandStage2)targetCommand;
			cmd2.setShip(this);
		} else throw new Error("In Ship.java, onClick(), the targetCmd is not the right type of Cmd to be used with Ship");
	}
}

