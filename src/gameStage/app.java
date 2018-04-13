package gameStage;

public class app {
	private static app instance = null;
	private IStage currentState;
	
	public static app getInstance() {
		if (instance == null) {
			instance =  new app();
		}
		return instance;
	}
	
	public IStage getCurrentState() {
		return currentState;
	}
	
	public void setStateAndStart(IStage state) {
		this.currentState = state;
		this.start();
	}
	
	public void start() {
		this.currentState.handle();
	}
}
