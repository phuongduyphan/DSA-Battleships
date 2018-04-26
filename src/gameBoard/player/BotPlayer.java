package gameBoard.player;

import java.util.ArrayList;
import gameBoard.Board;
import gameBoard.Configurations;
import gameBoard.weapon.Weapon;

public class BotPlayer extends Player {
	private Strategy mode;
	private ArrayList<Player> listOfOpponents;

	public BotPlayer() {
		super();
		listOfOpponents = new ArrayList<>();
	}

	public BotPlayer(Board board, ArrayList<Weapon> listOfWeapon, Strategy mode) {
		super(board, listOfWeapon);
		this.mode = mode;
		listOfOpponents = new ArrayList<>();
	}

	public ArrayList<Player> getListOfOpponents() {
		return listOfOpponents;
	}

	public void setCurrentListOfOpponents() {
		for (int i = 0; i < Configurations.listOfPlayer.size(); i++) {
			if (Configurations.listOfPlayer.get(i) != this) {
				listOfOpponents.add(Configurations.listOfPlayer.get(i));
			}
		}
	}

	@Override
	public void play() {
		// TODO implement DSA
		setCurrentListOfOpponents();
		mode.runMode();
	}

	public void create(Strategy mode) {
		// TODO Auto-generated method stub
		this.mode = mode;
		mode.create();
	}

	public Strategy getMode() {
		return mode;
	}

}
