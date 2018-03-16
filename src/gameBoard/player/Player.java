package gameBoard.player;
import gameBoard.Board;
import gameBoard.weapon.Weapon;
import gameBoard.Coordinate;
import gui.InputHandler;

public abstract class Player {
    private Board board;
    private static InputHandler inputHandler = null;
    
    public Player(Board board) {
    
    	this.board = board;
    }
    
    public InputHandler getInputHandler() {
    	if (inputHandler == null) return new InputHandler();
    	else return inputHandler;
    }
    
	public abstract void play();
	
    public boolean canMove() {
    	if (board.getListOfShips().size() == 0) return false;
		return true;
    }
    
    public void update(Weapon weap,Coordinate coor) {
    	weap.act(board,coor);
    }
    
}
