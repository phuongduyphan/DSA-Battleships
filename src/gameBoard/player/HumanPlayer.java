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
	
	public void create() {
		super.setBoard(new Board(8,8));
		
		ArrayList<Weapon> listWeaponOfHuman = new ArrayList<>();
		listWeaponOfHuman.add(WeaponFactory.getInstance().create(WeaponType.BULLET_SHOT,
				Configurations.numberOfColumns * Configurations.numberOfRows));
		listWeaponOfHuman.add(WeaponFactory.getInstance().create(WeaponType.ROCKET, 3));
		listWeaponOfHuman.add(WeaponFactory.getInstance().create(WeaponType.HORIZONTAL_BOMBING, 1));
		listWeaponOfHuman.add(WeaponFactory.getInstance().create(WeaponType.VERTICAL_BOMBING, 2));
		 
		super.setListOfWeapon(listWeaponOfHuman);
		super.setUi(new GUI(this));
	}
}
