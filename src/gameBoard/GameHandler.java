package gameBoard;

import gameBoard.player.Player;

import java.util.ArrayList;

/// TODO: consider turning of singleton for this class, make every instance is created for each game

public class GameHandler {
	private static GameHandler instance;
	private Player currentPlayer;

	private GameHandler(ArrayList<Player> players) {
		// TODO: GameHandler constructor
	}

	public void nextTurn() {
        currentPlayer = currentPlayer.getNextPlayer();
        currentPlayer.play();
    }
	
	public static GameHandler getInstance() {
		if (instance == null) {
			instance = new GameHandler();
		}
		return instance;
	}
}
