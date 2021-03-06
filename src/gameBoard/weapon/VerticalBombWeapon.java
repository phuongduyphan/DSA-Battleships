package gameBoard.weapon;

import gameBoard.Board;
import gameBoard.Coordinate;
import gameBoard.player.Player;

public class VerticalBombWeapon extends Weapon {
	public VerticalBombWeapon(WeaponType type) {
		// TODO Auto-generated constructor stub
		this.type = type;
	}

	public VerticalBombWeapon(WeaponType type,int numberOfWeapon) {
		// TODO Auto-generated constructor stub
		this.type = type;
		this.numberOfWeapon = numberOfWeapon;
	}
	@Override
	public void act(Board board, Coordinate coor,Player currentPlayer) {
		// TODO Auto-generated method stub
		Integer col = coor.getCol();
		for (int row = coor.getRow()-2; row <= coor.getRow()+2; row++) {
			board.shootAt(new Coordinate(row, col));
		}
		numberOfWeapon--;
		if (numberOfWeapon == 0) currentPlayer.getListOfWeapon().remove(this);
	}

}
