package gameBoard.weapon;

import gameBoard.Board;
import gameBoard.Coordinate;

public class HorizontalBombWeapon extends Weapon {
	public HorizontalBombWeapon(WeaponType type) {
		this.type = type;
	}
	
	public HorizontalBombWeapon(WeaponType type,int numberOfWeapon) {
		// TODO Auto-generated constructor stub
		this.type = type;
		this.numberOfWeapon = numberOfWeapon;
	}
	
	@Override
	public void act(Board board, Coordinate coor) {
		Integer row = coor.getRow();
		for (int col = coor.getCol()-2; col <= coor.getCol()+2; col++) {
			board.shootAt(new Coordinate(row, col));
		}
	}

}
