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
		//TODO implement each state handle
		
		// TODO: init

        // TODO: choose gamemode, create player and init gameHandler accordingly
        GameHandler gameHandler = new GameHandler();

        // TODO: user place ship sthing

        // TODO: user click start?
        gameHandler.nextTurn();
		
		setNextState();
	}
	
	private void setNextState() {
		app.getInstance().setState(State4.getInstance());
	}
}
