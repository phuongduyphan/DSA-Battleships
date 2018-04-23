package gameBoard.weapon;

import gameBoard.Board;
import gameBoard.Coordinate;
import gameBoard.player.Player;

public class RocketWeapon extends Weapon {
	public RocketWeapon(WeaponType type) {
		// TODO Auto-generated constructor stub
		this.type = type;
	}
	
	public RocketWeapon(WeaponType type,int numberOfWeapon) {
		// TODO Auto-generated constructor stub
		this.type = type;
		this.numberOfWeapon = numberOfWeapon;
	}
	@Override
	public void act(Board board, Coordinate coor,Player currentPlayer) {
		// TODO Auto-generated method stub
		board.shootAt(new Coordinate(coor.getRow(), coor.getCol()));
		board.shootAt(new Coordinate(coor.getRow()-1, coor.getCol()));
		board.shootAt(new Coordinate(coor.getRow(), coor.getCol()+1));
		board.shootAt(new Coordinate(coor.getRow()+1, coor.getCol()));
		board.shootAt(new Coordinate(coor.getRow(), coor.getCol()-1));
		numberOfWeapon--;
		if (numberOfWeapon == 0) currentPlayer.getListOfWeapon().remove(this);
	}

}
