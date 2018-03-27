package gameBoard;

import java.util.ArrayList;

import gameBoard.player.BotPlayer;
import gameBoard.player.HumanPlayer;
import gameBoard.player.Player;

public class Configuration {
	private Integer numberOfColumn = 8;
	private Integer numberOfRow = 8;
	private ArrayList<Player> players = new ArrayList<>(); 
	
	public void init() {
//		players.add(new HumanPlayer());
//		players.add(new BotPlayer());
	}

}
