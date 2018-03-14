package gameBoard.weapon;

import gameBoard.Board;
import gameBoard.Coordinate;

public class BulletWeapon extends Weapon {

	@Override
	public void act(Board board, Coordinate coor) {
		// TODO Auto-generated method stub
		board.shootAt(coor);
	}

}
