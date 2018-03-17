package gameBoard.player;

import gameBoard.Board;
import gui.InputHandler;

public class HumanPlayer extends Player{
	
	public HumanPlayer(Board board) {
		super(board);
	}

	@Override
	public void play() {
		// TODO Auto-generated method stub
		InputHandler.getInstance().readInputFromPlayer(this);
	}
}
