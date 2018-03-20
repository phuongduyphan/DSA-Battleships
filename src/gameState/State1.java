package gameState;

public class State1 implements IState {
	private static State1 instance = null;
	
	public static State1 getInstance() {
		if (instance == null) return new State1();
		return instance;
	}
	
	public void handle() {
		//TODO implement each state handle
		
		setNextState();
	}
	
	private void setNextState() {
		app.getInstance().setState(State2.getInstance());
	}
}
