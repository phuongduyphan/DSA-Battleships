package gameBoard.cell;

import gameBoard.Coordinate;
import gameBoard.ship.Ship;
import gui.Command;
import gui.CommandStage2;
import gui.CommandStage3;
import gui.IClickable;

public abstract class Cell implements IClickable {

	protected Coordinate coordinate;
	protected Ship ship;
	protected boolean canChangeWhenIsShot;
	protected boolean canChangeWhenIsSelected;
	protected CellType type;
	
	public CellType getType() {
		return type;
	}

	public void setType(CellType type) {
		this.type = type;
	}

	public Cell(Coordinate coordinate) {
		this.coordinate = coordinate;
	}
	
	public Coordinate getCoordinate() {
		return coordinate;
	}

	public Ship getShip() {
		return ship;
	}

	public void setShip(Ship ship) {
		this.ship = ship;
	}

	public void setCoordinate(Coordinate coordinate) {
		this.coordinate = coordinate;
	}

	
	public boolean getCanChangeWhenIsShot() {
		return canChangeWhenIsShot;
	}

	public boolean getCanChangeWhenIsSelected() {
		return canChangeWhenIsSelected;
	}

	public abstract void actWhenIsSelected();
	public abstract void actWhenIsShot();

    @Override
    public void onClick(Command targetCommand) {
        if(targetCommand instanceof CommandStage2) {
            CommandStage2 cmd2 = (CommandStage2)targetCommand;
            cmd2.setCell(this);
        } else if(targetCommand instanceof CommandStage3) {
            CommandStage3 cmd3 = (CommandStage3)targetCommand;
            cmd3.setCell(this);
        } else throw new Error("In Cell.java, onClick(), the targetCmd is not the right type of Cmd to be used with Cell");
    }
}
