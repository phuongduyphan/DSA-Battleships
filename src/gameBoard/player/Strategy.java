package gameBoard.player;

import java.util.ArrayList;

import UI.IClickable;
import gameBoard.Coordinate;
import gameBoard.cell.Cell;
import gameBoard.ship.Ship;
import gameBoard.weapon.Weapon;

public abstract class Strategy implements IClickable {
	private BotPlayer bot;
	private Player opponent;
	private Coordinate shootCoor;
	private Weapon weapon;
	
	public void setBot(BotPlayer bot) {
		this.bot = bot;
	}
	
	public BotPlayer getBot() {
		return bot;
	}
	
	public abstract void create();
	public abstract Player pickOpponent();
	public abstract Coordinate pickCoordinate(); 
	public abstract Weapon pickWeapon();
	public abstract void runMode();
	public abstract void update(ArrayList<Cell> listOfDestroyedCells, ArrayList<Ship> listOfDestroyedShips);

	public Player getOpponent() {
		return opponent;
	}

	public void setOpponent(Player opponent) {
		this.opponent = opponent;
	}

	public Coordinate getShootCoor() {
		return shootCoor;
	}

	public void setShootCoor(Coordinate shootCoor) {
		this.shootCoor = shootCoor;
	}

	public Weapon getWeapon() {
		return weapon;
	}

	public void setWeapon(Weapon weapon) {
		this.weapon = weapon;
	}	

}
