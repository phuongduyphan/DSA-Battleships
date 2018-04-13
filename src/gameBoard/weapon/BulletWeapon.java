package gameBoard.weapon;

import gameBoard.Board;
import gameBoard.Coordinate;

public class BulletWeapon extends Weapon {
	
	public BulletWeapon(WeaponType type) {
		// TODO Auto-generated constructor stub
		this.type = type;
	}
	@Override
	public void act(Board board, Coordinate coor) {
		// TODO Auto-generated method stub
		board.shootAt(coor);
	}

}
