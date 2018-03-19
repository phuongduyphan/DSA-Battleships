package gameBoard.weapon;

import gameBoard.Board;
import gameBoard.Coordinate;

public abstract class Weapon {
	
	private Image img;
	
	public Weapon() {}

	public Image getImg() {
		return img;
	}

	public void setImg(Image img) {
		this.img = img;
	}
	
	public abstract void act(Board board, Coordinate coor);
}
