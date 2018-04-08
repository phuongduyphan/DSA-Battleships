package gameBoard.player;
import java.util.ArrayList;

import gameBoard.Board;
import gameBoard.Coordinate;
import gameBoard.weapon.Weapon;

public class BotPlayer extends Player {
	private Strategy mode;
	
	public BotPlayer(Board board, ArrayList<Weapon> listOfWeapon,Strategy mode) {
		super(board, listOfWeapon);
		this.mode = mode;
	}

	@Override
	public void play() {
		// TODO implement DSA
		//mode.runMode();
	}
}
