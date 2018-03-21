package gameState;

import gameBoard.GameHandler;

public class State3 implements IState {
	private static State3 instance = null;

	public static State3 getInstance() {
		if (instance == null)
			return new State3();
		return instance;
	}
	
	public void handle() {
		// start playing game
		GameHandler.getInstance().nextTurn();
		
	}
	
	public void done() {
		app.getInstance().setStateAndStart(State4.getInstance());
	}
}
