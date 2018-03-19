
package gameBoard.ship;
import gameBoard.Coordinate;
import gui.Command;
import gui.CommandStage2;
import gui.IClickable;

import java.awt.Image;
import java.util.ArrayList;

public abstract class Ship implements IClickable {
	private Coordinate startCoordinate;
	private ShipOrientation orientation;
	private ArrayList<Coordinate> listOfCoors = new ArrayList<>();
	//TODO verify data type of listOfShipParts
	private ArrayList<Image> listOfShipParts;
	
	public Ship(Coordinate startCoordinate, ShipOrientation orientation) {
		this.startCoordinate = startCoordinate;
		this.orientation = orientation;
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

	@Override
	public void onClick(Command targetCommand) {
		if(targetCommand instanceof CommandStage2) {
			CommandStage2 cmd2 = (CommandStage2)targetCommand;
			cmd2.setShip(this);
		} else throw new Error("In Ship.java, onClick(), the targetCmd is not the right type of Cmd to be used with Ship");
	}
}

