package gameBoard.player;

import java.util.ArrayList;

import UI.gui.GUI;
import gameBoard.Board;
import gameBoard.Configurations;
import gameBoard.weapon.Weapon;
import gameBoard.weapon.WeaponFactory;
import gameBoard.weapon.WeaponType;
import gameStage.Stage3;

public class HumanPlayer extends Player{
	private Strategy mode;
	
	public HumanPlayer() {
		super();
	}
	
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
	
	public void createGUI() {
		super.setUi(new GUI(this));
	}
	
	public void create(Strategy mode) {
		this.mode = mode;
		mode.createHuman(this);
	}

	public Strategy getMode() {
		return mode;
	}

	public void setMode(Strategy mode) {
		this.mode = mode;
	}
	
}
