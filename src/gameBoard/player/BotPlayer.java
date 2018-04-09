package gameBoard.player;
import java.util.ArrayList;

import gameBoard.Board;
import gameBoard.Coordinate;
import gameBoard.GameHandler;
import gameBoard.weapon.Weapon;

public class BotPlayer extends Player {
	private Strategy mode;
	private ArrayList<Player> listOfOpponents;
	
	public BotPlayer(Board board, ArrayList<Weapon> listOfWeapon,Strategy mode) {
		super(board, listOfWeapon);
		this.mode = mode;
		listOfOpponents = new ArrayList<>();
	}
	
	public ArrayList<Player> getListOfOpponents() {
		return listOfOpponents;
	}
	
	public void setCurrentListOfOpponents() {
		for (int i=0; i < GameHandler.getInstance().getPlayers().size(); i++) {
			if (GameHandler.getInstance().getPlayers().get(i) != this) {
				listOfOpponents.add(GameHandler.getInstance().getPlayers().get(i));
			}
		}
	}

	@Override
	public void play() {
		// TODO implement DSA
		setCurrentListOfOpponents();
		mode.runMode();
	}
}
