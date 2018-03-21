package gameState;

public class State4 implements IState{
	private static State4 instance = null;

	public static State4 getInstance() {
		if (instance == null)
			return new State4();
		return instance;
	}
	
	public void handle() {
		//TODO implement each state handle
		
	}
	
	public void done() {
		app.getInstance().setStateAndStart(State1.getInstance());
	}
}
