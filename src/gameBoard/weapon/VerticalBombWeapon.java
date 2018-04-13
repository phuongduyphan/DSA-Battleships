package gameBoard.weapon;

import gameBoard.Board;
import gameBoard.Coordinate;

public class VerticalBombWeapon extends Weapon {

	public VerticalBombWeapon(WeaponType type) {
		// TODO Auto-generated constructor stub
		this.type = type;
	}
	@Override
	public void act(Board board, Coordinate coor) {
		// TODO Auto-generated method stub
		Integer col = coor.getCol();
		for (int row = 0; row < board.getNumberOfRows(); row++) {
			board.shootAt(new Coordinate(row, col));
		}
	}

}
