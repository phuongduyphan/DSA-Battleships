package gameBoard.player;

import gameBoard.Board;

public class HumanPlayer extends Player{
	
	public HumanPlayer(Board board) {
		super(board);
	}

	@Override
	public void play() {
		// TODO Auto-generated method stub
		super.getInputHandler().readInputFromPlayer(this);
	}
}
