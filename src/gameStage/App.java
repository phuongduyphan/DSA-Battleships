package gameStage;

public class App {
	private static App instance = null;
	private IStage currentState;
	
	public static App getInstance() {
		if (instance == null) {
			instance =  new App();
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
