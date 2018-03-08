package gameBoard;

import gameBoard.player.Player;

public class Turn {
	private Player player;
	public Turn nextTurn;
	
	public Turn(Player player) {
		this.player = player;
	}
	
	public Turn(Player player, Turn nextTurn) {
		this.player = player;
		this.nextTurn = nextTurn;
	}
	
	public void setNextTurn(Turn nextTurn) {
		this.nextTurn = nextTurn;
	}
	
	public void setNextTurnInGameHanler() {
		GameHandler.getInstance().setCurrentTurn(nextTurn);
	}
	
	public Player getPlayer() {
		return player;
	}
}
