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
		
		setNextState();
	}
	
	private void setNextState() {
		app.getInstance().setState(State3.getInstance());
	}
}
