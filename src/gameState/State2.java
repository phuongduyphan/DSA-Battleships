package gameState;

public class State2 implements IState {
	private static State2 instance = null;

	public static State2 getInstance() {
		if (instance == null)
			return new State2();
		return instance;
	}
	
	public void handle() {
		//TODO implement each state handle
		
	}
	
	public void done() {
		app.getInstance().setStateAndStart(State3.getInstance());
	}
}
