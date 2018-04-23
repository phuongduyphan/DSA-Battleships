package gameBoard.weapon;

import UI.Command;
import UI.CommandStage3;
import UI.IClickable;
import gameBoard.Board;
import gameBoard.Coordinate;
import gameBoard.player.Player;

public abstract class Weapon implements IClickable {
	protected int numberOfWeapon;
	protected WeaponType type;
//
//	public Image getImg() {
//		return img;
//	}
//
//	public void setImg(Image img) {
//		this.img = img;
//	}
	public WeaponType getType() {
		return type;
	}

	public abstract void act(Board board, Coordinate coor, Player currentPlayer);

	@Override
	public void onClick(Command targetCommand) {
		if(targetCommand instanceof CommandStage3) {
			CommandStage3 cmd3 = (CommandStage3) targetCommand;
			cmd3.setWeapon(this);
		} else {
		    throw new Error("In Weapon.java, onClick(), the targetCmd is not the right type of Cmd to be used with Weapon");
        }
	}
	public int getNumberOfWeapon() {
		return numberOfWeapon;
	}
	public void setNumberOfWeapon(int numberOfWeapon) {
		this.numberOfWeapon = numberOfWeapon;
	}
}
