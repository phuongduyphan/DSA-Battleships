package gameBoard;

public class GameHandler {
	private static GameHandler instance;
	private Turn currentTurn;

	private GameHandler() {

	}
	
	public static GameHandler getInstance() {
		if (instance == null) {
			instance = new GameHandler();
		}
		return instance;
	}

	public Turn getCurrentTurn() {
		return currentTurn;
	}

	public void setCurrentTurn(Turn currentTurn) {
		this.currentTurn = currentTurn;
	}
}
