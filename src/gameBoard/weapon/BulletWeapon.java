package gameBoard.weapon;

import gameBoard.Board;
import gameBoard.Coordinate;
import gameBoard.player.Player;

public class BulletWeapon extends Weapon {
	public BulletWeapon(WeaponType type) {
		this.type = type;
	}
	public BulletWeapon(WeaponType type,int numberOfWeapon) {
		// TODO Auto-generated constructor stub
		this.type = type;
		this.numberOfWeapon = numberOfWeapon;
	}
	@Override
	public void act(Board board, Coordinate coor, Player currentPlayer) {
		// TODO Auto-generated method stub
		board.shootAt(coor);
		numberOfWeapon--;
		if (numberOfWeapon == 0) currentPlayer.getListOfWeapon().remove(this);
	}

}
