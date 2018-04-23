package gameBoard.weapon;

import gameBoard.Board;
import gameBoard.Coordinate;
import gameBoard.player.Player;

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
	public void act(Board board, Coordinate coor, Player currentPlayer) {
		Integer row = coor.getRow();
		for (int col = coor.getCol()-2; col <= coor.getCol()+2; col++) {
			board.shootAt(new Coordinate(row, col));
		}
		numberOfWeapon--;
		System.out.println(currentPlayer + "dkm");
		if (numberOfWeapon == 0) currentPlayer.getListOfWeapon().remove(this);
	}

}
