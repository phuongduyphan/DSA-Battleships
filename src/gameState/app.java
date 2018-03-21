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
	
	public void setStateAndStart(IState state) {
		this.currentState = state;
		this.start();
	}
	
	public void start() {
		this.currentState.handle();
	}
}
