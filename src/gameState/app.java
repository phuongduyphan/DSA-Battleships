package gameState;

public class app {
	private static app instance = null;
	private IState currentState;
	
	public static app getInstance() {
		if (instance == null) return new app();
		return instance;
	}
	
	public IState getCurrentState() {
		return currentState;
	}
	
	public void setState(IState state) {
		this.currentState = state;
	}
	
}
