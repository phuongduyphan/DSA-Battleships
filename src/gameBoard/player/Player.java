package gameBoard.player;

import java.util.ArrayList;
import UI.Command;
import UI.CommandStage3;
import UI.IClickable;
import UI.UI;
import gameBoard.Board;
import gameBoard.weapon.Weapon;
import gameBoard.weapon.WeaponType;
import gameBoard.Coordinate;

public abstract class Player implements IClickable {
    private Board board;
    private ArrayList<Weapon> listOfWeapon = new ArrayList<Weapon>();
    private UI ui;
    protected Strategy mode;
    
    public Player() {
    	
    }
    
    public Player(Board board,ArrayList<Weapon> listOfWeapon) {
    
    	this.board = board;
    	this.listOfWeapon = listOfWeapon;
    	
    }
    
	public void setListOfWeapon(ArrayList<Weapon> listOfWeapon) {
		this.listOfWeapon = listOfWeapon;
	}

	public ArrayList<Weapon> getListOfWeapon() {
		return listOfWeapon;
	}

	public abstract void play();
	
	public void setBoard(Board board) {
		this.board = board;
	}

	public Board getBoard() {
		return board;
	}
	
    public boolean canMove() {
    	return (board.getListOfShips().size() == 0) ? false:true;
    }
    
    public void update(Weapon weap,Coordinate coor, Player opponent) {
    	weap.act(board,coor,opponent);
    }

    @Override
    public void onClick(Command targetCommand) {
        if(targetCommand instanceof CommandStage3) {
            CommandStage3 cmd3 = (CommandStage3)targetCommand;
            cmd3.setTargetPlayer(this);
        } else throw new Error("In Player.java, onClick(), the targetCmd is not the right type of Cmd to be used with Player");
    }
    
    public Weapon findWeapon(WeaponType type) {
    	for (int i=0; i<listOfWeapon.size(); i++) {
    		if (listOfWeapon.get(i).getType() == type) return listOfWeapon.get(i);
    	}
    	return null;
    }

	public UI getUi() {
		return ui;
	}

	public void setUi(UI ui) {
		this.ui = ui;
	}
}
