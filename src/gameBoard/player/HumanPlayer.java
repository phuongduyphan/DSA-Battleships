package gameBoard.player;

import java.util.ArrayList;
import gameBoard.Board;
import gameBoard.weapon.Weapon;
import gui.ConsoleInputHandler;

public class HumanPlayer extends Player{
	
	public HumanPlayer(Board board, ArrayList<Weapon> listOfWeapon) {
		super(board, listOfWeapon);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void play() {
		// TODO Auto-generated method stub
		ConsoleInputHandler.getInstance().enable();
	}
}
