package gameBoard.weapon;

import gameBoard.Board;
import gameBoard.Coordinate;

public class RocketWeapon extends Weapon {
	
	public RocketWeapon(WeaponType type) {
		// TODO Auto-generated constructor stub
		this.type = type;
	}
	@Override
	public void act(Board board, Coordinate coor) {
		// TODO Auto-generated method stub
		for (int row = coor.getRow() - 1; row <= coor.getRow() + 1; row++) {
			for (int col = coor.getCol() - 1; col <= coor.getCol() + 1; col++) {
				board.shootAt(new Coordinate(row, col));
			}
		}

	}

}
