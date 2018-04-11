package gameBoard.weapon;

import UI.consoleUI.Command;
import UI.consoleUI.CommandStage3;
import UI.consoleUI.IClickable;
import gameBoard.Board;
import gameBoard.Coordinate;

public abstract class Weapon implements IClickable {
	
//	private Image img;
//	
	public Weapon() {}
//
//	public Image getImg() {
//		return img;
//	}
//
//	public void setImg(Image img) {
//		this.img = img;
//	}
	

	public abstract void act(Board board, Coordinate coor);

	@Override
	public void onClick(Command targetCommand) {
		if(targetCommand instanceof CommandStage3) {
			CommandStage3 cmd3 = (CommandStage3) targetCommand;
			cmd3.setWeapon(this);
		} else {
		    throw new Error("In Weapon.java, onClick(), the targetCmd is not the right type of Cmd to be used with Weapon");
        }
	}
}
