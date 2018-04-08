package gameBoard.player;

import gameBoard.Coordinate;
import gameBoard.weapon.Weapon;

public interface Strategy {
	public Player pickOpponent();
	public Coordinate pickCoordinate(); 
	public Weapon pickWeapon();
	public void runMode();
}
