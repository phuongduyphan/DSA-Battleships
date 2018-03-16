package gameBoard;

import com.sun.corba.se.pept.encoding.InputObject;
import gameBoard.player.Player;

import java.util.ArrayList;
import java.util.Iterator;

/// TODO: consider turning of singleton for this class, make every instance is created for each game

public class GameHandler {
	private ArrayList<Player> players;
	private Iterator<Player> iterator;
	private Player currentPlayer = new Player();

	public GameHandler(ArrayList<Player> players) {
		// TODO: GameHandler constructor
        this.players = players;
        iterator = players.iterator();
	}

	public void nextTurn() {
	    if(!iterator.hasNext()) {
	        iterator = players.iterator();
	    }
		if (iterator == players.iterator()) currentPlayer = players.get(0);
		else currentPlayer = iterator.next();
		
		currentPlayer.play();
		
    }

    /// receive input from inputHandler
    public void input(InputObject o){
        this.process(o);
    }

    private void process(InputObject o) {
        /// TODO: make sense of the input and update players accordingly
    	o.player.update(o.weapon,o.coor);
    	OutputHandler.getInstance().draw(o.player);
        /// TODO: check win

    	/// if (this.checkWin()) move to the next Stage; 
        
    	///if there is no winner yet
        this.nextTurn();
        /// if else
        /// app.win(winner) ????
    }
    
    private boolean checkWin() {
    	for (Player player: players) {
    		if (player.canMove()) return false; 
    	}
    	return true;
    }
}
