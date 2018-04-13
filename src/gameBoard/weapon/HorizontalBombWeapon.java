package gameBoard.weapon;

import gameBoard.Board;
import gameBoard.Coordinate;

public class HorizontalBombWeapon extends Weapon {
	public HorizontalBombWeapon(WeaponType type) {
		// TODO Auto-generated constructor stub
		this.type = type;
	}
	
	@Override
	public void act(Board board, Coordinate coor) {
		Integer row = coor.getRow();
		for (int col = 0; col < board.getNumberOfColumns(); col++) {
			board.shootAt(new Coordinate(row, col));
		}
	}

}
