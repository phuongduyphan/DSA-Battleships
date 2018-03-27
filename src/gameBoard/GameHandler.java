package gameBoard;

import gameBoard.player.Player;
import gameState.State2;
import gameState.State3;
import gameState.app;
import gui.Command;
import gui.CommandStage2;
import gui.CommandStage3;

import java.util.ArrayList;
import java.util.Iterator;

/// TODO: consider turning of singleton for this class, make every instance is created for each game

public class GameHandler {
	private static GameHandler instance;
	private ArrayList<Player> players;
	private Iterator<Player> iterator;
	private Player currentPlayer;

	public static GameHandler getInstance() {
		if (instance == null) return new GameHandler();
		return instance;
	}
	
	public void setPlayers(ArrayList<Player> players) {
		this.players = players;
	}

	public void nextTurn() {
        if(!iterator.hasNext()) {
            iterator = players.iterator();
        }
        currentPlayer = iterator.next();
        currentPlayer.play();
    }

    /// receive input from inputHandler
    public void input(Command o){
    	if(app.getInstance().getCurrentState() instanceof State2) {
    		try {
    			processStage2((CommandStage2) o);
    		}
    		catch (Exception e) {
    			
    		}
    	}
    	
    	if(app.getInstance().getCurrentState() instanceof State3) {
    		try {
    			processStage3((CommandStage3) o);
    		}
    		catch (Exception e) {
    			
    		}
    	}
    }
    
    private void processStage2(CommandStage2 o) {
    	
    }

    private void processStage3(CommandStage3 o) {
    	o.getTargetPlayer().update(o.getWeapon(),o.getCell());
    	OutputHandler.getInstance().draw(o.getTargetPlayer());
       
    	if (!checkWin()) this.nextTurn();
    	else {
    		State3.getInstance().done();
    	}
    }
    
    private boolean checkWin() {
    	for (Player player: players) {
    		if (player != currentPlayer) {
    			if (player.canMove()) return false;
    		}
    	}
    	return true;
    }
    
    public void reset() {
    	this.players = null;
    	this.iterator = null;
    	this.currentPlayer = null;
    }
}
