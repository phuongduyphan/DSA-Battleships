package gameBoard;

import gameBoard.player.Player;
import gameState.State2;
import gameState.State3;
import gameState.app;

import java.util.ArrayList;
import java.util.Iterator;

import UI.consoleUI.Command;
import UI.consoleUI.CommandStage2;
import UI.consoleUI.CommandStage3;
import UI.consoleUI.ConsoleOutputHandler;

/// TODO: consider turning of singleton for this class, make every instance is created for each game

public class GameHandler {
	private static GameHandler instance;
	private ArrayList<Player> players;
	private Iterator<Player> iterator;
	private Player currentPlayer;

	public static GameHandler getInstance() {
		if (instance == null) {
			instance = new GameHandler();
			instance.players = new ArrayList<>();
		}
		return instance;
	}
	
	public void addPlayers(Player player) {
		players.add(player);
		iterator = players.iterator();
	}
	

	public Player getCurrentPlayer() {
		return currentPlayer;
	}

	public ArrayList<Player> getPlayers() {
		return players;
	}

	public void nextTurn() {
        if(!iterator.hasNext()) {
            iterator = players.iterator();
        }
        currentPlayer = iterator.next();
        System.out.println(currentPlayer.getClass());
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
    	
    	System.out.println(app.getInstance().getCurrentState().getClass());
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
    	o.getTargetPlayer().update(o.getWeapon(),o.getCell().getCoordinate());
    	System.out.println(o.getTargetPlayer().getBoard().getListOfShips().size());
    	ConsoleOutputHandler.getInstance().display(o.getTargetPlayer());
       
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
