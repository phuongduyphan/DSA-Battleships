package gameBoard.player;
import java.util.ArrayList;

import gameBoard.Board;
import gameBoard.weapon.Weapon;
import gameBoard.Coordinate;
import gui.InputHandler;
import gui.Command;
import gui.CommandStage3;
import gui.IClickable;

public abstract class Player implements IClickable {
    private Board board;
    private ArrayList<Weapon> listOfWeapon = new ArrayList<Weapon>();
    
    public Player(Board board,ArrayList<Weapon> listOfWeapon) {
    
    	this.board = board;
    	this.listOfWeapon = listOfWeapon;
    	
    }
    
    
    
	public ArrayList<Weapon> getListOfWeapon() {
		return listOfWeapon;
	}



	public abstract void play();
	
	public Board getBoard() {
		return board;
	}
	
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
