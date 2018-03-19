package gameBoard.player;
import gameBoard.Board;
<<<<<<< HEAD
import gameBoard.weapon.Weapon;
import gameBoard.Coordinate;
import gui.InputHandler;
import gui.Command;
import gui.CommandStage3;
import gui.IClickable;

public abstract class Player implements IClickable {
    private Board board;
    
    public Player(Board board) {
    
    	this.board = board;
    }
    
	public abstract void play();
	
    public boolean canMove() {
    	if (board.getListOfShips().size() == 0) return false;
		return true;
    }
    
    public void update(Weapon weap,Coordinate coor) {
    	weap.act(board,coor);
    }

    @Override
    public void onClick(Command targetCommand) {
        if(targetCommand instanceof CommandStage3) {
            CommandStage3 cmd3 = (CommandStage3)targetCommand;
            cmd3.setTargetPlayer(this);
        } else throw new Error("In Player.java, onClick(), the targetCmd is not the right type of Cmd to be used with Player");
    }
}
