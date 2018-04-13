package gameBoard.player;

import java.util.ArrayList;

import UI.consoleUI.ConsoleInputHandler;
import gameBoard.Board;
import gameBoard.weapon.Weapon;
import gameStage.Stage3;

public class HumanPlayer extends Player{
	
	public HumanPlayer(Board board, ArrayList<Weapon> listOfWeapon) {
		super(board, listOfWeapon);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void play() {
		// TODO Auto-generated method stub
		//ConsoleInputHandler.getInstance().enable();
		Stage3.getInstance().getUIHandler().enableInput();
	}
}
