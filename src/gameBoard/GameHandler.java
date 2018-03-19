package gameBoard;

import gameBoard.player.Player;
import gui.InputHandler;

import java.util.ArrayList;
import java.util.Iterator;

/// TODO: consider turning of singleton for this class, make every instance is created for each game

public class GameHandler {
	private ArrayList<Player> players;
	private Iterator<Player> iterator;
	private Player currentPlayer;
	private InputHandler inputHandler;

	public GameHandler(ArrayList<Player> players, InputHandler inputHandler) {
		// TODO: GameHandler constructor
        this.players = players;
        this.inputHandler = inputHandler;
        iterator = players.iterator();
	}

	public void nextTurn() {
        if(!iterator.hasNext()) {
            iterator = players.iterator();
        }
        currentPlayer = iterator.next();
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
    		if (player != currentPlayer) {
    			if (player.canMove()) return false;
    		}
    	}
    	return true;
    }
}
